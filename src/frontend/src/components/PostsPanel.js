import React from 'react';
import {Panel,FormGroup,ControlLabel,FormControl,Row,Col,Button} from 'react-bootstrap';
import PostsList from './PostsList';

class PostsPanel extends React.Component {

  render() {
    return (
            <Row>
                 <Col xs={8} md={8} xsOffset={2} mdOffset={2}>
                 <br />

                 <Panel collapsible header="Write">
                       <form>
                            <FormGroup controlId="formControlsTextarea">
                                   <ControlLabel>Textarea</ControlLabel>
                                   <FormControl componentClass="textarea" placeholder="textarea" />
                            </FormGroup>
                       </form>
                       <Button type="submit">Submit</Button>
                 </Panel>

                 <PostsList  posts={this.props.posts} />
                 </Col>
            </Row>
    );
  }
}

export default PostsPanel;