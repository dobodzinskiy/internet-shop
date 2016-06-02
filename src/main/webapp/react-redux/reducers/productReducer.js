var types = require('../actions/actionTypes');
const initialProductState = {
    products: null,
    page: 1,
    pages: 1,
    sort: 'name',
    product: null,
    comments: [],
    isOpenAddProductModal: false
};
var changeAvailable = function(product) {
    return Object.assign({}, product, {
        available : !product.available
    })
};
module.exports = function (state = initialProductState, action) {
    switch (action.type) {
        case types.CLEAN_PRODUCT:
            return Object.assign({}, state, {
                product: null,
                comments: []
            });
        case types.CLEAN_PRODUCTS:
            return Object.assign({}, state, {
                products: null,
                page: 1,
                pages: 1,
                sort: 'name'
            });
        case types.SHOW_ADD_PRODUCT_MODAL :
            return Object.assign({}, state, {
                isOpenAddProductModal: !state.isOpenAddProductModal
            });
        case types.GET_PRODUCTS :
            return Object.assign({}, state, {
                products: action.products
            });
        case types.CHANGE_PAGE :
            return Object.assign({}, state, {
                page: action.page
            });
        case types.CHANGE_PAGES :
            return Object.assign({}, state, {
                pages: action.pages
            });
        case types.CHANGE_SORT :
            return Object.assign({}, state, {
                sort: action.sort
            });
        case types.GET_PRODUCT :
            return Object.assign({}, state, {
                product: action.product
            });
        case types.CHANGE_PRODUCT :
            return Object.assign({}, state, {
                product: action.product
            });
        case types.CHANGE_AVAILABLE :
            return Object.assign({}, state, {
                product: changeAvailable(state.product)
            });
        case types.GET_COMMENTS :
            return Object.assign({}, state, {
                comments: action.comments
            });
        case types.POST_COMMENT :
            var newComments = [action.comment].concat(state.comments);
            return Object.assign({}, state, {
                comments: newComments
            });
        case types.DELETE_COMMENT :
            var newComments = state.comments.filter(comment => comment.id != action.commentId);
            return Object.assign({}, state, {
                comments: newComments
            });
        default :
            return state;
    }
};