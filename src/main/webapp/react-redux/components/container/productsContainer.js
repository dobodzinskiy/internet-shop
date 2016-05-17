var React = require('react');
var Redux = require('redux');
var ReactRedux = require("react-redux");
var productApi = require('../../api/productApi');
var Products =  require('../view/products');
var { toCart } = require('../../actions/cartActions');
var { showAddProductModal} = require('../../actions/productActions');

var ProductsContainer = React.createClass({
    componentDidMount : function() {
        var type = this.props.type;
        productApi.getProducts(type);
    },

    render : function () {
        return(
            <Products products={this.props.products} 
                      type={this.props.type} 
                      toCart={this.props.toCart} 
                      showAddProductModal={this.props.showAddProductModal} 
                      isOpenAddProductModal={this.props.isOpenAddProductModal}/>
        )
    }
});

const mapStateToProps = function(store) {
    return {
        products: store.productState.products,
        isOpenAddProductModal : store.productState.isOpenAddProductModal
    };
};
    
const mapDispatchToProps = (dispatch) => Redux.bindActionCreators({
        toCart, showAddProductModal
}, dispatch);

module.exports = ReactRedux.connect(mapStateToProps, mapDispatchToProps)(ProductsContainer);