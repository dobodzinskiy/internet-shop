var Redux = require('redux') ;
var productReducer = require('./productReducer');
var profileReducer = require('./profileReducer');
var ordersReducer = require('./orderReducer');
var cartReducer = require('./cartReducer');
var clientsReducer = require('./clientsReducer');

module.exports = Redux.combineReducers({
    productState : productReducer,
    userState : profileReducer,
    ordersState : ordersReducer,
    cartState : cartReducer,
    clientsState : clientsReducer
});