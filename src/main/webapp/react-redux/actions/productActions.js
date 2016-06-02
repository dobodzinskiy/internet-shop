var types = require('./actionTypes');

module.exports = {
    cleanProduct: function () {
        return {
            type: types.CLEAN_PRODUCT
        }
    },
    cleanProducts: function () {
        return {
            type: types.CLEAN_PRODUCTS
        }
    },
    showAddProductModal: function () {
        return {
            type: types.SHOW_ADD_PRODUCT_MODAL
        }
    },
    getProducts: function (products) {
        return {
            type: types.GET_PRODUCTS,
            products
        }
    },
    changePage: function(page) {
        return {
            type: types.CHANGE_PAGE,
            page
        }
    },
    changeSort: function(sort) {
        return {
            type: types.CHANGE_SORT,
            sort
        }
    },
    changePages: function(pages) {
        return {
            type: types.CHANGE_PAGES,
            pages
        }
    },
    getProduct: function (product) {
        return {
            type: types.GET_PRODUCT,
            product
        }
    },
    addProduct: function (data) {
        return {
            type: types.ADD_PRODUCT,
            data
        }
    },
    changeProduct: function (product) {
        return {
            type: types.CHANGE_PRODUCT,
            product
        }
    },
    getComments: function (comments) {
        return {
            type: types.GET_COMMENTS,
            comments
        }
    },
    postComment: function (comment) {
        return {
            type: types.POST_COMMENT,
            comment
        }
    },
    deleteComment: function (commentId) {
        return {
            type: types.DELETE_COMMENT,
            commentId
        }
    },
    changeAvailable: function(productId) {
        return {
            type: types.CHANGE_AVAILABLE,
            productId
        }
    }
};