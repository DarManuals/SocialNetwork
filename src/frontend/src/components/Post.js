import React from 'react';
import {Panel} from 'react-bootstrap';

class Post extends React.Component {

  render() {
    return (
            <Panel>
                    <div>Test</div>
                   <hr />
                   <div>
                         <i class="text-muted">Автор: <span class="muted_link">admin</span>,
                              Опубликовано: <span class="date_time">2016-10-08 12:33:47.0</span>
                              <a class="muted_link" href="/posts/del/41"> Удалить</a>
                         </i>
                   </div>
            </Panel>
    );
  }
}

export default Post;
