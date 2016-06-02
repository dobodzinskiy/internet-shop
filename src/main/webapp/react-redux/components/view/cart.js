var React = require('react');
var $ = require('jquery');
var { Link } = require('react-router');

const ProductRow = React.createClass({
    render: function () {
        var {product} = this.props;
        var {value} = this.props;
        var photoUrl = "/resources/images/" + product.photo;
        var url = '/products/' + product.type + '/' + product.id;
        return (
            <tr>
                <td>
                    <img src={photoUrl} height="100"/>
                </td>
                <td>
                    <Link to={url}> {product.name} </Link>
                </td>
                <td>
                    <p>
                           <span className="glyphicon glyphicon-minus"
                                 onClick={(e) => { e.preventDefault(); this.props.subtract(product)}}></span>
                        &nbsp;{value}&nbsp;
                           <span className="glyphicon glyphicon-plus"
                                 onClick={(e) => { e.preventDefault(); this.props.add(product)}}></span>
                        &nbsp;&nbsp;
                        x {product.price} UAH
                    </p>
                </td>
                <td>
                       <span className="glyphicon glyphicon-remove"
                             onClick={(e) => { e.preventDefault(); this.props.fromCart(product);}}></span>
                </td>
            </tr>
        )
    }
});

module.exports = function (props) {
    var rows = [];
    props.productsMap.forEach((value, product) => {
        product = JSON.parse(product);
        rows.push(
            <ProductRow value={value}
                        product={product}
                        key={product.id}
                        add={props.add}
                        subtract={props.subtract}
                        fromCart={props.fromCart}/>
        )
    });
    return (
        <div className="cart">
            <table className="table table-hover cart">
                <tbody>
                {rows}
                </tbody>
            </table>
        </div>
    )
};