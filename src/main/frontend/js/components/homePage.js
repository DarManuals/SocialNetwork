"use strict";

var React = require('react');
var Router = require('react-router');
var Link = Router.Link;

var Home = React.createClass({
	render: function(){
		return (<div className="jumbotron">
			<h1>PS Amdin</h1>
			<p>React, Flux, and React Router combined with Browserify, Gulp, and Bootstrap. Build a React and Flux app from scratch</p>
			<Link to="about" className="btn btn-lg btn-success">Read more</Link>
		</div>);
	}
});

module.exports = Home;