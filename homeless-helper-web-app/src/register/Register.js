import React, { Component } from 'react';
import NavigationHeader from '../navigation/NavigationHeader';
import "../profile/Profile.css";
import "./Register.css"

var registerUserUrl = "https://homelesshelper.herokuapp.com/registerReceiver"

export class Register extends Component {

	constructor(props) {
		super(props);
		this.state = {
			name: "",
			dob: 0,
			summary: ""
		};

		this.handleFormChange = this.handleFormChange.bind(this);
		this.handleFormSubmit = this.handleFormSubmit.bind(this);
	}

	handleFormChange(event) {
		var formName = document.getElementById("name").value;
		var formDob = document.getElementById("dob").value;
		var formSummary = document.getElementById("summary").value;

		this.setState({
			name: formName,
			dob:  (new Date(formDob)).getTime(),
			summary: formSummary,
		});
	}

	handleFormSubmit(event) {
		var formBody = JSON.stringify(this.state);

		fetch(registerUserUrl, {
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
			<div>
				<NavigationHeader />
				<div class="app-body">
					<form onChange={this.handleFormChange} onSubmit={this.handleFormSubmit}>
						<div class="add-photo">
							<span style={{ paddingTop: "90px", display: "inline-block"}}>(+) Add photo</span>
						</div>

						<div class="right-wrapper registration-form">
							<div class="registration-form-title">
							    Register user
							</div>
                            <div class="form-wrapper">
								<div class="form-item">
									<span class="form-title">Name:</span> <input type="text" id="name" />
								</div>
								<br />
								<div class="form-item">
									<span class="form-title">Date of birth:</span> <input type="date" id="dob" />
								</div>
								<br />
								<div class="form-item">
									<span class="form-title">Summary:</span> <input type="text" id="summary" />
								</div>
								<br />
								<div class="form-item">
								<span class="form-title"><input type="submit" value="Submit" /></span>
								</div>
							</div>
						</div>
					</form>
				</div>	
			</div>
		)
	}
}

export default Register;