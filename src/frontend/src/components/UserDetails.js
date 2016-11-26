import React from 'react';
import {Row,Image,Table,Col} from 'react-bootstrap';
import Moment from 'react-moment';

class UserDetails extends React.Component {

  render() {
    return (
            <Row>
                          <Col xs={3} md={3} xsOffset={2} mdOffset={2}>
                            <Image src="https://react-bootstrap.github.io/assets/thumbnail.png" rounded />
                          </Col>
                          <Col xs={4} md={4}>
                                <h3>Information</h3>
                                <Table striped bordered condensed hover>
                                    <tbody>
                                         <tr>
                                              <td><b>Город: </b></td><td>{this.props.user.city}</td>
                                         </tr>
                                         <tr>
                                             <td><b>Дата рождения: </b></td><td type="date">
                                                <Moment format="DD-MM-YYYY">{this.props.user.dob}</Moment>
                                             </td>
                                         </tr>
                                         <tr>
                                              <td><b>Работа: </b></td><td>{this.props.user.job}</td>
                                         </tr>
                                         <tr>
                                              <td><b>О себе: </b></td><td>{this.props.user.about}</td>
                                         </tr>
                                    </tbody>
                                  </Table>
                          </Col>
                        </Row>
    );
  }
}

export default UserDetails;