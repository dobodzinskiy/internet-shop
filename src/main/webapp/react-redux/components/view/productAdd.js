//var React = require('react');
//var $ = require('jquery');
//
//const addPhone = React.createClass({
//    handleAdd: function (e) {
//        e.preventDefault();
//        if (confirm('Add product?')) {
//
//        }
//    },
//    render: function () {
//        return (
//            <div className="container">
//                <h2>Type : <b>Phone</b></h2>
//                <form role="form" onSubmit={this.handleAdd}>
//                    <div class="form-group">
//                        <label for="name">Name:</label>
//                        <input type="text" class="form-control" id="name"/>
//                    </div>
//                    <div class="form-group">
//                        <label for="pwd">Password:</label>
//                        <input type="password" class="form-control" id="pwd"/>
//                    </div>
//                    <div class="checkbox">
//                        <label><input type="checkbox"/> Remember me</label>
//                    </div>
//                    <button type="submit" class="btn btn-default">Submit</button>
//                </form>
//            </div>
//        )
//    }
//});
//const addLaptop = React.createClass({
//    handleAdd: function (e) {
//        e.preventDefault();
//        if (confirm('Add product?')) {
//
//        }
//    },
//});
//const addComputer = React.createClass({
//    handleAdd: function (e) {
//        e.preventDefault();
//        if (confirm('Add product?')) {
//
//        }
//    },
//});
//
//module.exports = function (props) {
//    var Component = addPhone;
//    switch (props.type) {
//        case 'latops' :
//            Component = addLaptop;
//            break;
//        case 'computers' :
//            Component = addComputer;
//            break;
//        default :
//            break;
//    }
//    return (
//        <Component add={props.add}/>
//    )
//};