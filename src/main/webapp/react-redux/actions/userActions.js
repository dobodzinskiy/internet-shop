var types = require('./actionTypes');

module.exports = {
    login : function(user) {
        return {
            type : types.LOGIN,
            user
        }
    },
    logout : function() {
        return {
            type : types.LOGOUT
        }
    },
    showLogin : function() {
        return {
            type : types.SHOW_LOGIN
        }
    }
};