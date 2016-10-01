"use strict";

var React = require('react');

var Footer = React.createClass({
	render: function(){
		return (
		    <div id="footer">
                <div class="container">
                    <p class="text-muted"> Aggregator &copy;  2016 </p>
                </div>
            </div>
		);
	}
});

module.exports = Footer;