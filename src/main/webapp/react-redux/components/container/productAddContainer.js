var React = require('react');
var ReactRedux = require("react-redux");
var productApi = require('../../api/productApi');
var ProductAdd = require('../view/productAdd');

var ProductAddContainer = React.createClass({
    render: function () {
        if(this.props.userState.currentUserRole != "ROLE_ADMIN") {
            return(
                <div className="container text-center">
                    <img src="../resources/images/404.jpg"/>
                </div>
            )
        }
        return (
            <ProductAdd add={productApi.addProduct} type={this.props.type}/>
        )
    }
});
const MapStateToProps = function (store) {
    return {
        userState: store.userState
    }
};

module.exports = ReactRedux.connect(MapStateToProps)(ProductAddContainer);