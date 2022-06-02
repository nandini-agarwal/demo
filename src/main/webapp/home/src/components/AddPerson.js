import React, {Component} from "react";
import {Button, Card, Col, Form, Row} from "react-bootstrap";

export default class AddPerson extends Component{
	render () {
		return(
			<Card className="border border-dark bg-dark text-white">
				<Card.Header>Add Person</Card.Header>
				<Form>
					<Card.Body>
						<Row className="mb-3">
							<Form.Group as={Col} controlId="formGridName">
								<Form.Label>Name</Form.Label>
								<Form.Control type="text" placeholder="Enter Name" />
							</Form.Group>
							<Form.Group as={Col} controlId="formGridDOB">
								<Form.Label>DOB</Form.Label>
								<Form.Control type="date" placeholder="DOB" />
							</Form.Group>
						</Row>
					</Card.Body>
					<Card.Footer>
						<Button variant="primary" type="submit">
							Submit
						</Button>
					</Card.Footer>
				</Form>
			</Card>
		)
	}
}