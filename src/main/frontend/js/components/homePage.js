"use strict";

var React = require('react');
var Router = require('react-router');
var Link = Router.Link;
var Header = require('./common/header');
var Footer = require('./common/footer');

var Home = React.createClass({
	render: function(){
		return (
		    <div className="container">
		        <Header />

                <div className="jumbotron">
                    <h1>PS Amdin</h1>
                    <p>React, Flux, and React Router combined with Browserify, Gulp, and Bootstrap. Build a React and Flux app from scratch</p>
                    <Link to="login" className="btn btn-lg btn-success">login</Link>
			    </div>

			    <Footer />
		    </div>
		);
	}
});

module.exports = Home;