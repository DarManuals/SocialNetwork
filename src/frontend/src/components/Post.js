import React from 'react';
import {Panel} from 'react-bootstrap';
import Moment from 'react-moment';

class Post extends React.Component {

  render() {
    return (
            <Panel>
                    <div>{this.props.data.text}</div>

                   <hr />
                   <div>
                         <i className="text-muted">Автор: <span className="muted_link">{this.props.data.userName}</span>,
                              Опубликовано: <span className="date_time">
                                <Moment format="YYYY/MM/DD">{this.props.data.date}</Moment>
                              </span>
                              <a className="muted_link" href={"/posts/del/" + this.props.data.id}> Удалить</a>
                         </i>
                   </div>
            </Panel>
    );
  }
}

export default Post;