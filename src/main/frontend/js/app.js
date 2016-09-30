var React = require('react');
var ReactDOM = require('react-dom');

var Quiz = React.createClass({

	render: function(){
		return (<div>
					Msg from react!!!
				</div>);
	}
});

ReactDOM.render(
	<Quiz />,
	document.getElementById('app')
);