var React = require('react');
var Redux = require('redux');
var ReactRedux = require("react-redux");
var ProfileChange = require('../view/profileChange');
var profileApi = require('../../api/profileApi');
var { showChangePassword } = require('../../actions/profileActions');

var ProfileChangeContainer = React.createClass({
    render: function () {
        return (
            <ProfileChange currentUser={this.props.currentUser}
                           handleChange={profileApi.changeProfile}
                           isChangePasswordOpen={this.props.isChangePasswordOpen}
                           showChangePassword={this.props.showChangePassword}/>
        )
    }
});
const mapStateToProps = function (store) {
    return {
        currentUser: store.userState.currentUser,
        isChangePasswordOpen : store.userState.isChangePasswordOpen
    }
};
const mapDispatchToProps = (dispatch) => Redux.bindActionCreators({
    showChangePassword
}, dispatch);

module.exports = ReactRedux.connect(mapStateToProps, mapDispatchToProps)(ProfileChangeContainer);