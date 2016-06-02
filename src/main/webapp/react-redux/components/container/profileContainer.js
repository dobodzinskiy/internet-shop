var React = require('react');
var ReactRedux = require("react-redux");
var Profile = require('../view/profile');

var ProfileContainer = React.createClass({
    render: function () {
        return (
            <Profile currentUser={this.props.currentUser}/>
        )
    }
});

const mapStateToProps = function (store) {
    return {
        currentUser: store.userState.currentUser
    }
};

module.exports = ReactRedux.connect(mapStateToProps)(ProfileContainer);