var types = require('../actions/actionTypes');

const initialCartState = {
    productsMap : new Map(),
    isCartOpen : false,
    totalPrice : 0,
    amount : 0
};
const toCart = (map, action) => {
    var product = JSON.stringify(action.product);
    if(map.has(product)) {
        map.set(product, map.get(product) + 1)
    }
    else {
        map.set(product, 1)
    }
    return map;
};
const subtract = (map, action) => {
    var product = JSON.stringify(action.product);
    if(map.get(product) > 1) {
        map.set(product, map.get(product) - 1);
    }
    else {
        map.delete(product);
    }
    return map;
};

module.exports = function(state = initialCartState, action) {
    var newMap = new Map(state.productsMap);
    switch(action.type) {
        case types.SHOW_CART :
            return Object.assign({}, state, {
                isCartOpen : !state.isCartOpen
            });
        case types.TO_CART :
            return Object.assign({}, state, {
                productsMap : toCart(newMap, action),
                totalPrice : state.totalPrice + action.product.price,
                amount : state.amount + 1
            });
        case types.FROM_CART :
            var newPrice = state.totalPrice - action.product.price * newMap.get(JSON.stringify(action.product));
            var newAmount = state.amount - newMap.get(JSON.stringify(action.product));
            newMap.delete(JSON.stringify(action.product));
            return Object.assign({}, state, {
                productsMap : newMap,
                totalPrice : newPrice,
                amount : newAmount
            });
        case types.ADD_IN_CART :
            var product = JSON.stringify(action.product);
            newMap.set(product, newMap.get(product) + 1);
            return Object.assign({}, state, {
                productsMap : newMap,
                totalPrice : state.totalPrice + action.product.price,
                amount : state.amount + 1
            });
        case types.SUBTRACT_IN_CART :
            return Object.assign({}, state, {
                productsMap : subtract(newMap, action),
                totalPrice : state.totalPrice - action.product.price,
                amount : state.amount - 1
            });
        case types.CONFIRM_ORDER :
            return initialCartState;
        default : return state;
    }
};
