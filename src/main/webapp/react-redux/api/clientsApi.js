var $ = require('jquery');
var { getClients, blockClient, getClientHistory } = require('../actions/clientsActions');
var store = require('../store');

module.exports = {
    getClients: function () {
        var url = '/clients/';
        $.ajax({
            url: url,
            type: "GET",
            success: function (data) {
                store.dispatch(getClients(data));
            }
        });
    },
    blockClient: function (userId) {
        var url = '/clients/' + userId + '0345';
        $.ajax({
            url: url,
            type: 'PUT',
            success: function () {
                store.dispatch(blockClient(userId));
            }
        });
    },
    getClientHistory : function(userId) {
        var url = '/clients/' + userId;
        $.ajax({
            url: url,
            type: 'GET',
            success: function (data) {
                store.dispatch(getClientHistory(data));
            },
            error : function() {
                store.dispatch();
            }
        })
    },
    sendMessage : function(userId, message, subject) {
        var url = '/clients/' + userId + '/contact';
        $.ajax({
            url: url,
            type: 'GET',
            data: {message: message, subject: subject},
            success: function () {
                alert("Message was sent to client #" + userId);
            }
        })
    }
}
;