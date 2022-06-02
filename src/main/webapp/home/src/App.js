import './App.css';
import {Container, Row} from "react-bootstrap";
import NavigationBar from "./components/NavigationBar";
import Welcome from "./components/Welcome";
import Footer from "./components/Footer";
import AddPerson from "./components/AddPerson";
import PersonList from "./components/PersonList";

function App() {
	return (
		<div className="App">
			<NavigationBar/>
			<Container>
				<Row>
					<Welcome/>
					<AddPerson/>
					<PersonList/>
				</Row>
			</Container>
			<Footer/>
		</div>
	);
}

export default App;
