var React = require('react'),
    ReactDOM = require('react-dom'),
    {Router, hashHistory } = require('react-router'),
    Provider = require('react-redux').Provider,
    store = require('./store'),
    router = require('./router');

ReactDOM.render(
    <Provider store={store}>
        <Router history={hashHistory} routes={router}/>
    </Provider>,
    document.getElementById("app")
);