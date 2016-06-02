var React = require('react');
var Redux = require('redux');
var ReactRedux = require('react-redux');
var clientsApi = require('../../api/clientsApi');
var Clients = require('../view/clients');
var { showClientModal, hideClientModal } = require('../../actions/clientsActions');

var ClientsContainer = React.createClass({
    componentDidMount : function() {
        clientsApi.getClients();
    },
    render : function() {
        if(this.props.userState.currentUserRole != "ROLE_ADMIN") {
            return(
                <div className="container text-center">
                    <img src="../resources/images/404.jpg"/>
                </div>
            )
        }
        if(this.props.children) {
            return(
                <div>
                    {this.props.children}
                </div>
            )
        }
        return(
            <Clients clients={this.props.clients}
                     client={this.props.client}
                     showClientModal={this.props.showClientModal}
                     hideClientModal={this.props.hideClientModal}
                     isClientModalOpen={this.props.isClientModalOpen}
                     sendMessage={clientsApi.sendMessage}
                     blockClient={clientsApi.blockClient}  />
        )
    }
});
const mapStateToProps = function (store) {
    return {
        clients: store.clientsState.clients,
        client: store.clientsState.client,
        isClientModalOpen: store.clientsState.isClientModalOpen,
        clientHistory : store.clientsState.clientHistory,

        userState : store.userState
    }
};
const mapDispatchToProps = (dispatch) => Redux.bindActionCreators({
    showClientModal, hideClientModal
}, dispatch);

module.exports = ReactRedux.connect(mapStateToProps, mapDispatchToProps)(ClientsContainer);

