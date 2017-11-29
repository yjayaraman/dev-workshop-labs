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


//initialize redis client


var locations;

app.get('/',(req,res,next) => {
    var hrstart = process.hrtime();

    if (typeof locations == 'undefined') {
        var data = fs.readFileSync('json/locations.json');
        locations = JSON.parse(data);
        locations.forEach(function(element) {
            //Cache locations in Redis

        }, this);
    }
    hrend = process.hrtime(hrstart);
    console.info("Execution time (hr): %ds %dms", hrend[0], hrend[1]/1000000);

    res.render('searchlab');
});

app.post('/lab/search', (req, res, next) => {
   const id = req.body.id;

   //Get the location from Redis

});

app.get('/listlabs', (req,res,next) => {
    res.render('listlabs');
});

app.listen( process.env.PORT || port, () => {
    console.log('Server started');
});