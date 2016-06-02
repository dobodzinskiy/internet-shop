var React = require('react');
var $ = require('jquery');
var { Image, Button } = require('react-bootstrap');
var { Link } = require('react-router');

const Phones = React.createClass({
    render: function () {
        var {product} = this.props;
        var isDualSim = (product.dualSim) == true ? 'Yes' : 'No';
        return (
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
    render: function () {
        var {product} = this.props;
        var isKeyboardLight = (product.keyboardLight) == true ? 'Yes' : 'No';
        return (
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
    render: function () {
        var {product} = this.props;
        return (
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
const ProductPanel = React.createClass({
    render: function () {
        var { product } = this.props;
        var { userState } = this.props;

        var photo = "../resources/images/" + product.photo;
        var Buy = <Button bsStyle="primary"
                          onClick={(e) => { e.preventDefault(); this.props.toCart(product);}}>To cart</Button>;
        if (!product.available) {
            Buy = <Button bsStyle="primary" disabled> To cart </Button>;
        }
        var Favorite = null;
        var Change = null;
        if (userState.currentUser != null) {
            if (userState.currentUserRole == "ROLE_ADMIN") {
                Change = <Link className="btn btn-default" to={this.props.urlChange}> Change </Link>
            }
            var isFavorite = false;
            userState.currentUser.products.forEach((favorite) => {
                if (favorite.id == product.id) {
                    isFavorite = true;
                }
            });
            if (isFavorite) {
                Favorite = <span className="glyphicon glyphicon-heart"
                                 onClick={(e) => {e.preventDefault(); this.props.fromFavorites(product.id);}}>

                </span>;
            } else {
                Favorite =
                    <span className="glyphicon glyphicon-heart-empty"
                          onClick={(e) => {e.preventDefault(); this.props.toFavorites(product.id);}}>
                    </span>;
            }
        }

        var Component = Phones;
        switch (product.type) {
            case 'phones' :
                Component = Phones;
                break;
            case 'laptops':
                Component = Laptops;
                break;
            case 'computers':
                Component = Computers;
                break;
            default :
                break;
        }
        return (
            <div className="row">
                <h2> {product.name} &nbsp;
                    {Favorite}
                </h2>
                <div className="col-sm-8">
                    <div className="panel panel-default">
                        <div className="panel-heading">
                            Model : {product.model}
                        </div>
                        <div className="panel-body">
                            <Image src={photo} responsive/>
                            <br/>
                            {Buy} &nbsp;
                            {Change} &nbsp;
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
    handleSubmit: function () {
        var commentId = this.props.comment.id;
        this.props.onDelete(commentId);
    },
    render: function () {
        var {comment} = this.props;
        var Delete = null;
        if (this.props.userState.currentUserRole == "ROLE_ADMIN") {
            Delete = <span className="glyphicon glyphicon glyphicon-remove" onClick={this.handleSubmit}></span>;
        }
        if (this.props.userState.currentUser != null) {
            if (comment.username == this.props.userState.currentUser.login) {
                Delete = <span className="glyphicon glyphicon glyphicon-remove" onClick={this.handleSubmit}></span>;
            }
        }
        return (
            <div className="col-sm-12">
                <h4>
                    {comment.username}
                    <small className="pull-right"> {comment.date} {Delete}</small>
                </h4>
                <p> {comment.text} </p>
                <h5> Rated: {comment.rate} <span className="glyphicon glyphicon-star"/></h5>
                <hr />
            </div>
        )
    }
});
const LeaveComment = React.createClass({
    isCommentValid(comment) {
        if(comment < 2 || comment > 100) {
            $("#comment-error").html("<br/><div class='alert alert-danger'>Comment should have 2-100 chars!</div>");
            return false;
        } else {
            return true;
        }
    },
    handleSubmit: function (e) {
        e.preventDefault();
        var comment = $("#comment");
        var rate = $("#rate");
        var date = new Date();
        var productId = this.props.productId;
        if (this.isCommentValid(comment.val())) {
            this.props.onSubmit({
                "productId": productId,
                "text": comment.val(),
                "rate": rate.val(),
                "date": date,
                "username": this.props.currentUser.login
            });
            comment.val('');
        }
    },
    postCommentForm(currentUser) {
        return currentUser ? (
            <div>
                <hr />
                <form role="form" id="commentForm" onSubmit={this.handleSubmit}>
                    <div className="form-group" id="comment-group">
                        <label for="comment">Comment:
                            <small id="comment-message"></small>
                        </label>
                        <textarea type="text" className="form-control"
                                  id="comment" placeholder="Enter comment here"></textarea>
                        <div id="comment-error"></div>
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
        ) : (
            <div>
                <hr />
                <h3>Log in or sign up to leave comments!</h3>
            </div>
        );
    },

    render: function () {
        const { currentUser } = this.props;

        return this.postCommentForm(currentUser);
    }

});
const CommentsPanel = React.createClass({
    render: function () {
        var { comments } = this.props;
        var { userState } = this.props;
        return (
            <div className="row">
                <div className="col-sm-12">
                    <div className="panel panel-default">
                        <div className="panel-body">
                            <LeaveComment currentUser={userState.currentUser} onSubmit={this.props.onSubmit}
                                          productId={this.props.productId}/>
                            <div id="comments">
                                <p><span className="badge"> {comments.length} </span> Comments: </p>
                                <br />
                                {comments.map((comment) => {
                                    return (
                                        <Comment comment={comment}
                                                 key={comment.id}
                                                 userState={this.props.userState}
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

module.exports = function (props) {
    return (
        <div className="container">
            <ProductPanel product={props.product}
                          toCart={props.toCart}
                          toFavorites={props.toFavorites}
                          fromFavorites={props.fromFavorites}
                          key={props.product.id}
                          urlChange={props.urlChange}
                          userState={props.userState}/>
            <CommentsPanel productId={props.product.id}
                           comments={props.comments}
                           onSubmit={props.onSubmit}
                           onDelete={props.onDelete}
                           userState={props.userState}/>
        </div>
    )
};