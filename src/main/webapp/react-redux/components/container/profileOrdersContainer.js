var React = require('react');
var ReactRedux = require("react-redux");
var ProfileOrders = require('../view/profileOrders');
var profileApi = require('../../api/profileApi');
var Spinner = require('../view/spinner');

var ProfileChangeContainer = React.createClass({
    componentDidMount: function () {
        profileApi.getProfileOrders();
    },
    render: function () {
        if (this.props.currentUserOrders) {
            return (
                <ProfileOrders currentUserOrders={this.props.currentUserOrders}/>
            )
        }
        return (
            <Spinner />
        )
    }
});
const mapStateToProps = function (store) {
    return {
        currentUserOrders: store.userState.currentUserOrders
    }
};

module.exports = ReactRedux.connect(mapStateToProps)(ProfileChangeContainer);