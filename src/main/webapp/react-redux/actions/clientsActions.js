var types = require('./actionTypes');

module.exports = {
    getClients: function (clients) {
        return {
            type: types.GET_CLIENTS,
            clients
        }
    },
    blockClient: function (clientId) {
        return {
            type: types.BLOCK_CLIENT,
            clientId
        }
    },
    getClientHistory: function (orders) {
        return {
            type: types.GET_CLIENT_HISTORY,
            orders
        }
    },
    cleanHistory: function () {
        return {
            type: types.CLEAN_HISTORY
        }
    },
    showClientModal: function (clientId) {
        return {
            type: types.SHOW_CLIENT_MODAL,
            clientId
        }
    },
    hideClientModal: function () {
        return {
            type: types.HIDE_CLIENT_MODAL
        }
    }
};