var Redux = require('redux');
var reducers = require('./reducers/index');

module.exports = Redux.createStore(reducers);
