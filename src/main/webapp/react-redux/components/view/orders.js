var React = require('react');
var { Link } = require('react-router');

const Product = React.createClass({
    render: function () {
        var value = this.props.value;
        var product = this.props.product;
        var url = this.props.url;
        return (
            <tr>
                <td className="tdImg" width="200">
                    <img src={"../resources/images/" + product.photo} height="100" />
                </td>
                <td>
                    {value} x <Link to={url} className="btn-link">{product.name}</Link>
                </td>
            </tr>
        )
    }
});
var Order = React.createClass({
    render: function () {
        var {order} = this.props;
        var products = [];
        order.products.forEach((value, product) => {
            product = JSON.parse(product);
                var url = '/products/' + product.type + '/' + product.id;
                //switch (product.type) {
                //    case 'phones' :
                //        url = "/products/phones/" + product.id;
                //        break;
                //    case 'laptops' :
                //        url = "/products/laptops/" + product.id;
                //        break;
                //    case 'COMPUTERS' :
                //        url = "/products/computers/" + product.id;
                //        break;
                //}
            products.push(
                <Product product={product} value={value} key={product.id} url={url}/>
            )
        });
        return (
            <tr>
                <td>{order.id}</td>
                <td>{order.username}</td>
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
                <td>
                    <button className="btn btn-primary"
                            onClick={(e) => {e.preventDefault(); this.props.changeOrderState(order.id);}}>
                        Change state
                    </button>
                </td>
            </tr>
        )
    }
});

module.exports = function (props) {
    return (
        <div className="container">
            <h1>Orders</h1>
            <table className="table">
                <thead>
                <tr>
                    <th>Order #</th>
                    <th>Login</th>
                    <th>Products</th>
                    <th>Price</th>
                    <th>Date</th>
                    <th>Status</th>
                    <th>Options</th>
                </tr>
                </thead>
                <tbody>
                {props.orders.map((order) => {
                    return (
                        <Order key={order.id} order={order} changeOrderState={props.changeOrderState}/>
                    )
                })}
                </tbody>
            </table>
        </div>
    )
};
