const express = require('express');
const methodOverride = require('method-override')
const exphbs = require('express-handlebars');
const path = require('path');
const bodyParser = require('body-parser');
const NodeGeocoder = require('node-geocoder');
const redis = require('redis');
const fs = require('fs');


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

//redis client
const client = redis.createClient();

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
            client.hmset(element.id, ['name', element.name, 'address', element.address, 'map', element.map, 'lat', element.lat, 'lon', element.lon ], (err, reply) => {
                if(err){
                    console.log(err);
                }
                console.log(reply);
            } );
        }, this);
    }
    hrend = process.hrtime(hrstart);
    console.info("Execution time (hr): %ds %dms", hrend[0], hrend[1]/1000000);

    res.render('searchlab');
});

app.post('/lab/search', (req, res, next) => {
   const id = req.body.id;

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
app.listen( process.env.PORT || port, () => {
    console.log('Server started');
});