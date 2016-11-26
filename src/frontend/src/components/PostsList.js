import React from 'react';
import Post from './Post';

class PostsList extends React.Component {

  render() {
    return (
            <div>

                {
                    this.props.posts.map( (p,i) =>
                        <Post key={i} data={p} />
                    )
                }
            </div>
    );
  }
}

export default PostsList;
