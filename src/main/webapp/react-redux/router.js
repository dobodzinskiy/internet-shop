var { Router, Route, IndexRoute } = require('react-router');
var React = require('react');
var NavBar = require('./components/container/navPanelContainer');
var Home = require('./components/view/home');
var Products = require('./components/container/productsContainer');
var Product = require('./components/container/productContainer');
var ProductChange = require('./components/container/productChangeContainer');
var ProductAdd = require('./components/container/productAddContainer');
var Profile = require('./components/container/profileContainer');
var ProfileChange = require('./components/container/profileChangeContainer');
var ProfileOrders = require('./components/container/profileOrdersContainer');
var Clients = require('./components/container/clientsContainer');
var ClientsHistory = require('./components/container/clientsHistoryContainer');
var Orders = require('./components/container/ordersContainer');
var Favorites = require('./components/container/profileFavoritesContainer');
var Spinner = require('./components/view/spinner');
var NotFound = require('./components/view/notFound');

module.exports = (
    <Router>
        <Route path="/" component={NavBar}>
            <IndexRoute component={Home}/>
            <Route path="products">
                <Route path="laptops" component={ (props, state) => <Products type="laptops" /> }/>
                <Route path="computers" component={ (props, state) => <Products type="computers" /> }/>
                <Route path="phones" component={ (props, state) => <Products type="phones" /> }/>
                <Route path=":type/:id" component={ Product }/>
                <Route path=":type/:id/change" component={ ProductChange }/>
            </Route>
            <Route path="add">
                <Route path="laptop" component={ (props, state) => <ProductAdd type="laptop" />}/>
                <Route path="phone" component={ (props, state) => <ProductAdd type="phone" /> }/>
                <Route path="computer" component={ (props, state) => <ProductAdd type="computer" /> }/>
            </Route>
            <Route path="profile">
                <IndexRoute component={Profile}/>
                <Route path="change" component={ProfileChange}/>
                <Route path="orders" component={ProfileOrders}/>
                <Route path="favorites" component={Favorites}/>
            </Route>
            <Route path="clients" component={Clients}>
                <Route path="history/:id" component={ClientsHistory}/>
            </Route>
            <Route path="orders" component={Orders}/>
            <Route path="*" component={Spinner}/>
        </Route>
    </Router>
);