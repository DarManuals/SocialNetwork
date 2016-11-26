import React from 'react';
import {Grid,Row,Col} from 'react-bootstrap';
import UserDetails from './UserDetails';
import PostsPanel from './PostsPanel';

class Profile extends React.Component {

  render() {
    return (
        <Grid>
            <Row>
                <Col xs={8} md={8} xsOffset={2} mdOffset={2}>
                    <h1>{this.props.user.login}</h1>
                    <hr />
                </Col>
            </Row>
            <UserDetails user={this.props.user} />
            <PostsPanel posts={this.props.user.posts} />
        </Grid>
    );
  }
}

export default Profile;