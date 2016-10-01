"use strict";

var React = require('react');
var ReactDOM = require('react-dom');
var ReactRouter = require('react-router');
var Router = ReactRouter.Router;
var Route = ReactRouter.Route;
//import { hashHistory } from 'react-router'
import { browserHistory } from 'react-router'

var Home = require('./components/homePage');
var About = require('./components/about/aboutPage');
var Login = require('./components/authPages/loginPage');

ReactDOM.render(<Router history={browserHistory}>
                    <Route path="/" component={Home}/>
                    <Route path="about" component={About} />
                    <Route path="login" component={Login} />
                </Router>,
    document.getElementById('app'));