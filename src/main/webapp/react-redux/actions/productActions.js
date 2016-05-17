var types = require('./actionTypes');

module.exports = {
    showAddProductModal : function() {
        return {
            type : types.SHOW_ADD_PRODUCT_MODAL
        }
    },
    getProducts : function (products) {
        return {
            type : types.GET_PRODUCTS,
            products
        }
    },
    getProduct : function(product) {
        return {
            type : types.GET_PRODUCT,
            product
        }
    },
    addProduct : function(data) {
        return {
            type : types.ADD_PRODUCT,
            data
        }
    },
    changeProduct : function(product) {
        return {
            type : types.CHANGE_PRODUCT,
            product
        }
    },
    getComments : function(comments) {
        return {
            type : types.GET_COMMENTS,
            comments
        }
    },
    postComment : function(comment) {
        return {
            type : types.POST_COMMENT,
            comment
        }
    },
    deleteComment : function(commentId) {
        return {
            type : types.DELETE_COMMENT,
            commentId
        }
    }
};