var React = require('react');
var Redux = require('redux');
var ReactRedux = require("react-redux");
var { showCart, addInCart, subtractInCart, fromCart } = require('../../actions/cartActions');
var { showLogin } = require('../../actions/userActions');
var userApi = require('../../api/userApi');
var orderApi = require('../../api/orderApi');
var NavPanel = require('../view/navPanel');

var NavigationPanel = React.createClass({
    render : function() {
        return(
            <div>
                <NavPanel cartState={this.props.cartState}
                          userState={this.props.userState}
                          showCart={this.props.showCart}
                          addInCart={this.props.addInCart}
                          subtractInCart={this.props.subtractInCart}
                          fromCart={this.props.fromCart}
                          showLoginModal={this.props.showLogin}
                          login={userApi.login}
                          logout={userApi.logout}
                          confirmOrder={orderApi.confirmOrder} />

                {this.props.children}

            </div>

        )
    }
});

const mapStateToProps = function(store) {
    return {
        cartState : store.cartState,
        userState : store.userState
    }
};
const mapDispatchToProps = (dispatch) => Redux.bindActionCreators({
    showCart, addInCart, subtractInCart, fromCart, showLogin
}, dispatch);

module.exports = ReactRedux.connect(mapStateToProps, mapDispatchToProps)(NavigationPanel);