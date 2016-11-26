import React from 'react';
import Navigation from './Navigation';
import Footer from './Footer';

class Content extends React.Component {

  render() {
    return (
            <div>
            <Navigation />
                   About page
            <Footer />
            </div>
    );
  }
}

export default Content;
