var {Navbar, Nav, NavDropdown, MenuItem, NavItem, Modal, Button, OverlayTrigger, Tooltip, Well} = require('react-bootstrap');
var Cart = require('./cart');
var $ = require('jquery');
var React = require('react');

const NavBarAdmin = React.createClass({
    render: function () {
        var favoritesAmount = this.props.currentUser.products.length;
        return (
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
                        <NavDropdown title="Add product" id="basic-nav-dropdown">
                            <MenuItem href="#/add/computer">Computer</MenuItem>
                            <MenuItem href="#/add/laptop">Laptop</MenuItem>
                            <MenuItem href="#/add/phone">Phone</MenuItem>
                        </NavDropdown>
                        <NavItem href="#/clients">Clients</NavItem>
                        <NavItem href="#/orders">Orders</NavItem>
                    </Nav>
                    <Nav pullRight>
                        <NavItem href="#"
                                 onClick={(e) => {
                                        e.preventDefault();
                                        this.props.showCart();
                                     }}>
                            <span className="glyphicon glyphicon-shopping-cart"></span> Cart <span
                            className="badge"> {this.props.amountInCart}</span>
                        </NavItem>
                        <NavDropdown title={this.props.currentUser.login} id="basic-nav-dropdown">
                            <MenuItem href="#/profile">
                                Profile
                                <span className="glyphicon glyphicon-user pull-right"></span>
                            </MenuItem>
                            <MenuItem href="#/profile/change">
                                Change
                                <span className="glyphicon glyphicon-option-horizontal pull-right"></span>
                            </MenuItem>
                            <MenuItem href="#/profile/orders">
                                Orders
                                <span className="glyphicon glyphicon-pushpin pull-right"></span>
                            </MenuItem>
                            <MenuItem href="#/profile/favorites">
                                Favorites
                                <span className="badge pull-right"> {favoritesAmount}</span>
                            </MenuItem>
                            <MenuItem divider/>
                            <MenuItem onClick={this.props.logout}> Logout <span
                                className="glyphicon glyphicon-log-out pull-right"></span></MenuItem>
                        </NavDropdown>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
        )
    }
});
const NavBarGuest = React.createClass({
    handleLogin: function () {
        this.props.login($("#loginForm").serialize());
    },
    render: function () {
        return (
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
                            <span className="glyphicon glyphicon-shopping-cart"></span> Cart <span
                            className="badge"> {this.props.amountInCart}</span>
                        </NavItem>
                        <NavItem href="#"
                                 onClick={(e) => {
                                        e.preventDefault();
                                        this.props.showSignUpModal();
                                     }}>
                            <span className="glyphicon glyphicon-user"></span> Sign up
                        </NavItem>
                        <NavItem href="#"
                                 onClick={(e) => {
                                        e.preventDefault();
                                        this.props.showLogin();
                                     }}>
                            <span className="glyphicon glyphicon-log-in"></span> Login
                        </NavItem>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
        )
    }
});
const NavBarUser = React.createClass({
    render: function () {
        var favoritesAmount = this.props.currentUser.products.length;
        return (
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
                            <span className="glyphicon glyphicon-shopping-cart"></span>
                            Cart
                            <span className="badge"> {this.props.amountInCart}</span>
                        </NavItem>
                        <NavDropdown title={this.props.currentUser.login} id="basic-nav-dropdown">
                            <MenuItem href="#/profile">
                                Profile
                                <span className="glyphicon glyphicon-user pull-right"></span>
                            </MenuItem>
                            <MenuItem href="#/profile/change">
                                Change
                                <span className="glyphicon glyphicon-option-horizontal pull-right"></span>
                            </MenuItem>
                            <MenuItem href="#/profile/orders">
                                Orders
                                <span className="glyphicon glyphicon-pushpin pull-right"></span>
                            </MenuItem>
                            <MenuItem href="#/profile/favorites">
                                Favorites
                                <span className="badge pull-right"> {favoritesAmount}</span>
                            </MenuItem>
                            <MenuItem divider/>
                            <MenuItem onClick={this.props.logout}>
                                Logout <span className="glyphicon glyphicon-log-out pull-right"></span>
                            </MenuItem>
                        </NavDropdown>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
        )
    }
});
const LoginForm = React.createClass({
    handleLogin: function () {
        this.props.login($("#loginForm").serialize());
    },
    render: function () {
        return (
            <form role="form" action="/j_spring_security_check" method="post" id="loginForm"
                  onSubmit={(e) => {e.preventDefault(); this.handleLogin();}}>
                <Modal.Body>
                    <div className="form-group">
                        <label for="login">Login:</label>
                        <input className="form-control" id="login" placeholder="Enter login" name="j_username"/>
                    </div>
                    <div className="form-group">
                        <label for="pwd"> Password:</label>
                        <input type="password" className="form-control" id="pwd" placeholder="Enter password"
                               name="j_password"/>
                    </div>
                </Modal.Body>
                <Modal.Footer>
                    <button type="submit" className="btn btn-primary"> Submit</button>
                </Modal.Footer>
            </form>
        )
    }
});
const SignUpForm = React.createClass({
    isFormValid: function (form) {
        var isValid = true;
        if (form.login == '') {
            $("#login-error").html("<br/><div class='alert alert-danger'>Login cannot be empty!</div>");
            isValid = false;
        } else {
            this.props.isLoginUnique(form.login)
                .then(data => {
                    if (data) {
                        $("#login-error").html("");
                    } else {
                        $("#login-error").html("<br/><div class='alert alert-danger'>Login is not unique!</div>");
                        isValid = false;
                    }
                });
        }
        var regExpEmail = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,13}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        if (!regExpEmail.test(form.email)) {
            $("#email-error").html("<br/><div class='alert alert-danger'>Not valid email!</div>");
            isValid = false;
        } else {
            $("#email-error").html("");
        }
        var regExpPhone = /(380+[0-9]{9})/;
        if (!regExpPhone.test(form.phone)) {
            $("#phone-error").html("<br/><div class='alert alert-danger'>Phone is not valid!</div>");
            isValid = false;
        } else {
            $("#phone-error").html("");
        }
        if (form.password == '') {
            $("#password-error").html("<br/><div class='alert alert-danger'>Password cannot be empty!</div>");
            isValid = false;
        } else {
            $("#password-error").html("");
        }
        return isValid;
    },
    handleSignUp: function () {
        var form = {
            login: $("#login").val(),
            email: $("#email").val(),
            phone: $("#phone").val(),
            password: $("#password").val()
        };
        if (this.isFormValid(form)) {
            this.props.signUp(form);
        }
    },
    render: function () {
        return (
            <form id="sign-form" role="form" onSubmit={(e) => {e.preventDefault(); this.handleSignUp();}}>
                <Modal.Body>
                    <div className="form-group">
                        <label for="login">Login:</label>
                        <input className="form-control" id="login" placeholder="Enter login"/>
                        <div id="login-error"></div>
                    </div>
                    <div className="form-group">
                        <label for="email">Email:</label>
                        <input className="form-control" id="email" placeholder="Enter email"/>
                        <div id="email-error"></div>
                    </div>
                    <div className="form-group">
                        <label for="phone">Phone:</label>
                        <input className="form-control" id="phone" placeholder="Enter phone"/>
                        <div id="phone-error"></div>
                    </div>
                    <div className="form-group">
                        <label for="password"> Password:</label>
                        <input type="password" className="form-control" id="password" placeholder="Enter password"/>
                        <div id="password-error"></div>
                    </div>
                </Modal.Body>
                <Modal.Footer>
                    <button type="submit" className="btn btn-primary"> Sign up</button>
                </Modal.Footer>
            </form>
        )
    }
});

module.exports = function (props) {
    var NavBar = <NavBarGuest showLogin={props.showLoginModal} showSignUpModal={props.showSignUpModal}
                              showCart={props.showCart}
                              amountInCart={props.cartState.amount}/>;
    switch (props.userState.currentUserRole) {
        case 'ROLE_USER' :
            NavBar =
                <NavBarUser currentUser={props.userState.currentUser} logout={props.logout} showCart={props.showCart}
                            amountInCart={props.cartState.amount}/>;
            break;
        case 'ROLE_ADMIN' :
            NavBar =
                <NavBarAdmin currentUser={props.userState.currentUser} logout={props.logout} showCart={props.showCart}
                             amountInCart={props.cartState.amount}/>;
            break;
        default :
            break;
    }
    var Confirm = (
        <Button bsStyle="primary" disabled>Confirm</Button>
    );
    if (props.userState.currentUser != null) {
        if (props.cartState.amount == 0) {
            Confirm = (
                <Button bsStyle="primary" disabled>Confirm</Button>
            );
        } else {
            Confirm = (
                <button className="btn btn-primary"
                        onClick={(e) => {
                                        e.preventDefault();
                                        props.confirmOrder({
                                            products : props.cartState.productsMap,
                                            price : props.cartState.totalPrice
                                        })}
                                    }>
                    Confirm
                </button>
            );
        }
    }
    return (
        <div>
            {NavBar}

            <Modal show={props.cartState.isCartOpen} onHide={props.showCart} bsSize="large">
                <Modal.Header closeButton>
                    <Modal.Title> Cart <span className="glyphicon glyphicon-shopping-cart"></span> </Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <p> Amount : {props.cartState.amount}</p>
                    <Cart productsMap={props.cartState.productsMap}
                          add={props.addInCart}
                          subtract={props.subtractInCart}
                          fromCart={props.fromCart}/>
                    <p>Total Price : {props.cartState.totalPrice} UAH </p>
                </Modal.Body>
                <Modal.Footer>
                    {Confirm}
                    <Button onClick={props.showCart}>Close</Button>
                </Modal.Footer>
            </Modal>

            <Modal show={props.userState.isLoginOpen} onHide={props.showLoginModal} bsSize="lg">
                <Modal.Header closeButton>
                    <Modal.Title> <span className="glyphicon glyphicon-log-in"></span> Login </Modal.Title>
                </Modal.Header>
                <LoginForm login={props.login}/>
            </Modal>

            <Modal show={props.userState.isSignUpOpen} onHide={props.showSignUpModal} bsSize="lg">
                <Modal.Header closeButton>
                    <Modal.Title> <span className="glyphicon glyphicon-log-in"></span> Sign up </Modal.Title>
                </Modal.Header>
                <SignUpForm isLoginUnique={props.isLoginUnique} signUp={props.signUp}/>
            </Modal>
        </div>
    )
};