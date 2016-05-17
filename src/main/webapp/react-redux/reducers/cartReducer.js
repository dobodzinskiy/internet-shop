var types = require('../actions/actionTypes');

const initialCartState = {
    productsMap : new Map(),
    isCartOpen : false,
    totalPrice : 0,
    amount : 0
};
const toCart = (map, action) => {
    if(map.has(action.product)) {
        map.set(action.product, map.get(action.product) + 1)
    }
    else {
        map.set(action.product, 1)
    }
    return map;
};
const subtract = (map, action) => {
    if(map.get(action.product) > 1) {
        map.set(action.product, map.get(action.product) - 1);
    }
    else {
        map.delete(action.product);
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
                productsMap : toCart(newMap, action),           //TODO make working buy in productPage, do via jquery (toCart(id))
                totalPrice : state.totalPrice + action.product.price,
                amount : state.amount + 1
            });
        case types.FROM_CART :
            var newPrice = state.totalPrice - action.product.price * newMap.get(action.product);
            var newAmount = state.amount - newMap.get(action.product);
            newMap.delete(action.product);
            return Object.assign({}, state, {
                productsMap : newMap,
                totalPrice : newPrice,
                amount : newAmount
            });
        case types.ADD_IN_CART :
            newMap.set(action.product, newMap.get(action.product) + 1);
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
