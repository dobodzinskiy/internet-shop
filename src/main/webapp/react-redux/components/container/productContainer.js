var React = require('react');
var Redux = require('redux');
var ReactRedux = require("react-redux");
var productApi = require('../../api/productApi');
var Product = require('../view/product');
var { toCart } = require('../../actions/cartActions');

var ProductContainer = React.createClass({
    componentDidMount: function () {
        var productType = this.props.params.type;
        var productId = this.props.params.id;
        productApi.getProduct(productType, productId);
        productApi.getComments(productId);
    },

    render: function () {
        var urlChange = '/products/' + this.props.params.type + '/' + this.props.params.id + '/change';
        return <Product product={this.props.product}
                        comments={this.props.comments}
                        onSubmit={productApi.postComment}
                        onDelete={productApi.deleteComment}
                        toCart={this.props.toCart}
                        urlChange={urlChange}
                        currentUser={this.props.currentUser}/>
    }
});

const mapStateToProps = function (store) {
    return {
        product: store.productState.product,
        comments: store.productState.comments,

        currentUser: store.userState.currentUser
    }
};

const mapDispatchToProps = (dispatch) => Redux.bindActionCreators({
    toCart
}, dispatch);

module.exports = ReactRedux.connect(mapStateToProps, mapDispatchToProps)(ProductContainer);
