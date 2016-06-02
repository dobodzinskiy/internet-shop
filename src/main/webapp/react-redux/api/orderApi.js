var $ = require('jquery');
var { getOrdersList, changeOrderState } = require('../actions/orderActions');
var { confirmOrder } = require('../actions/cartActions');
var store = require('../store');

const orderToDto = (order) => {
    var products = [];
    order.products.forEach((value, product) => {
        product = JSON.parse(product);
        for (var i = 0; i < value; i++) {
            var productDto = {
                id: product.id,
                name: product.name,
                photo: product.photo,
                type: product.type
            };
            products.push(productDto)
        }
    });
    return {
        products: products,
        price: order.price,
        orderState: 'ACCEPTED'
    }
};

module.exports = {
    getOrdersList: function () {
        var url = 'orders/';
        $.ajax({
            url: url,
            type: "GET",
            success: function (data) {
                store.dispatch(getOrdersList(data));
            }
        });
    },
    changeOrderState: function(orderId) {
        var url = 'orders/' + orderId + '/change';
        $.ajax({
            url: url,
            type: 'PUT',
            success: function(data) {
                store.dispatch(changeOrderState(data));
            }
        })
    },
    confirmOrder: function (order) {
        var url = 'orders/';
        $.ajax({
            url: url,
            data: JSON.stringify(orderToDto(order)),
            type: "POST",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function (data) {
                alert("Order #" + data.id + " was successfully accepted!");
                store.dispatch(confirmOrder());
            }
        });
    }
};