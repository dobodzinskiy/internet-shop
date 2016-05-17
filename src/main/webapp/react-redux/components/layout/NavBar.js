var React = require('react');
var Redux = require('redux');
var ReactRedux = require("react-redux");
var Cart = require('./../view/cart');
var {Navbar, Nav, NavDropdown, MenuItem, NavItem, Modal, Button } = require('react-bootstrap');
var { showCart, addInCart, subtractInCart, fromCart } = require('../../actions/cartActions');
var { showLogin } = require('../../actions/userActions');
var userApi = require('../../api/userApi');
var orderApi = require('../../api/orderApi');
var $ = require('jquery');

const NavBarAdmin = React.createClass({
    render : function() {
        return(
            <Navbar inverse>
                <Navbar.Header>
                    <Navbar.Brand>
                        <a href="#/">I-shop</a>
                    </Navbar.Brand>
                    <Navbar.Toggle />
                </Navbar.Header>
                <Navbar.Collapse>
                    <Nav>
                        <NavDropdown title="Products" id="basic-nav-dropdown">
                            <MenuItem href="#/products/computers">Computers</MenuItem>
                            <MenuItem href="#/products/laptops">Laptops</MenuItem>
                            <MenuItem href="#/products/phones">Phones</MenuItem>
                        </NavDropdown>
                        <NavItem href="#">Clients</NavItem>
                        <NavItem href="#">Orders</NavItem>
                    </Nav>
                    <Nav pullRight>
                        <NavItem href="#"
                                 onClick={(e) => {
                                        e.preventDefault();
                                        this.props.showCart();
                                     }}>
                            <span className="glyphicon glyphicon-shopping-cart"></span> Cart <span className="badge"> {this.props.amountInCart}</span>
                        </NavItem>
                        <NavItem href="#">{this.props.login}</NavItem>
                        <NavItem href="#" 
                                 onClick={this.props.logout} >
                            Logout
                        </NavItem>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
        )
    }
});
const NavBarGuest = React.createClass({
    handleLogin : function() {
        userApi.login($("#loginForm").serialize());
    },
    render : function() {
        return(
            <div>
                <Navbar inverse>
                    <Navbar.Header>
                        <Navbar.Brand>
                            <a href="#/">I-shop</a>
                        </Navbar.Brand>
                        <Navbar.Toggle />
                    </Navbar.Header>
                    <Navbar.Collapse>
                        <Nav>
                            <NavDropdown title="Products" id="basic-nav-dropdown">
                                <MenuItem href="#/products/computers">Computers</MenuItem>
                                <MenuItem href="#/products/laptops">Laptops</MenuItem>
                                <MenuItem href="#/products/phones">Phones</MenuItem>
                            </NavDropdown>
                        </Nav>
                        <Nav pullRight>
                            <NavItem href="#"
                                     onClick={(e) => {
                                        e.preventDefault();
                                        this.props.showCart();
                                     }}>
                                <span className="glyphicon glyphicon-shopping-cart"></span> Cart <span className="badge"> {this.props.amountInCart}</span>
                            </NavItem>
                            <NavItem href="#">Sign up</NavItem>
                            <NavItem href="#"
                                     onClick={(e) => {
                                        e.preventDefault();
                                        userApi.login();
                                     }}>
                                Login
                            </NavItem>
                        </Nav>
                    </Navbar.Collapse>
                </Navbar>
                <div className="container">
                    <form role="form" action="/j_spring_security_check" method="post" id="loginForm" onSubmit={(e) => {e.preventDefault(); this.handleLogin();}} >
                        <div className="form-group">
                            <label for="login">Login:</label>
                            <input className="form-control" id="login" placeholder="Enter login" name="j_username" />
                        </div>
                        <div className="form-group">
                            <label for="pwd"> Password:</label>
                            <input type="password" className="form-control" id="pwd" placeholder="Enter password" name="j_password" />
                        </div>
                        <button type="submit" className="btn btn-default"> Submit</button>
                    </form>
                </div>
            </div>
        )
    }
});
const NavBarUser = React.createClass({
    render : function() {
        return(
            <Navbar inverse>
                <Navbar.Header>
                    <Navbar.Brand>
                        <a href="#/">I-shop</a>
                    </Navbar.Brand>
                    <Navbar.Toggle />
                </Navbar.Header>
                <Navbar.Collapse>
                    <Nav>
                        <NavDropdown title="Products" id="basic-nav-dropdown">
                            <MenuItem href="#/products/computers">Computers</MenuItem>
                            <MenuItem href="#/products/laptops">Laptops</MenuItem>
                            <MenuItem href="#/products/phones">Phones</MenuItem>
                        </NavDropdown>
                    </Nav>
                    <Nav pullRight>
                        <NavItem href="#"
                                 onClick={(e) => {
                                        e.preventDefault();
                                        this.props.showCart();
                                     }}>
                            <span className="glyphicon glyphicon-shopping-cart"></span> Cart <span className="badge"> {this.props.amountInCart}</span>
                        </NavItem>
                        <NavItem href="#">{this.props.login}</NavItem>
                        <NavItem href="/j_spring_security_logout" 
                                 onClick={this.props.logout} >
                            Logout
                        </NavItem>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
        )
    }
});

var Navigation = React.createClass({
    render : function () {
        var NavBar = NavBarGuest;
        switch (this.props.currentUserRole) {
            case 'ROLE_USER' :
                NavBar = NavBarUser;
                break;
            case 'ROLE_ADMIN' :
                NavBar = NavBarAdmin;
                break;
            case null : break;
        }
        return(
            <div>
                <NavBar  />
                {this.props.children}
                <Modal show={this.props.isCartOpen} onHide={this.props.showCart} bsSize="large">
                    <Modal.Header closeButton>
                        <Modal.Title> Cart <span className="glyphicon glyphicon-shopping-cart"></span> </Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                        <p> Amount : {this.props.amountInCart}</p>
                        <Cart productsMap={this.props.productsMap}
                              add={this.props.addInCart}
                              subtract={this.props.subtractInCart}
                              fromCart={this.props.fromCart} />
                        <p>Total Price : {this.props.totalPrice} UAH </p>
                    </Modal.Body>
                    <Modal.Footer>
                        <Button bsStyle="primary"
                                onClick={() => {
                                    orderApi.confirmOrder({
                                        products : this.props.productsMap,
                                        price : this.props.totalPrice
                                        })}
                                    }> Confirm </Button>
                        <Button onClick={this.props.showCart}>Close</Button>
                    </Modal.Footer>
                </Modal>
                
            </div>
        )
    }
});

const mapStateToProps = function(store) {
    return {
        isCartOpen : store.cartState.isCartOpen,
        productsMap : store.cartState.productsMap,
        totalPrice : store.cartState.totalPrice,
        amountInCart : store.cartState.amount,

        currentUser : store.userState.currentUser,
        currentUserRole : store.userState.currentUserRole,
        isLoginOpen : store.userState.isLoginOpen
    }
};
const mapDispatchToProps = (dispatch) => Redux.bindActionCreators({
    showCart, addInCart, subtractInCart, fromCart,
    showLogin
}, dispatch);

module.exports = ReactRedux.connect(mapStateToProps, mapDispatchToProps)(Navigation);