var React = require('react');
var ReactRedux = require('react-redux');
var orderApi = require('../../api/orderApi');
var Orders = require('../view/orders');
var Spinner = require('../view/spinner');

var OrdersContainer = React.createClass({
    componentDidMount: function () {
        orderApi.getOrdersList();
    },
    render: function () {
        if(this.props.userState.currentUserRole != "ROLE_ADMIN") {
            return(
                <div className="container text-center">
                    <img src="../resources/images/404.jpg"/>
                </div>
            )
        }
        if (this.props.orders) {
            return (
                <Orders orders={this.props.orders} changeOrderState={orderApi.changeOrderState}/>
            )
        }
        return (
            <Spinner />
        )
    }
});
const MapStateToProps = function (store) {
    return {
        orders: store.ordersState.orders,
        userState: store.userState
    }
};

module.exports = ReactRedux.connect(MapStateToProps)(OrdersContainer);