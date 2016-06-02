var React = require('react');
var $ = require('jquery');

const addPhone = React.createClass({
    handleAdd: function (e) {
        e.preventDefault();
        var newDualSim;
        if (confirm('Add product?')) {
            switch ($("#dualSim").val()) {
                case '1' :
                    newDualSim = true;
                    break;
                case '0' :
                    newDualSim = false;
                    break;
            }
            this.props.add({
                name: $("#name").val(),
                photo: $("#photo").val().replace(/C:\\fakepath\\/i, ''),
                price: $("#price").val(),
                model: $("#model").val(),
                type: 'phones',
                available: true,
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
                messageType: $("#messageType").val(),
                DualSim: newDualSim
            })
        }
    },
    render: function () {
        return (
            <div className="container">
                <h2>Type : <b>Phone</b></h2>
                <form role="form" onSubmit={this.handleAdd}>
                    <div className="form-group">
                        <label for="name">Name:</label>
                        <input type="text" className="form-control" id="name"/>
                    </div>
                    <div className="form-group">
                        <label for="model">Model:</label>
                        <input type="text" className="form-control" id="model"/>
                    </div>
                    <div className="form-group">
                        <label for="company">Company:</label>
                        <input type="text" className="form-control" id="company"/>
                    </div>
                    <div className="form-group">
                        <label for="photo">Photo:</label>
                        <input type="file" className="form-control" id="photo"/>
                    </div>
                    <div className="form-group">
                        <label for="price">Price:</label>
                        <input type="text" className="form-control" id="price"/>
                    </div>
                    <div className="form-group">
                        <label for="size">Size:</label>
                        <input type="text" className="form-control" id="size"/>
                    </div>
                    <div className="form-group">
                        <label for="weight">Weight:</label>
                        <input type="text" className="form-control" id="weight"/>
                    </div>
                    <div className="form-group">
                        <label for="ram">Ram:</label>
                        <input type="text" className="form-control" id="ram"/>
                    </div>
                    <div className="form-group">
                        <label for="storage">Storage:</label>
                        <input type="text" className="form-control" id="storage"/>
                    </div>
                    <div className="form-group">
                        <label for="screen">Screen:</label>
                        <input type="text" className="form-control" id="screen"/>
                    </div>
                    <div className="form-group">
                        <label for="os">OS:</label>
                        <input type="text" className="form-control" id="os"/>
                    </div>
                    <div className="form-group">
                        <label for="color">Color:</label>
                        <input type="text" className="form-control" id="color"/>
                    </div>
                    <div className="form-group">
                        <label for="processor">Processor:</label>
                        <input type="text" className="form-control" id="processor"/>
                    </div>
                    <div className="form-group">
                        <label for="dualSim">Dual Sim :</label>
                        <select className="form-control" id="dualSim" placeholder="Select dualSim">
                            <option value="1">+</option>
                            <option value="0">-</option>
                        </select>
                    </div>
                    <div className="form-group">
                        <label for="simType">Sim type:</label>
                        <input type="text" className="form-control" id="simType"/>
                    </div>
                    <div className="form-group">
                        <label for="messageType">Message type:</label>
                        <input type="text" className="form-control" id="messageType"/>
                    </div>
                    <div className="form-group">
                        <label for="description">Description:</label>
                        <textarea className="form-control" id="description" rows="5"/>
                    </div>
                    <button type="submit" className="btn btn-default">Submit</button>
                </form>
            </div>
        )
    }
});
const AddLaptop = React.createClass({
    handleAdd: function (e) {
        e.preventDefault();
        if (confirm('Add product?')) {
            var newKeyboardLight;
            switch ($("#keyboardLight").val()) {
                case '1' :
                    newKeyboardLight = true;
                    break;
                case '0' :
                    newKeyboardLight = false;
                    break;
            }
            this.props.add({
                name: $("#name").val(),
                photo: $("#photo").val().replace(/C:\\fakepath\\/i, ''),
                price: $("#price").val(),
                model: $("#model").val(),
                type: 'laptops',
                available: true,
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
                keyboardLight: newKeyboardLight
            })
        }
    },
    render: function () {
        return (
            <div className="container">
                <h2>Type : <b>Laptop</b></h2>
                <form role="form" onSubmit={this.handleAdd}>
                    <div className="form-group">
                        <label for="name">Name:</label>
                        <input type="text" className="form-control" id="name"/>
                    </div>
                    <div className="form-group">
                        <label for="model">Model:</label>
                        <input type="text" className="form-control" id="model"/>
                    </div>
                    <div className="form-group">
                        <label for="company">Company:</label>
                        <input type="text" className="form-control" id="company"/>
                    </div>
                    <div className="form-group">
                        <label for="photo">Photo:</label>
                        <input type="file" className="form-control" id="photo"/>
                    </div>
                    <div className="form-group">
                        <label for="price">Price:</label>
                        <input type="text" className="form-control" id="price"/>
                    </div>
                    <div className="form-group">
                        <label for="size">Size:</label>
                        <input type="text" className="form-control" id="size"/>
                    </div>
                    <div className="form-group">
                        <label for="weight">Weight:</label>
                        <input type="text" className="form-control" id="weight"/>
                    </div>
                    <div className="form-group">
                        <label for="ram">Ram:</label>
                        <input type="text" className="form-control" id="ram"/>
                    </div>
                    <div className="form-group">
                        <label for="storage">Storage:</label>
                        <input type="text" className="form-control" id="storage"/>
                    </div>
                    <div className="form-group">
                        <label for="screen">Screen:</label>
                        <input type="text" className="form-control" id="screen"/>
                    </div>
                    <div className="form-group">
                        <label for="os">OS:</label>
                        <input type="text" className="form-control" id="os"/>
                    </div>
                    <div className="form-group">
                        <label for="color">Color:</label>
                        <input type="text" className="form-control" id="color"/>
                    </div>
                    <div className="form-group">
                        <label for="processor">Processor:</label>
                        <input type="text" className="form-control" id="processor"/>
                    </div>
                    <div className="form-group">
                        <label for="keyboardLight">Keyboard light :</label>
                        <select className="form-control" id="keyboardLight" placeholder="Select keyboard light">
                            <option value="1">+</option>
                            <option value="0">-</option>
                        </select>
                    </div>
                    <div className="form-group">
                        <label for="description">Description:</label>
                        <textarea className="form-control" id="description" rows="5"/>
                    </div>
                    <button type="submit" className="btn btn-default">Submit</button>
                </form>
            </div>
        )
    }
});
const AddComputer = React.createClass({
    handleAdd: function (e) {
        e.preventDefault();
        if (confirm('Add product?')) {
            this.props.add({
                name: $("#name").val(),
                photo: $("#photo").val().replace(/C:\\fakepath\\/i, ''),
                price: $("#price").val(),
                model: $("#model").val(),
                type: 'computers',
                available: true,
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
                motherboard: $("#motherboard").val(),
                coolingSystem: $("#coolingSystem").val()
            });
        }
    },
    render: function () {
        return (
            <div className="container">
                <h2>Type : <b>Computer</b></h2>
                <form role="form" onSubmit={this.handleAdd}>
                    <div className="form-group">
                        <label for="name">Name:</label>
                        <input type="text" className="form-control" id="name"/>
                    </div>
                    <div className="form-group">
                        <label for="model">Model:</label>
                        <input type="text" className="form-control" id="model"/>
                    </div>
                    <div className="form-group">
                        <label for="company">Company:</label>
                        <input type="text" className="form-control" id="company"/>
                    </div>
                    <div className="form-group">
                        <label for="photo">Photo:</label>
                        <input type="file" className="form-control" id="photo"/>
                    </div>
                    <div className="form-group">
                        <label for="price">Price:</label>
                        <input type="text" className="form-control" id="price"/>
                    </div>
                    <div className="form-group">
                        <label for="size">Size:</label>
                        <input type="text" className="form-control" id="size"/>
                    </div>
                    <div className="form-group">
                        <label for="weight">Weight:</label>
                        <input type="text" className="form-control" id="weight"/>
                    </div>
                    <div className="form-group">
                        <label for="ram">Ram:</label>
                        <input type="text" className="form-control" id="ram"/>
                    </div>
                    <div className="form-group">
                        <label for="storage">Storage:</label>
                        <input type="text" className="form-control" id="storage"/>
                    </div>
                    <div className="form-group">
                        <label for="screen">Screen:</label>
                        <input type="text" className="form-control" id="screen"/>
                    </div>
                    <div className="form-group">
                        <label for="os">OS:</label>
                        <input type="text" className="form-control" id="os"/>
                    </div>
                    <div className="form-group">
                        <label for="color">Color:</label>
                        <input type="text" className="form-control" id="color"/>
                    </div>
                    <div className="form-group">
                        <label for="processor">Processor:</label>
                        <input type="text" className="form-control" id="processor"/>
                    </div>
                    <div className="form-group">
                        <label for="motherboard">Motherboard:</label>
                        <input type="text" className="form-control" id="motherboard"/>
                    </div>
                    <div className="form-group">
                        <label for="coolingSystem">Cooling system:</label>
                        <input type="text" className="form-control" id="coolingSystem"/>
                    </div>
                    <div className="form-group">
                        <label for="description">Description:</label>
                        <textarea className="form-control" id="description" rows="5"/>
                    </div>
                    <button type="submit" className="btn btn-default">Submit</button>
                </form>
            </div>
        )
    }
});

module.exports = function (props) {
    var Component = addPhone;
    switch (props.type) {
        case 'laptop' :
            Component = AddLaptop;
            break;
        case 'computer' :
            Component = AddComputer;
            break;
        default :
            break;
    }
    return (
        <Component add={props.add}/>
    )
};