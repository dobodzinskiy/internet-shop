var types = require('../actions/actionTypes');

const initialClientsState = {
    clients: [],
    clientHistory: null,
    client: [],
    isClientModalOpen: false
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
var findClient = function(clientId, clients) {
    var newClient = {};
    clients.forEach((client) => {
        if(client.id == clientId) {
            newClient = client
        }
    });
    return newClient;
};
var filterBlock = function(userId, clients) {
    var newClients = [];
    clients.forEach((client) => {
        if(client.id == userId) {
            client.enabled = !client.enabled;
        }
        newClients.push(client);
    });
    return newClients;
};
module.exports = function (state = initialClientsState, action) {
    switch (action.type) {
        case types.GET_CLIENTS:
            return Object.assign({}, state, {
                clients: action.clients
            });
        case types.BLOCK_CLIENT:
            return Object.assign({}, state, {
                clients : filterBlock(action.clientId, state.clients)
            });
        case types.GET_CLIENT_HISTORY:
            return Object.assign({}, state, {
                clientHistory: toMap(action.orders)
            });
        case types.CLEAN_HISTORY:
            return Object.assign({}, state, {
                clientHistory : null
            });
        case types.SHOW_CLIENT_MODAL:
            return Object.assign({}, state, {
                client: findClient(action.clientId, state.clients),
                isClientModalOpen: true
            });
        case types.HIDE_CLIENT_MODAL:
            return Object.assign({}, state, {
                isClientModalOpen: false,
                client: null
            });
        default :
            return state;
    }
};
