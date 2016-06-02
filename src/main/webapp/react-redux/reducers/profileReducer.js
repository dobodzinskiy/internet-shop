var types = require('../actions/actionTypes');

var singleRole = function (user) {
    if (user == null) {
        return null;
    }
    if (user.userRoles.includes('admin')) {
        return 'ROLE_ADMIN';
    } else {
        return 'ROLE_USER';
    }
};
var initialUserState = {
    currentUser: null,
    currentUserRole: null,
    currentUserOrders: null,
    isLoginOpen: false,
    isSignUpOpen: false,
    isChangePasswordOpen: false
};
var toMap = function (orders) {
    orders.forEach((order) => {
        var productsMap = new Map();
        order.products.forEach((product) => {
            product = JSON.stringify(product);
            if (productsMap.has(product)) {
                productsMap.set(product, productsMap.get(product) + 1);
            } else {
                productsMap.set(product, 1);
            }
        });
        order.products = productsMap;
    });
    return orders;
};
var toFavorites = function (product, user) {
    return Object.assign({}, user, {
        products: [product].concat(user.products)
    });
};
var fromFavorites = function (removedProduct, user) {
    var newFavorites = user.products.filter(product => product.id != removedProduct.id);
    return Object.assign({}, user, {
        products: newFavorites
    });
};
module.exports = function (state = initialUserState, action) {
    switch (action.type) {
        case types.LOGIN :
            return Object.assign({}, state, {
                currentUser: action.user,
                currentUserRole: singleRole(action.user),
                isLoginOpen: false,
                isSignUpOpen: false
            });
        case types.LOGOUT :
            return Object.assign({}, state, {
                currentUser: null,
                currentUserRole: null
            });
        case types.SHOW_LOGIN :
            return Object.assign({}, state, {
                isLoginOpen: !state.isLoginOpen
            });
        case types.SHOW_SIGN_UP :
            return Object.assign({}, state, {
                isSignUpOpen: !state.isSignUpOpen
            });
        case types.GET_PROFILE_ORDERS :
            return Object.assign({}, state, {
                currentUserOrders: toMap(action.orders)
            });
        case types.CHANGE_PROFILE :
            return Object.assign({}, state, {
                currentUser: action.profile,
                isChangePasswordOpen: false
            });
        case types.SHOW_CHANGE_PASSWORD :
            return Object.assign({}, state, {
                isChangePasswordOpen: !state.isChangePasswordOpen
            });
        case types.TO_FAVORITES:
            return Object.assign({}, state, {
                currentUser: toFavorites(action.product, state.currentUser)
            });
        case types.FROM_FAVORITES:
            return Object.assign({}, state, {
                currentUser: fromFavorites(action.product, state.currentUser)
            });
        default :
            return state;
    }
};

