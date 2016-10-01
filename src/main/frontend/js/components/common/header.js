"use strict";

var React = require('react');
var Router = require('react-router');
var Link = Router.Link;

var Header = React.createClass({
	render: function(){
		return (
				<nav className="navbar navbar-inverse navbar-fixed-top" role="navigation">
					<div className="container-fluid">
						<div className="navbar-header">
                              <button type="button" className="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                   <span className="sr-only">Aggregator</span>
                                   <span className="icon-bar"></span>
                                   <span className="icon-bar"></span>
                                   <span className="icon-bar"></span>
                              </button>
                              <Link to="app" className="navbar-brand">Aggregator</Link>
                        </div>

						<div class="navbar-collapse collapse">
                            <ul className="nav navbar-nav">

                                <li><Link to="app">Home</Link></li>
                                <li><Link to="about">About</Link></li>

                                <li><a href="/profile"> Моя страница </a></li>
                                <li><a href="/news"> Лента </a></li>
                                <li><a href="/search"> Поиск </a></li>
                                <li className="dropdown">
                                <a href="#" className="dropdown-toggle" data-toggle="dropdown"> Настройки <b class="caret"></b></a>
                                <ul className="dropdown-menu">
                                    <li><a href="/profile/edit"> Редактировать профиль</a></li>
                                    <li className="divider"></li>
                                    <li className="dropdown-header">Заголовок</li>
                                    <li><a href="#">Фича</a></li>
                                </ul>
                                </li>
                                <li><a href="/logout"> Выйти </a></li>
                            </ul>
                        </div><!--/.nav-collapse -->
					</div>
				</nav>
			);
	}
});

module.exports = Header;