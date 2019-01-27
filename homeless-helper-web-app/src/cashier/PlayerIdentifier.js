import React, { Component } from 'react';
import "../profile/Profile.css";
import "./Cashier.css";

export class PlayerIdentifier extends Component {
	render() {
		return (
			<div class="summary-card-wrapper">
				<img src="https://upload.wikimedia.org/wikipedia/commons/8/89/Portrait_Placeholder.png" />
				{personsName("Nuha Tumia")}
			</div>
		)
	}
}

function personsName(name) {
	return (
		<div class="persons-name-only">
			<p>
				{name}
			</p>
		</div>
	);
}

export default PlayerIdentifier;