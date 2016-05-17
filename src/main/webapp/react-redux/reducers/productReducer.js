var types = require('../actions/actionTypes');
const initialProductState = {
    products: [],
    product: [],
    comments: [],
    isOpenAddProductModal : false
};
module.exports = function(state = initialProductState, action) {
    switch(action.type) {
        case types.SHOW_ADD_PRODUCT_MODAL :
            return Object.assign({}, state, {
                isOpenAddProductModal : !state.isOpenAddProductModal
            });
        case types.GET_PRODUCTS :
            return Object.assign({}, state, {
                products : action.products
            });
        case types.GET_PRODUCT :
            return Object.assign({}, state, {
                product : action.product
            });
        case types.CHANGE_PRODUCT :
            return Object.assign({}, state, {
               product : action.product
            });
        case types.GET_COMMENTS :
            return Object.assign({}, state, {
               comments : action.comments 
            });
        case types.POST_COMMENT :
            var newComments = [action.comment].concat(state.comments);
            return Object.assign({}, state, {
                comments : newComments
            });
        case types.DELETE_COMMENT :
            var newComments = state.comments.filter(comment => comment.id != action.commentId);
            return Object.assign({}, state, {
                comments : newComments
            });
        default : return state;
    }
};