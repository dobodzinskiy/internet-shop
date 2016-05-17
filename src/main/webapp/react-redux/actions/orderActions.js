var types = require('./actionTypes');

module.exports = {
    getOrdersList : function(orders) {
        return {
            type : types.GET_ORDERS_LIST,
            orders
        }
    },
    getUserOrders : function(orders) {
        return {
            type : types.GET_USER_ORDERS,
            orders
        }
    }
};
