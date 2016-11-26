import React from 'react';
import Post from './Post';

class PostsList extends React.Component {

  render() {
    return (
            <div>
                <Post />
                <Post />
            </div>
    );
  }
}

export default PostsList;
