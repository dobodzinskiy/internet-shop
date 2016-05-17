var React = require('react');
var $ = require('jquery');
var { Image, Button } = require('react-bootstrap');
var { Link } = require('react-router');

const Phones = React.createClass({
    render : function () {
        var {product} = this.props;
        var isDualSim = (product.dualSim) == true ? 'Yes' : 'No' ;
        return(
            <div>
                <table className="table table-hover">
                    <tbody>
                    <tr>
                        <td><b>Company</b></td>
                        <td>{product.company}</td>
                    </tr>
                    <tr>
                        <td><b>Weight</b></td>
                        <td>{product.weight}</td>
                    </tr>
                    <tr>
                        <td><b>Size</b></td>
                        <td>{product.size}</td>
                    </tr>
                    <tr>
                        <td><b>Storage</b></td>
                        <td>{product.storage}</td>
                    </tr>
                    <tr>
                        <td><b>RAM</b></td>
                        <td>{product.ram}</td>
                    </tr>
                    <tr>
                        <td><b>Screen</b></td>
                        <td>{product.screen}</td>
                    </tr>
                    <tr>
                        <td><b>OS</b></td>
                        <td>{product.os}</td>
                    </tr>
                    <tr>
                        <td><b>Color</b></td>
                        <td>{product.color}</td>
                    </tr>
                    <tr>
                        <td><b>Processor</b></td>
                        <td>{product.processor}</td>
                    </tr>
                    <tr>
                        <td><b>DualSim</b></td>
                        <td>{isDualSim}</td>
                    </tr>
                    <tr>
                        <td><b>Sim types</b></td>
                        <td>{product.simType}</td>
                    </tr>
                    <tr>
                        <td><b>Message types</b></td>
                        <td>{product.messageType}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        )
    }
});
const Laptops = React.createClass({
    render : function () {
        var {product} = this.props;
        var isKeyboardLight = (product.keyboardLight) == true ? 'Yes' : 'No' ;
        return(
            <div>
                <table className="table table-hover">
                    <tbody>
                    <tr>
                        <td><b>Company</b></td>
                        <td>{product.company}</td>
                    </tr>
                    <tr>
                        <td><b>Weight</b></td>
                        <td>{product.weight}</td>
                    </tr>
                    <tr>
                        <td><b>Size</b></td>
                        <td>{product.size}</td>
                    </tr>
                    <tr>
                        <td><b>Storage</b></td>
                        <td>{product.storage}</td>
                    </tr>
                    <tr>
                        <td><b>RAM</b></td>
                        <td>{product.ram}</td>
                    </tr>
                    <tr>
                        <td><b>Screen</b></td>
                        <td>{product.screen}</td>
                    </tr>
                    <tr>
                        <td><b>OS</b></td>
                        <td>{product.os}</td>
                    </tr>
                    <tr>
                        <td><b>Color</b></td>
                        <td>{product.color}</td>
                    </tr>
                    <tr>
                        <td><b>Processor</b></td>
                        <td>{product.processor}</td>
                    </tr>
                    <tr>
                        <td><b>Keyboard light</b></td>
                        <td>{isKeyboardLight}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        )
    }
});
const Computers = React.createClass({
    render : function () {
        var {product} = this.props;
        return(
            <div>
                <table className="table table-hover">
                    <tbody>
                    <tr>
                        <td><b>Company</b></td>
                        <td>{product.company}</td>
                    </tr>
                    <tr>
                        <td><b>Weight</b></td>
                        <td>{product.weight}</td>
                    </tr>
                    <tr>
                        <td><b>Size</b></td>
                        <td>{product.size}</td>
                    </tr>
                    <tr>
                        <td><b>Storage</b></td>
                        <td>{product.storage}</td>
                    </tr>
                    <tr>
                        <td><b>RAM</b></td>
                        <td>{product.ram}</td>
                    </tr>
                    <tr>
                        <td><b>Screen</b></td>
                        <td>{product.screen}</td>
                    </tr>
                    <tr>
                        <td><b>OS</b></td>
                        <td>{product.os}</td>
                    </tr>
                    <tr>
                        <td><b>Color</b></td>
                        <td>{product.color}</td>
                    </tr>
                    <tr>
                        <td><b>Processor</b></td>
                        <td>{product.processor}</td>
                    </tr>
                    <tr>
                        <td><b>Motherboard</b></td>
                        <td>{product.motherboard}</td>
                    </tr>
                    <tr>
                        <td><b>Cooling system</b></td>
                        <td>{product.coolingSystem}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        )
    }
});
const  ProductPanel = React.createClass({
    render : function () {
        var product = this.props.product;
        var photoUrl = "/resources/images/" + product.photo;
        var Component = Phones;
        switch(product.type) {
            case 'PHONES' :
                Component = Phones;
                break;
            case 'LAPTOPS':
                Component = Laptops;
                break;
            case 'COMPUTERS':
                Component = Computers;
                break;
            default :
                break;
        }
        return(
            <div className="row">
                <h2> {product.name} </h2>
                <div className="col-sm-8">
                    <div className="panel panel-default">
                        <div className="panel-heading">
                            Model : {product.model}
                        </div>
                        <div className="panel-body">
                            <Image src={photoUrl} responsive />
                            <br/>
                            <Button bsStyle="primary" onClick={(e) => { e.preventDefault(); this.props.toCart(product);}}>Buy</Button> &nbsp;
                            <Link className="btn btn-default" to={this.props.urlChange}> Change </Link> &nbsp;
                            {product.price} UAH
                            <br/>
                            <br/>
                            <h3>Description</h3>
                            <h5>{product.description}</h5>
                        </div>
                    </div>
                </div>
                <div className="col-sm-4" height="500px;">
                    <div className="panel panel-default">
                        <div className="panel-heading">Details</div>
                        <Component product={product}/>
                    </div>
                </div>
            </div>
        )
    }
});

const Comment = React.createClass({
    handleSubmit : function() {
        var commentId = this.props.comment.id;
        this.props.onDelete(commentId);
    },
    render : function () {
        var {comment} = this.props;
        return (
            <div className="col-sm-10">
                <h4>
                    {comment.username}
                    <small> <button onClick={this.handleSubmit} className="btn btn-danger btn-sm">Remove</button> </small>
                    <br />
                    <br />
                    <small> {comment.date} </small>
                </h4>
                <p> {comment.text} </p>
                <h5> Rated: {comment.rate} <span className="glyphicon glyphicon-star" /> </h5>
                <hr />
            </div>
        )
    }
});
const LeaveComment = React.createClass({

    handleSubmit : function(e) {
        e.preventDefault();
        var comment =  $("#comment");
        var rate = $("#rate");
        var date = new Date();
        var productId = this.props.productId;

        this.props.onSubmit({
            "productId" : productId,
            "text" : comment.val(),
            "rate" : rate.val(),
            "date" : date,
            "username" : this.props.currentUser.login
        });

        comment.val('');

    },
    render : function () {
        return(
            <div>
                <hr />
                <form role="form" onSubmit={this.handleSubmit}>
                    <div className="form-group">
                        <label for="comment">Comment:</label>
                        <textarea type="email" className="form-control" id="comment" placeholder="Enter comment here"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="rate">Rating :</label>
                        <select className="form-control" id="rate" placeholder="Select rate">
                            <option value="1">&#9733;</option>
                            <option value="2">&#9733;&#9733;</option>
                            <option value="3">&#9733;&#9733;&#9733;</option>
                            <option value="4">&#9733;&#9733;&#9733;&#9733;</option>
                            <option value="5">&#9733;&#9733;&#9733;&#9733;&#9733;</option>
                        </select>
                    </div>
                    <br />
                    <button type="submit" className="btn btn-default">Submit</button>
                </form>
                <br />
            </div>
        )
    }
});
const CommentsPanel = React.createClass({
    render : function() {
        var { comments } = this.props;
        return(
            <div className="row">
                <div className="col-sm-12">
                    <div className="panel panel-default">
                        <div className="panel-body">
                            <LeaveComment currentUser={this.props.currentUser} onSubmit={this.props.onSubmit} productId={this.props.productId}/>
                            <div id="comments">
                                <p><span className="badge"> {comments.length} </span> Comments: </p>
                                <br />
                                {comments.map((comment) => {
                                    return(
                                        <Comment comment={comment}
                                                 key={comment.id}
                                                 onDelete={this.props.onDelete}/>
                                    )
                                })}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
});

module.exports = function(props) {
    return (
            <div className="container">
                <ProductPanel product={props.product}
                              toCart={props.toCart}
                              key={props.product.id}
                              urlChange={props.urlChange}/>
                <CommentsPanel productId={props.product.id}
                               comments={props.comments}
                               onSubmit={props.onSubmit}
                               onDelete={props.onDelete}
                               currentUser={props.currentUser}/>
            </div>
        )
};