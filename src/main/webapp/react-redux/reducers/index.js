var Redux = require('redux') ;
var productReducer = require('./productReducer');
var userReducer = require('./userReducer');
var orderReducer = require('./orderReducer');
var cartReducer = require('./cartReducer');

module.exports = Redux.combineReducers({
    productState : productReducer,
    userState : userReducer,
    orderState : orderReducer,
    cartState : cartReducer
});