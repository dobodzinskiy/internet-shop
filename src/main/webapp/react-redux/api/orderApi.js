var $ = require('jquery');
var { getOrdersList, getUserOrders } = require('../actions/orderActions');
var { confirmOrder } = require('../actions/cartActions');
var store = require('../store');

const orderToDto = (order) => {
    var products = [{
        id : '',
        name : ''
    }];
    order.products.forEach( (value, product) => {
        for(var i = 0; i < value; i++) {
            var productDto = {
                id : product.id,
                name : product.name
            };
            products.push(productDto)
        }
    });
    return {
        username : "admin",
        products : products,
        price : order.price
    }
};

module.exports = {
    getOrdersList : function() {
        var url = "orders/";
        return $.get(url, data => {
            store.dispatch(getOrdersList(data))
        })
    },
    getUserOrders : function(userId) {
        var url = "orders/" + userId;
        return $.get(url, data => {
            store.dispatch(getUserOrders(data))
        })
    },
    confirmOrder : function(order) {
        var url = "orders/add";
        
        $.ajax({
            url: url,
            data: JSON.stringify(orderToDto(order)),
            type: "POST",
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success : function(data) {
                alert("Order #" + data + " was successfully accepted!");
                store.dispatch(confirmOrder());
            }
        });
    }
};