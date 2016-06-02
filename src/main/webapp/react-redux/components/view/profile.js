var React = require('react');

const Profile = React.createClass({
    render: function () {
        var user = this.props.user;
        return(
            <div className="container">
                <h2 className="page-header">
                    Your login: {user.login}
                </h2>
                <table className="table">
                    <tbody>
                    <tr>
                        <td>Name:</td>
                        <td>{user.firstName}</td>
                    </tr>
                    <tr>
                        <td>Last name:</td>
                        <td>{user.lastName}</td>
                    </tr>
                    <tr>
                        <td>Gender:</td>
                        <td>{user.gender}</td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td>{user.email}</td>
                    </tr>
                    <tr>
                        <td>Phone:</td>
                        <td>{user.phone}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        )
    }
});
module.exports = function (props) {
    return (
        <Profile user={props.currentUser}/>
    )
};