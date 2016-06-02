var React = require('react');
var {Link} = require('react-router');
var {Button, Modal, Pagination} = require('react-bootstrap');
var $ = require('jquery');

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
        var url = "/products/" + this.props.type + "/" + product.id;

        var photo = "../resources/images/" + product.photo;
        var Photo = <img src={photo} onClick={(e) => { e.preventDefault(); this.open();}} height="250"/>;
        var Buy = <Button bsStyle="primary"
                          onClick={(e) => { e.preventDefault(); this.props.toCart(product);}}>To cart</Button>;
        if (!product.available) {
            Photo = <img className="non-available" src={photo} onClick={(e) => { e.preventDefault(); this.open();}}
                         height="250"/>;
            Buy = <Button bsStyle="primary" disabled> To cart </Button>;
        }

        return (
            <div>
                <div className="col-sm-4">
                    <div className="thumbnail">
                        <div className="caption">
                            <div className="tdImg">
                                {Photo}
                            </div>

                            <h3>
                                <Link to={url}>{product.name}</Link>
                            </h3>
                            <p>
                                {Buy}
                                &nbsp;
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
                <h2>{header}</h2>
                <h4>
                    <form className="form-horizontal">
                        <div className="form-group">
                            <label className="control-label col-sm-2" for="email">Sort:</label>
                            <div className="col-sm-4">
                                <select className="form-control" id="sortType"
                                        onChange={()=> {props.changeSort($("#sortType").val());}}>
                                    <option value="name">Name</option>
                                    <option value="priceDesc">Price desc</option>
                                    <option value="priceAsc">Price</option>
                                    <option value="company">Company</option>
                                </select>
                            </div>
                        </div>
                    </form>
                </h4>
            </div>
            <div className="row">
                { props.products.map(function (product) {
                    return (
                        <ProductPanel product={product}
                                      type={props.type}
                                      toCart={props.toCart}
                                      key={product.id}/>
                    );
                })}
            </div>
            <div className="text-center">
                <Pagination
                    bsSize="medium"
                    items={props.pages}
                    activePage={props.page}
                    onSelect={(e) => {props.changePage(e);}}/>
            </div>
        </div>
    )
};