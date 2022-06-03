import React, {Component} from "react";
import {Button, Card, Table} from "react-bootstrap";

export default class PersonList extends Component{
	constructor(props) {
		super(props);
		this.state = {persons:[],};
		this.remove = this.remove.bind(this);
	}

	async componentDidMount() {
		const response = await fetch('/person');
		const body = await response.json();
		this.setState({persons: body});
	}

	async remove(id) {
		await fetch(`/person/${id}`, {
			method: 'DELETE',
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'
			}
		}).then(() => {
			let updatedClients = [...this.state.clients].filter(i => i.id !== id);
			this.setState({clients: updatedClients});
		});
	}

	render () {
		const {persons} = this.state;
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
							<th>Actions</th>
						</tr>
						</thead>
						<tbody>
						{		persons.map(person =>
								<tr key={person.id}>
									<td>{person.id}</td>
									<td>{person.name}</td>
									<td>{person.dob}</td>
									<td>{person.emailId}</td>
									<td>{person.number}</td>
									<td>
										<Button size="sm" onClick={()=>this.remove(person.id)}>Delete</Button>
									</td>
								</tr>)
						}
						</tbody>
					</Table>
				</Card.Body>
			</Card>
		)
	}
}