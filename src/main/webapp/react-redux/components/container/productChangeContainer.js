var React = require('react');
var ReactRedux = require("react-redux");
var productApi = require('../../api/productApi');
var PhoneChange =  require('../view/phoneChange');
var LaptopChange = require('../view/laptopChange');
var ComputerChange = require('../view/computerChange');

var ProductChangeContainer = React.createClass({
    componentDidMount : function() {
        var productType = this.props.params.type;
        var productId = this.props.params.id;
        productApi.getProduct(productType, productId);
    },
    render : function() {
        var ChangeComponent = PhoneChange;
        var urlProduct = "/products/" + this.props.params.type + "/" + this.props.params.id;
        switch(this.props.product.type) {
            case 'LAPTOPS':
                ChangeComponent = LaptopChange;
                break;
            case 'COMPUTERS':
                ChangeComponent = ComputerChange;
                break;
            default :
                break;
        }
        return(
            <ChangeComponent urlProduct={urlProduct} product={this.props.product} changeProduct={productApi.changeProduct} />
        )
    }
});

const mapStateToProps = function(store) {
    return {
        product : store.productState.product
    }
};

module.exports = ReactRedux.connect(mapStateToProps)(ProductChangeContainer);
