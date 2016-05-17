var $ = require('jquery');
var { login, logout } = require('../actions/userActions');
var store = require('../store');

module.exports = {
    login : function(user) {
        $.ajax({
            url: "/login",
            type: "POST",
            beforeSend: function(xhr) {
                xhr.withCredentials = true;
            },
            data: user,
            success: function(data, status) {
                store.dispatch(login(data));
            },
            error: () => {
                alert('Try again please!');
            }
        });
    },
    logout : function() {
        var url = '/j_spring_security_logout';
        $.get(url, data => {
            alert('You was successfully logout!');
            store.dispatch(logout());
        })
    }
};