var React = require('react');
var { Link } = require('react-router');
var { hashHistory } = require('react-router');

const Product = React.createClass({
    render: function () {
        var value = this.props.value;
        var product = this.props.product;
        var url = this.props.url;
        return (
            <tr>
                <td className="tdImg" width="200">
                    <img src={"../resources/images/" + product.photo} height="100"/>
                </td>
                <td>
                    {value} x <Link to={url} className="btn-link">{product.name}</Link>
                </td>
            </tr>
        )
    }
});
const Order = React.createClass({
    render: function () {
        var { order } = this.props;
        var products = [];
        order.products.forEach((value, product) => {
            product = JSON.parse(product);
            var url = "/products/"+ product.type + "/" + product.id;
            products.push(
                <Product product={product} value={value} key={product.id} url={url}/>
            )
        });
        return (
            <tr>
                <td>{order.id}</td>
                <td>
                    <table className="table table-responsive">
                        <tbody>
                        {products}
                        </tbody>
                    </table>
                </td>
                <td>{order.price}</td>
                <td>{order.date}</td>
                <td>{order.orderState}</td>
            </tr>
        )
    }
});
const Orders = React.createClass({
    render: function () {
        var login = this.props.orders[0].username;
        return (
            <div className="container">
                <h1>Orders &nbsp;
                    <small>{login}</small>
                </h1>
                <button className="btn btn-primary"
                        onClick={(e) => { e.preventDefault(); hashHistory.replace('/clients');}}>
                    Back
                </button>
                <table className="table">
                    <thead>
                    <tr>
                        <th>Order #</th>
                        <th>Products</th>
                        <th>Price</th>
                        <th>Date</th>
                        <th>Status</th>
                    </tr>
                    </thead>
                    <tbody>
                    {this.props.orders.map((order) => {
                        return (
                            <Order order={order} key={order.id}/>
                        )
                    })}
                    </tbody>
                </table>

            </div>
        )
    }
});
module.exports = function (props) {
    return (
        <Orders orders={props.clientHistory}/>
    )
};