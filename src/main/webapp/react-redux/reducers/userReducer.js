var types = require('../actions/actionTypes');

var initialUserState = {
    users : [],
    user : [],
    currentUser : null,
    currentUserRole : null,
    isLoginOpen : false
};
var singleRole = function(user) {
    if(user.userRoles.includes('ROLE_ADMIN')) {
        return 'ROLE_ADMIN';
    } else {
        return 'ROLE_USER';
    }
};
module.exports = function(state = initialUserState, action) {
    switch (action.type) {
        case types.LOGIN :
            return Object.assign({}, state, {
                currentUser : action.user,
                currentUserRole : singleRole(action.user),
                isLoginOpen : false
            });
        case types.LOGOUT : 
            return Object.assign({}, state, {
                currentUser : null,
                currentUserRole : null
            });
        case types.SHOW_LOGIN :
            return Object.assign({}, state, {
                isLoginOpen : !state.isLoginOpen
            });
        default : return state;
    }
};

