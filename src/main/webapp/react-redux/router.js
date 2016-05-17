var { Router, Route, IndexRoute } = require('react-router');
var React = require('react');
var NavBar = require('./components/container/navPanelContainer');
var Home = require('./components/home');
var Products = require('./components/container/productsContainer');
var Product = require('./components/container/productContainer');
var ProductChange = require('./components/container/productChangeContainer');
var ProductAdd = require('./components/container/productAddContainer');

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
                <Route path=":type/add" component={ ProductAdd }/>
            </Route>
        </Route>
    </Router>
);