var React = require('react');
var ReactRedux = require("react-redux");
var Favorites = require('../view/favorites');
var profileApi = require('../../api/profileApi');

var ProfileFavoritesContainer = React.createClass({
    render: function () {
        return (
            <Favorites currentUser={this.props.currentUser} fromFavorites={profileApi.fromFavorites}/>
        )
    }
});

const mapStateToProps = function (store) {
    return {
        currentUser: store.userState.currentUser
    }
};

module.exports = ReactRedux.connect(mapStateToProps)(ProfileFavoritesContainer);