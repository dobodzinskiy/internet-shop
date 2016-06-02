var React = require('react');

var Product = React.createClass({
    render: function () {
        var { product } = this.props;
        var url = '#/products/' + product.type + '/' + product.id;
        return (
            <div className="col-sm-4 text-center">
                <h3>{product.name}&nbsp; <span className="glyphicon glyphicon glyphicon-remove"
                                               onClick={(e) => {e.preventDefault(); this.props.fromFavorites(product.id);}}></span>
                </h3>
                <div className="tdImg">
                    <a href={url}>
                        <img src={"../resources/images/" + product.photo} height="250"/>
                    </a>
                </div>
            </div>
        )
    }
});
var Favorites = React.createClass({
    render: function () {
        var { user } = this.props;
        return (
            <div className="container">
                <h1>Favorites &nbsp;
                    <small>login : {user.login}</small>
                </h1>
                <div className="row">
                    {user.products.map((product) => {
                        return (
                            <Product key={product.id} product={product} fromFavorites={this.props.fromFavorites}/>
                        )
                    })}
                </div>
            </div>
        )
    }
});
module.exports = function (props) {
    return (
        <Favorites user={props.currentUser} fromFavorites={props.fromFavorites}/>
    )
};