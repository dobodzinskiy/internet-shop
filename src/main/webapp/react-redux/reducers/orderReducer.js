var types = require('../actions/actionTypes');
var $ = require('jquery');
const initialProductState = {
    orders: []
};
var changeOrderState = function (newOrder, orders) {
    var newOrders = orders.concat();
    newOrders = newOrders.map((order) => {
        if (order.id == newOrder.id) {
            order.orderState = newOrder.orderState;
        }
        return order
    });
    return newOrders;
};
var toMap = function (orders) {
    orders.forEach((order) => {
        var productsMap = new Map();
        order.products.forEach((product) => {
            product = JSON.stringify(product);
            if (productsMap.has(product)) {
                productsMap.set(product, productsMap.get(product) + 1);
            } else {
                productsMap.set(product, 1);
            }
        });
        order.products = productsMap;
    });
    return orders;
};
module.exports = function (state = initialProductState, action) {
    switch (action.type) {
        case types.GET_ORDERS_LIST:
            return Object.assign({}, state, {
                orders: toMap(action.orders)
            });
        case types.CHANGE_ORDER_STATE:
            return Object.assign({}, state, {
                orders: changeOrderState(action.order, state.orders)
            });
        default:
            return state;
    }
};

