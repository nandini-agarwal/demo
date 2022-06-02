import React from "react";
import {Navbar, Nav, Container} from 'react-bootstrap';

class NavigationBar extends React.Component{
	render () {
		return (
			<Navbar bg="dark" variant="dark">
				<Container>
					<Navbar.Brand href="/">Training 2022</Navbar.Brand>
					<Nav className="me-auto">
						<Nav.Link href="/">Home</Nav.Link>
						<Nav.Link href="/add">Add Person</Nav.Link>
						<Nav.Link href="/list">PersonList</Nav.Link>
					</Nav>
				</Container>
			</Navbar>
		);
	}
}

export default NavigationBar;