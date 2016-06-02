var types = require('./actionTypes');

module.exports = {
    getOrdersList: function (orders) {
        return {
            type: types.GET_ORDERS_LIST,
            orders
        }
    },
    changeOrderState: function (order) {
        return {
            type: types.CHANGE_ORDER_STATE,
            order
        }
    }
};
