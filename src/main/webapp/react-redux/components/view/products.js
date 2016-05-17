var React = require('react');
var {Link} = require('react-router');
var {Button, Modal, Image} = require('react-bootstrap');

const ProductPanel = React.createClass({
    getInitialState: function () {
        return {
            modal: false
        }
    },
    close() {
        this.setState({modal: false});
    },
    open() {
        this.setState({modal: true});
    },
    render: function () {
        var product = this.props.product;
        var photo = "../resources/images/" + product.photo;
        var url = "/products/" + this.props.type + "/" + product.id;
        return (
            <div>
                <div className="col-sm-4">
                    <div className="thumbnail">
                        <div className="caption">
                            <Image src={photo} onClick={(e) => { e.preventDefault(); this.open();}} responsive/>
                            <h3>
                                <Link to={url}>{product.name}</Link>
                            </h3>
                            <p>
                                <Button bsStyle="primary"
                                        onClick={(e) => { e.preventDefault(); this.props.toCart(product);}}>Buy</Button> &nbsp;
                                <Button bsStyle="default">Change</Button> &nbsp;
                                {product.price} UAH
                            </p>
                        </div>
                    </div>
                </div>

                <Modal show={this.state.modal} onHide={this.close}>
                    <Modal.Header closeButton>
                        <Modal.Title> {product.name} </Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                        <h4> Model : {product.model} </h4>
                        <hr />
                        <h4>Description</h4>
                        <p> {product.description} </p>
                    </Modal.Body>
                    <Modal.Footer>
                        <Link className="btn btn-primary" to={url}>Full page</Link>
                        <Button onClick={this.close}>Close</Button>
                    </Modal.Footer>
                </Modal>
            </div>
        );
    }
});

module.exports = function (props) {
    var header = '';
    switch (props.type) {
        case 'phones' :
            header = 'Phones';
            break;
        case 'laptops' :
            header = 'Laptops';
            break;
        case 'computers' :
            header = 'Computers';
            break;
    }
    return (
        <div className="container">
            <div className="page-header">
                <h2> {header} </h2>
                <button className="btn btn-primary" onClick={() => {alert(1);}}>
                    Add
                </button>
            </div>
            <div className="row">
                { props.products.map(function (product) {
                    return (
                        <ProductPanel product={product} type={props.type} toCart={props.toCart} key={product.id}/>
                    );
                })}
            </div>
        </div>
    )
};