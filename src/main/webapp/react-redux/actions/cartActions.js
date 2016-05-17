var types = require('./actionTypes');

module.exports = {
    toCart : function(product) {
        return {
            type : types.TO_CART,
            product
        }
    },
    fromCart : function(product) {
        return {
            type : types.FROM_CART,
            product
        }
    },
    addInCart : function(product) {
        return {
            type : types.ADD_IN_CART,
            product
        }
    },
    subtractInCart : function(product) {
        return {
            type : types.SUBTRACT_IN_CART,
            product
        }
    },
    showCart : function() {
        return {
            type : types.SHOW_CART
        }
    },
    confirmOrder : function() {
        return {
            type : types.CONFIRM_ORDER
        }
    }
};