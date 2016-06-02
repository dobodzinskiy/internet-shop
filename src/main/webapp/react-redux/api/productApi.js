var $ = require('jquery');
var { getProducts, getProduct, changePages, addProduct, getComments, postComment, deleteComment, changeProduct, changeAvailable } = require('../actions/productActions');
var store = require('../store');

module.exports = {
    getProducts: function (productType, page, sort) {
        var url = '/products/' + productType;
        return $.ajax({
            url: url,
            data: { page: page, sort: sort },
            type: 'GET',
            success: (data) => {
                store.dispatch(getProducts(data));
            }
        })
    },
    getPages: function(productType) {
        var url = '/products/pages/' + productType;
        return $.ajax({
            url: url,
            type: 'GET',
            success: (data) => {
                store.dispatch(changePages(data));
            }
        })
    },
    getProduct: function (productType, productId) {
        var url = 'products/' + productType + '/' + productId;
        return $.ajax({
            url: url,
            type: 'GET',
            success: (response) => {
                store.dispatch(getProduct(response));
            }
        })
    },
    addProduct: function (product) {
        var url = 'products/' + product.type + '/add';
        $.ajax({
            url: url,
            data: JSON.stringify(product),
            type: "POST",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function (data) {
                alert("Product " + data.name + " was successfully added!");
                store.dispatch(addProduct(data));
            }
        });
    },
    changeProduct: function (product) {
        var url = 'products/' + product.type;
        $.ajax({
            url: url,
            data: JSON.stringify(product),
            type: "PUT",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function (data) {
                store.dispatch(changeProduct(data));
            },
            error: function(xhr) {
                if(xhr.status == 401) {
                    alert("Access denied!");
                }
            }
        });
    },
    getComments: function (productId) {
        var url = 'products/comments/' + productId;
        return $.get(url, data => {
            store.dispatch(getComments(data))
        });
    },
    postComment: function (comment) {
        var url = 'products/comments/add';
        $.ajax({
            url: url,
            data: JSON.stringify(comment),
            type: "POST",
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function (data) {
                store.dispatch(postComment(data));
            }
        });
    },
    deleteComment: function (commentId) {
        var url = 'products/comments/' + commentId;
        $.ajax({
            url: url,
            type: 'DELETE',
            beforeSend: function (xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function () {
                store.dispatch(deleteComment(commentId));
            }
        })
    },
    changeAvailable: function(productId) {
        var url = '/products/available/' + productId;
        $.ajax({
            url: url,
            type: "PUT",
            success: function () {
                store.dispatch(changeAvailable());
            }
        });
    }
};