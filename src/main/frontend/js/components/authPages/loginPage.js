"use strict";

var React = require('react');
var Router = require('react-router');
var Link = Router.Link;

var Login = React.createClass({
	render: function(){
		return (
            <div className="container">
                <h1>Форма входа</h1>

                <div className="container">
                    <form name="f" className="form-signin" role="form" action="/login" method="POST" style={{'max-width': '40%'}}>

                        <input name="username" type="name" className="form-control" placeholder="Login" required="" autofocus="" />
                        <input name="password" type="password" className="form-control" placeholder="Password" required="" />

                        <input id="remember-me" name="remember-me" type="checkbox"/>
                        <label htmlFor="remember-me" className="inline">Remember me</label>

                        <button className="btn btn-lg btn-primary btn-block" type="submit">Вход</button><br />
                        <a href="/registration" style={{'textDecoration': 'none'}}>
                            <button className="btn btn-lg btn-success btn-block" type="button" >Регистрация</button>
                        </a>
                    </form>
                </div>
            </div> <!-- /container -->
        );
    }
});

module.exports = Login;
//name='f' action='/login' method='POST'