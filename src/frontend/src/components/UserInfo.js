import React from 'react';
import {Grid,Row,Col,Image,Table,Button,Panel,FormControl,FormGroup,ControlLabel} from 'react-bootstrap';
import PostsList from './PostsList';

class UserInfo extends React.Component {

  render() {
    return (
        <Grid>
            <Row>
                <Col xs={8} md={8} xsOffset={2} mdOffset={2}>
                    <h1>User</h1>
                    <hr />
                </Col>
            </Row>
            <Row>
              <Col xs={4} md={4} xsOffset={2} mdOffset={2}>
                <Image src="https://react-bootstrap.github.io/assets/thumbnail.png" rounded />
              </Col>
              <Col xs={4} md={4}>
                    <Table striped bordered condensed hover>
                        <tbody>
                             <tr>
                                   <td><b>Город: </b></td><td>Днепр</td>
                             </tr>
                             <tr>
                                 <td><b>Дата рождения: </b></td><td type="date">17-05-1992</td>
                             </tr>
                             <tr>
                                  <td><b>Работа: </b></td><td>Java developer</td>
                             </tr>
                             <tr>
                                  <td><b>О себе: </b></td><td>Лентяй - кофеман!</td>
                             </tr>
                        </tbody>
                      </Table>
              </Col>
            </Row>
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
                    <PostsList />
                </Col>
            </Row>
          </Grid>
    );
  }
}

export default UserInfo;
