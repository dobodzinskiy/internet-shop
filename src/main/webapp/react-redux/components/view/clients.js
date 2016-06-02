var React = require('react');
var $ = require('jquery');
var { ButtonGroup, Button, Modal, OverlayTrigger, Popover } = require('react-bootstrap');
var { hashHistory } = require('react-router');

const ClientModal = React.createClass({
    render: function () {
        var { client } = this.props;
        if(client) {
            return(
                <Modal show={this.props.isOpen} onHide={this.props.hide} bsSize="large">
                    <Modal.Header closeButton>
                        <Modal.Title>Login: {client.login}</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                        <table className="table">
                            <tbody>
                            <tr>
                                <td>Name:</td>
                                <td>{client.firstName}</td>
                            </tr>
                            <tr>
                                <td>Last name:</td>
                                <td>{client.lastName}</td>
                            </tr>
                            <tr>
                                <td>Gender:</td>
                                <td>{client.gender}</td>
                            </tr>
                            <tr>
                                <td>Email:</td>
                                <td>{client.email}</td>
                            </tr>
                            <tr>
                                <td>Phone:</td>
                                <td>{client.phone}</td>
                            </tr>
                            </tbody>
                        </table>
                    </Modal.Body>
                </Modal>
            )
        }
        return(<p></p>)
    }
});
const Client = React.createClass({
    render: function () {
        var blockButton = "Block";
        var { client } = this.props;
        switch (client.enabled) {
            case false:
                blockButton = "Unblock";
        }
        return (
            <tr>
                <td>{client.id}</td>
                <td>
                    <button className="btn btn-link"
                            onClick={(e) => {e.preventDefault(); this.props.showClientModal(client.id);}}> {client.login} </button>
                </td>
                <td>{client.firstName} {client.lastName}</td>
                <td>{client.date}</td>
                <td>
                    <ButtonGroup>
                        <Button bsStyle="danger"
                                onClick={(e) => {e.preventDefault(); this.props.blockClient(client.id);}}>
                            {blockButton}
                        </Button>
                        <Button
                            onClick={(e) => {e.preventDefault(); hashHistory.replace('/clients/history/' + client.id); }}>
                            History
                        </Button>
                        <OverlayTrigger trigger="click" rootClose
                                        placement="bottom"
                                        overlay={
                                        <Popover title="Send message" id="message-popover">
                                               <form role="form" onSubmit={(e) => {
                                                    e.preventDefault();
                                                    this.props.sendMessage(client.id, $("#message").val(), $("#subject").val())}}>
                                                    <input className="form-control" id="subject" placeholder="Subject" />
                                                    <br/>
                                                    <textarea className="form-control" id="message" placeholder="Message" rows="3"/>
                                                    <br/>
                                                    <button className="btn btn-primary" type="submit">Send</button>
                                                </form>
                                        </Popover>}>
                            <Button>Contact</Button>
                        </OverlayTrigger>
                    </ButtonGroup>
                </td>
            </tr>
        )
    }
});


module.exports = function (props) {
    return (
        <div className="container">
            <h1>Clients:</h1>
            <table className="table">
                <thead>
                <tr>
                    <th>Client id</th>
                    <th>Login</th>
                    <th>Full name</th>
                    <th>Registration</th>
                    <th>Options</th>
                </tr>
                </thead>
                <tbody>
                {props.clients.map((client) => {
                    return (
                        <Client key={client.id}
                                client={client}
                                showClientModal={props.showClientModal}
                                sendMessage={props.sendMessage}
                                blockClient={props.blockClient}/>
                    )
                })}
                </tbody>
            </table>
            <ClientModal client={props.client} isOpen={props.isClientModalOpen} hide={props.hideClientModal} />
        </div>
    )
};