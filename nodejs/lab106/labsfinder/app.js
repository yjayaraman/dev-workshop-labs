const express = require('express');
const methodOverride = require('method-override')
const exphbs = require('express-handlebars');
const path = require('path');
const bodyParser = require('body-parser');
const NodeGeocoder = require('node-geocoder');
const redis = require('redis');
const fs = require('fs');
const cfenv = require("cfenv")


//Set Port
const port = 3000

//Init App
const app = express();

//View Engine
app.engine('handlebars', exphbs({defaultLayout: 'main'}));
app.set('view engine', 'handlebars');

//Body parser
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: false}));

//static folder
app.use(express.static(path.join(__dirname, "public")));

//method-override
app.use(methodOverride('_method'));

//cfenv
var appEnv = cfenv.getAppEnv();

//initialize redis client
var client;
if (appEnv.isLocal){
   client = redis.createClient();
} else {
    const rediscreds = appEnv.getServiceCreds('my-cache');
    client = redis.createClient({host: rediscreds.host, port: rediscreds.port, password: rediscreds.password});
}

client.on('connect', () => {
    console.log('Redis connected...')
});

var locations;

app.get('/',(req,res,next) => {
    var hrstart = process.hrtime();

    if (typeof locations == 'undefined') {
        var data = fs.readFileSync('json/locations.json');
        locations = JSON.parse(data);
        locations.forEach(function(element) {
            //Cache locations in Redis
            client.hmset(element.id, ['name', element.name, 'address', element.address, 'map', element.map, 'lat', element.lat, 'lon', element.lon ], (err, reply) => {
                if(err){
                    console.log(err);
                }
            } );
        }, this);
    }
    hrend = process.hrtime(hrstart);
    console.info("Execution time (hr): %ds %dms", hrend[0], hrend[1]/1000000);

    res.render('searchlab');
});

app.post('/lab/search', (req, res, next) => {
   const id = req.body.id;

   //Get the location from Redis
   client.hgetall(id, (err,obj)=> {
    if (!obj) {
        res.render('searchlab', {
            error: 'Invalid Lab ID'
        });
    } else {
        console.log(obj.name);
        console.log(obj.address);
        console.log(obj.lat);
        console.log(obj.lon);
        res.render('details', {lab: obj});
    }
    });
});

app.get('/listlabs', (req,res,next) => {
    res.render('listlabs');
});

app.get('/addlabs', (req,res,next) => {
    res.render('addlabs');
});

app.listen( process.env.PORT || port, () => {
    console.log('Server started');
});