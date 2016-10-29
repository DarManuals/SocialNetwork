"use strict";

var React = require('react');
var Header = require('../common/header');
var Footer = require('../common/footer');

var Search = React.createClass({

    /*getInitialState: function(){
        return {
            users:[{name: 'error'}]
        };
    },

	componentDidMount: function(){
        this.serverRequest = $.get(location.href + "u", function (data) {
            this.setState({users: data});
        }.bind(this));
	},

	componentWillUnmount: function() {
        this.serverRequest.abort();
    },*/

	render: function(){
		return (<div>
                    //{this.state.users[0].username}
				</div>);
	}
});

module.exports = Search;