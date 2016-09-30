"use strict";

var React = require('react');
var ReactDOM = require('react-dom');
var ReactRouter = require('react-router');
var Router = ReactRouter.Router;
var Route = ReactRouter.Route;
import { hashHistory } from 'react-router'

var Home = require('./components/homePage');
var About = require('./components/about/aboutPage');

ReactDOM.render(<Router history={hashHistory}>
                    <Route path="/" component={Home}/>
                    <Route path="about" component={About} />
                </Router>,
    document.getElementById('app'));