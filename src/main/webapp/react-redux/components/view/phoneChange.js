var React = require('react');
var $ = require('jquery');
var { Image, Button } = require('react-bootstrap');
var { hashHistory } = require('react-router');

const ProductChangePanel = React.createClass({
    handleChangeProduct: function (e) {
        e.preventDefault();
        if (confirm("Change this product?")) {
            var product = this.props.product;
            var newDualSim;
            switch ($("#dualSim").val()) {
                case '1' :
                    newDualSim = true;
                    break;
                case '0' :
                    newDualSim = false;
                    break;
            }
            this.props.changeProduct({
                id: product.id,
                name: $("#name").val(),
                photo: product.photo,
                price: $("#price").val(),
                model: $("#model").val(),
                type: product.type,
                available: product.available,
                size: $("#size").val(),
                weight: $("#weight").val(),
                storage: $("#storage").val(),
                ram: $("#ram").val(),
                screen: $("#screen").val(),
                os: $("#os").val(),
                color: $("#color").val(),
                company: $("#company").val(),
                processor: $("#processor").val(),
                description: $("#description").val(),
                dualSim: newDualSim,
                simType: $("#simType").val(),
                messageType: $("#messageType").val()
            });

            var url = this.props.urlProduct;
            hashHistory.replace(url);
        }
    },
    render: function () {
        var product = this.props.product;
        var photoUrl = "/resources/images/" + product.photo;
        var available = 'Available';
        if (product.available) {
            available = 'Unavailable';
        }
        return (
            <div className="row">
                <h2>
                    <input className="form-control" type="text" id="name" defaultValue={product.name}
                           placeholder="Product name"/>
                </h2>
                <div className="col-sm-8">
                    <div className="panel panel-default">
                        <div className="panel-heading">
                            <input className="form-control" type="text" id="model" defaultValue={product.model}
                                   placeholder="Product model"/>
                        </div>
                        <div className="panel-body">
                            <Image src={photoUrl} responsive/>
                            <br/>
                            <Button bsStyle="primary"
                                    onClick={(e) => { e.preventDefault(); this.props.toCart(product);}}>
                                New photo
                            </Button> &nbsp;
                            <Button bsStyle="default" onClick={this.handleChangeProduct}>Save</Button> &nbsp;
                            <Button bsStyle="default"
                                    onClick={(e) => { e.preventDefault(); this.props.changeAvailable(product.id);}}>
                                {available}
                            </Button> &nbsp;
                            <div className="col-sm-4">
                                <input className="form-control" type="text" id="price" defaultValue={product.price}
                                       placeholder="Product price"/>
                            </div>
                            <br/>
                            <br/>
                            <h3>Description</h3>
                            <h5><textarea className="form-control" id="description" rows="5"
                                          defaultValue={product.description}/></h5>
                        </div>
                    </div>
                </div>
                <div className="col-sm-4" height="500px;">
                    <div className="panel panel-default">
                        <div className="panel-heading">Details</div>
                        <table className="table table-hover">
                            <tbody>
                            <tr>
                                <td><b>Company</b></td>
                                <td><input className="form-control" id="company" defaultValue={product.company}/></td>
                            </tr>
                            <tr>
                                <td><b>Weight</b></td>
                                <td><input className="form-control" id="weight" defaultValue={product.weight}/></td>
                            </tr>
                            <tr>
                                <td><b>Size</b></td>
                                <td><input className="form-control" id="size" defaultValue={product.size}/></td>
                            </tr>
                            <tr>
                                <td><b>Storage</b></td>
                                <td><input className="form-control" id="storage" defaultValue={product.storage}/></td>
                            </tr>
                            <tr>
                                <td><b>RAM</b></td>
                                <td><input className="form-control" id="ram" defaultValue={product.ram}/></td>
                            </tr>
                            <tr>
                                <td><b>Screen</b></td>
                                <td><input className="form-control" id="screen" defaultValue={product.screen}/></td>
                            </tr>
                            <tr>
                                <td><b>OS</b></td>
                                <td><input className="form-control" id="os" defaultValue={product.os}/></td>
                            </tr>
                            <tr>
                                <td><b>Color</b></td>
                                <td><input className="form-control" id="color" defaultValue={product.color}/></td>
                            </tr>
                            <tr>
                                <td><b>Processor</b></td>
                                <td><input className="form-control" id="processor" defaultValue={product.processor}/>
                                </td>
                            </tr>
                            <tr>
                                <td><b>DualSim</b></td>
                                <td>
                                    <select className="form-control" id="dualSim">
                                        <option value="1">+</option>
                                        <option value="0">-</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td><b>Sim types</b></td>
                                <td><input className="form-control" id="simType" defaultValue={product.simType}/></td>
                            </tr>
                            <tr>
                                <td><b>Message types</b></td>
                                <td><input className="form-control" id="messageType"
                                           defaultValue={product.messageType}/></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        )
    }
});

module.exports = function (props) {
    return (
        <div className="container">
            <ProductChangePanel urlProduct={props.urlProduct}
                                product={props.product}
                                changeAvailable={props.changeAvailable}
                                changeProduct={props.changeProduct}/>
        </div>
    )
};