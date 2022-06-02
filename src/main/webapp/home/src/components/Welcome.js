import React from "react";


class Welcome extends React.Component{
	jumbotronCss = {
		padding: 2,
		marginTop: 20,
		marginBottom: 2,
		backgroundColor: '#e9ecef',
		borderRadius: .3,
	};

	render () {
		return(
			<div className="bg-dark text-white" style={this.jumbotronCss}>
				<h1>Hello World</h1>
			</div>
		)
	}
}

export default Welcome;