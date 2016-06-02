var React = require('react');
var Redux = require('redux');
var ReactRedux = require("react-redux");
var productApi = require('../../api/productApi');
var Products = require('../view/products');
var { toCart } = require('../../actions/cartActions');
var { changePage, changeSort, cleanProducts } = require('../../actions/productActions');

var ProductsContainer = React.createClass({
    componentDidMount: function () {
        var { type, page, sort } = this.props;
        productApi.getProducts(type, page, sort);
        productApi.getPages(type);
    },
    componentWillUnmount: function() {
        this.props.cleanProducts();
    },
    handleChangePage: function(activePage) {
        var { type, sort } = this.props;
        productApi.getProducts(type, activePage, sort);
        this.props.changePage(activePage);
    },
    handleChangeSort: function(activeSort) {
        var { type, page } = this.props;
        productApi.getProducts(type, page, activeSort);
        this.props.changeSort(activeSort);
    },
    render: function () {
        if (this.props.products) {
            return (
                <Products products={this.props.products}
                          page={this.props.page}
                          sort={this.props.sort}
                          pages={this.props.pages}
                          type={this.props.type}
                          toCart={this.props.toCart}
                          changePage={this.handleChangePage}
                          changeSort={this.handleChangeSort}
                          isOpenAddProductModal={this.props.isOpenAddProductModal}/>
            )
        }
        return(<p></p>)
    }
});

const mapStateToProps = function (store) {
    return {
        products: store.productState.products,
        page: store.productState.page,
        pages: store.productState.pages,
        sort: store.productState.sort,
        isOpenAddProductModal: store.productState.isOpenAddProductModal
    };
};

const mapDispatchToProps = (dispatch) => Redux.bindActionCreators({
    toCart,
    cleanProducts, changePage, changeSort
}, dispatch);

module.exports = ReactRedux.connect(mapStateToProps, mapDispatchToProps)(ProductsContainer);