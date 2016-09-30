"use strict";

var React = require('react');
var Router = require('react-router');
var Link = Router.Link;

var NotFound = React.createClass({
	render: function(){
		return (<div>
			<div className="jumbotron">
				<h2> 404 - Page Not Found </h2>
				<Link to="app" className="btn btn-md btn-primary">Go Home</Link>
			</div>
		</div>);
	}
});

module.exports = NotFound;