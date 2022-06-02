import React, {Component} from "react";
import {Card, Table} from "react-bootstrap";

export default class PersonList extends Component{
	render () {
		return(
			<Card className="border border-dark bg-dark text-white">
				<Card.Header>Person List</Card.Header>
				<Card.Body>
					<Table striped bordered hover variant="dark">
						<thead>
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>D.O.B</th>
							<th>Email</th>
							<th>Number</th>
						</tr>
						</thead>
						<tbody>
						<tr>
							<td colSpan="5">No people available</td>
						</tr>
						</tbody>
					</Table>
				</Card.Body>
			</Card>
		)
	}
}