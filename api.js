const express = require('express');
const bodyParser = require('body-parser');
const jsonfile = require('jsonfile');
const fs = require('fs');
const path = require('path');
const cors = require('cors');

const app = express();
const port = 3000;
const stdin = process.openStdin();

app.use(bodyParser.urlencoded());
app.use(bodyParser.json());
app.use(cors());

const map = new Map();

var p1 = new Person("1234", "Ece Kayan", "Hello I am homeless", 10);
var p2 = new Person("1235", "Malina", "Hello I am homeless", 10);
var p3 = new Person("1236", "Feroz", "Hello I am homeless", 10);

map.set("1234", p1);
map.set("1235", p2);
map.set("1236", p3);

function Person(id, name, info, balance) {
  this.id = id;
  this.name = name;
  this.info = info;
	this.balance = balance;
}

/* Get all TCRs */
//app.get('/people/', (req, res) => {
//  res.json(JSON.stringify([...map]));
//});

/* Create a new TCR */
app.post('/people/', (req, res) => {
  const id = (Math.round((new Date()).getTime() / 1000)).toString();
  const newPerson = new People(
    id, req.body.name, req.body.info, req.body.balance
  );
});

/* Get a specific TCR */
app.get('/people/:id', (req, res) => {
  res.json(map.get(req.params.id));
});

/* Update fields of a song */
app.put('/people/', (req, res) => {
  const person = map.get(parseInt(req.body.id));
	console.log(person)
	person.balance = req.body.balance;
	map.set(req.body.id, person);
	res.json(person.id)
});

///* Add person */
//app.post('/people/:id/person', (req, res) => {
//  const person = map.get(req.params.id);
//  
//  map.set(id, newPerson);
//});

///* Get all songs associated with the given TCR */
//app.get('/people/:id/person', (req, res) => {
//  const person = map.get(req.params.id);
//  database.getListings(person.name).then((result) => {
//    res.json(result);
//  });
//});

app.listen(port, () => console.log(`iHelp server app listening on port ${port}!`));
