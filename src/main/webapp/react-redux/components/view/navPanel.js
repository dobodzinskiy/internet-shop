var {Navbar, Nav, NavDropdown, MenuItem, NavItem, Modal, Button, OverlayTrigger, Popover, ButtonGroup, Dropdown, Glyphicon} = require('react-bootstrap');
var {Link} = require('react-router');
var Cart = require('./cart');
var $ = require('jquery');
var React = require('react');

const NavBarAdmin = React.createClass({
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
                        <NavItem href="#">Clients</NavItem>
                        <NavItem href="#">Orders</NavItem>
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
                            <MenuItem href="#/profile">Profile</MenuItem>
                            <MenuItem href="#/profile/change">Change</MenuItem>
                            <MenuItem href="#/products/phones">Orders</MenuItem>
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
                        <NavItem href="#">
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
                        <NavDropdown title={this.props.currentUser.login} id="basic-nav-dropdown">
                            <MenuItem href="#/profile">Profile</MenuItem>
                            <MenuItem href="#/profile/change">Change</MenuItem>
                            <MenuItem href="#/products/phones">Orders</MenuItem>
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
module.exports = function (props) {
    var NavBar = <NavBarGuest showLogin={props.showLoginModal} showCart={props.showCart}
                              amountInCart={props.cartState.amount}/>;
    switch (props.userState.currentUserRole) {
        case 'ROLE_USER' :
            NavBar = <NavBarUser currentUser={props.userState.currentUser} logout={props.logout} showCart={props.showCart}
                                  amountInCart={props.cartState.amount}/>;
            break;
        case 'ROLE_ADMIN' :
            NavBar = <NavBarAdmin currentUser={props.userState.currentUser} logout={props.logout} showCart={props.showCart}
                             amountInCart={props.cartState.amount}/>;
            break;
        default :
            break;
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
                    <button className="btn btn-primary"
                            onClick={() => {
                                    if(props.cartState.amount == 0) {
                                        alert('Buy something!');
                                    } else {
                                        props.confirmOrder({
                                        products : props.cartState.productsMap,
                                        price : props.cartState.totalPrice
                                        })}
                                    }
                                    }> Confirm </button>
                    <Button onClick={props.showCart}>Close</Button>
                </Modal.Footer>
            </Modal>

            <Modal show={props.userState.isLoginOpen} onHide={props.showLoginModal} bsSize="lg">
                <Modal.Header closeButton>
                    <Modal.Title> <span className="glyphicon glyphicon-log-in"></span> Login </Modal.Title>
                </Modal.Header>
                <LoginForm login={props.login}/>
            </Modal>
        </div>
    )
};