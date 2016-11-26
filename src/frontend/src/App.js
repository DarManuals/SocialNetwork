import React, { Component } from 'react';
import './App.css';
import Navigation from './components/Navigation';
import UserInfo from './components/UserInfo';
import Footer from './components/Footer';

class App extends Component {
  render() {
    return (
      <div className="App">
        <Navigation />
        <UserInfo />
        <Footer />
      </div>
    );
  }
}

export default App;