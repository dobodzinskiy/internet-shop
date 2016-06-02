var React = require('react');
var Redux = require('redux');
var ReactRedux = require("react-redux");
var productApi = require('../../api/productApi');
var profileApi = require('../../api/profileApi');
var Product = require('../view/product');
var { toCart } = require('../../actions/cartActions');
var { cleanProduct } = require('../../actions/productActions');
var Spinner = require('../view/spinner');

var ProductContainer = React.createClass({
    componentDidMount: function () {
        var productType = this.props.params.type;
        var productId = this.props.params.id;
        productApi.getProduct(productType, productId);
        productApi.getComments(productId);
    },
    componentWillUnmount: function () {
        this.props.cleanProduct();
    },
    render: function () {
        var urlChange = '/products/' + this.props.params.type + '/' + this.props.params.id + '/change';
        if (this.props.product) {
            return (
                <Product product={this.props.product}
                         comments={this.props.comments}
                         onSubmit={productApi.postComment}
                         onDelete={productApi.deleteComment}
                         toCart={this.props.toCart}
                         toFavorites={profileApi.toFavorites}
                         fromFavorites={profileApi.fromFavorites}
                         urlChange={urlChange}
                         userState={this.props.userState}/>
            )
        }
        return <Spinner />
    }
});

const mapStateToProps = function (store) {
    return {
        product: store.productState.product,
        comments: store.productState.comments,

        userState: store.userState
    }
};

const mapDispatchToProps = (dispatch) => Redux.bindActionCreators({
    toCart, cleanProduct
}, dispatch);

module.exports = ReactRedux.connect(mapStateToProps, mapDispatchToProps)(ProductContainer);
