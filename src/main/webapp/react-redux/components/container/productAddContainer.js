var React = require('react');
var ReactRedux = require("react-redux");
var productApi = require('../../api/productApi');
var ProductAdd = require('../view/productAdd');

var ProductAddContainer = React.createClass({
   render : function() {
       <ProductAdd add={productApi.addProduct} type={this.props.params.type} />
   }
});
module.exports = ReactRedux.connect(ProductAddContainer);