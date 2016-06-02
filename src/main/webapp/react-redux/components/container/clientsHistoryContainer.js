var React = require('react');
var ReactRedux = require('react-redux');
var Redux = require('redux');
var clientsApi = require('../../api/clientsApi');
var ClientHistory = require('../view/clientHistory');
var Spinner = require('../view/spinner');
var { cleanHistory } = require('../../actions/clientsActions');

var ClientsHistoryContainer = React.createClass({
    componentDidMount: function () {
        clientsApi.getClientHistory(this.props.params.id);
    },
    componentWillUnmount : function() {
        this.props.cleanHistory();
    },
    render: function () {
        if(this.props.clientHistory) {
            return (
                <ClientHistory clientHistory={this.props.clientHistory}/>
            )
        }
        return <Spinner />
    }
});
const mapStateToProps = function (store) {
    return {
        clientHistory: store.clientsState.clientHistory
    }
};
const mapDispatchToProps = (dispatch) => Redux.bindActionCreators({
    cleanHistory
}, dispatch);

module.exports = ReactRedux.connect(mapStateToProps, mapDispatchToProps)(ClientsHistoryContainer);