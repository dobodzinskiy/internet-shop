var $ = require('jquery');
var { getProducts, getProduct, addProduct, getComments, postComment, deleteComment, changeProduct } = require('../actions/productActions');
var store = require('../store');

module.exports = {
    getProducts : function (productType) {
        var url = '/products/' + productType;
        return $.get(url, data => {
            store.dispatch(getProducts(data))
        });
    },
    getProduct : function (productType, productId) {
        var url = 'products/' + productType + '/' + productId;
        return $.get(url, data => {
            store.dispatch(getProduct(data))
        });
    },
    addProduct : function(product) {
        var url = '';
        switch(product.type) {
            case 'PHONES' :
                url = "products/phones/add";
                break;
            case 'LAPTOPS' :
                url = "products/laptops/add";
                break;
            case 'COMPUTERS' :
                url = "products/computers/add";
                break;
        }
        $.ajax({
            url: url,
            data: JSON.stringify(product),
            type: "POST",
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success : function(data) {
                alert("Product " + data.name + " was successfully added!");
                store.dispatch(addProduct(data));
            }
        });
    },
    changeProduct : function(product) {
        var url = '';
        switch(product.type) {
            case 'PHONES' :
                url = "products/phones/change";
                break;
            case 'LAPTOPS' :
                url = "products/laptops/change";
                break;
            case 'COMPUTERS' :
                url = "products/computers/change";
                break;
        }
        $.ajax({
            url: url,
            data: JSON.stringify(product),
            type: "PUT",
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success : function(data) {
                store.dispatch(changeProduct(data));
            }
        });
    },
    getComments : function (productId) {
        var url = 'products/comments/' + productId;
        return $.get(url, data => {
            store.dispatch(getComments(data))
        });
    },
    postComment : function (comment) {
        var url = 'products/comments/add';
        $.ajax({
            url: url,
            data: JSON.stringify(comment),
            type: "POST",
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success : function(data) {
                store.dispatch(postComment(data));
            }
        });
    },
    deleteComment : function (commentId) {
        var url = 'products/comments/delete';
        $.ajax({
            url : url,
            data : JSON.stringify(commentId),
            type : 'DELETE',
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success : function() {
                store.dispatch(deleteComment(commentId));
            }
        })
    }
};