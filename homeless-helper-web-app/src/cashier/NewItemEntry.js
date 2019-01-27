import React, { Component } from 'react';

var submitOrderUrl = "https://homelesshelper.herokuapp.com/makeTransaction"

export class NewItemEntry extends Component {

	constructor(props) {
		super(props);
		this.state = {
			description: "",
			amount: 0.0,
			vendor_id: 3,
			receiver_id: -1
		};

		this.handleFormChange = this.handleFormChange.bind(this);
		this.handleFormSubmit = this.handleFormSubmit.bind(this);
	}

	handleFormChange(event) {
		var formDescription = document.getElementById("description").value;
		var formAmount = document.getElementById("amount").value;

		this.setState({
			description: formDescription,
			amount: parseFloat(formAmount),
			vendor_id: 3,
			receiver_id: parseInt(this.props.userId)
		});
	}

	handleFormSubmit(event) {
		var formBody = JSON.stringify(this.state);

		fetch(submitOrderUrl, {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
			},
			body: formBody
		})
			.then(function (response) {
			console.log(response);
			return response.json();
		})
	}


	render() {
		return (
			<div class="new-item-entry-wrapper">
				<div class="new-item-entry-title">
					Enter new item
				</div>
				<form class="new-item-entry-form" onSubmit={this.handleFormSubmit} onChange={this.handleFormChange}>
					<div class="form-item">
						<span class="form-title">Name:</span>	<input id="description" type="text" name="name" />
					</div>
					<br />
					<div class="form-item">
						<span class="form-title">Credits:</span>	<input id="amount" type="number" name="credits" />
					</div>
					<br />
					<div class="form-item">
						<input type="submit" value="Submit" />
					</div>
				</form>
			</div>
		)
	}	
}

export default NewItemEntry;