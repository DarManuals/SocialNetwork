import React, { Component } from 'react';
import './App.css';
import Navigation from './components/Navigation';
import Profile from './components/Profile';
import Footer from './components/Footer';

class App extends Component {

    constructor(){
        super();
        this.state = {
             users: [
                  {
                        id: 0,
                        login: "User",
                        city: "Dnipro",
                        job: "Java developer",
                        dob: "1992-10-08",
                        about: "Лентяй - кофеман!",
                        posts: [{id: 0, text: "text1", date: "2016-10-08 12:33:47", userName: "User"},
                                {id: 1, text: "text2", date: "2016-10-08 12:33:48", userName: "User2"}]
                  }
             ]
        };

        this.update = this.update.bind(this);
    }

    componentDidMount() {
        this.update();
    }

    update(){

    }

  render() {
    return (
      <div className="App">
        <Navigation />
        <Profile user={this.state.users[0]} />
        <Footer />
      </div>
    );
  }
}

export default App;