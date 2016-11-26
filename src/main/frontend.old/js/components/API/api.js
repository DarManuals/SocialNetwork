"use strict";

var $ = require('jquery');

var UserApi = {

	getAllUsers: function() {
        var users = {};

		//this.serverRequest =
		$.get(location.pathname = "/search", function (data) {
            users = data;
        }.bind(this));

        //this.serverRequest.abort();

        return users;
	},

	getAuthorById: function(id) {

	},

	deleteAuthor: function(id) {

	}
};

module.exports = UserApi;