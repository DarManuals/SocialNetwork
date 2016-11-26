"use strict";

var React = require('react');
var Header = require('../common/header');
var Footer = require('../common/footer');

var About = React.createClass({

	render: function(){
		return (<div>
		    <Header />

            <div className="container">
                <h1>PS Amdin about</h1>
                <p>This`s about page</p>
            </div>

			<Footer />
		</div>);
	}
});

module.exports = About;