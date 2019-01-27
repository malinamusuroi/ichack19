import React, { Component } from 'react';
import NavigationHeader from '../navigation/NavigationHeader';
import "../profile/Profile.css";
import "./Register.css"

export class Register extends Component {
	render() {
		return (
			<div>
				<NavigationHeader />
				<div class="app-body">
					<form caction="/TODO" method="post">
						<div class="add-photo">
							<span style={{ paddingTop: "90px", display: "inline-block"}}>(+) Add photo</span>
						</div>

						<div class="right-wrapper registration-form">
							<div class="registration-form-title">
							    Register user
							</div>
                            <div class="form-wrapper">
								<div class="form-item">
									<span class="form-title">Forename:</span> <input type="text" name="forename" />
								</div>
								<br />
								<div class="form-item">
									<span class="form-title">Surname:</span> <input type="text" name="surname" />
								</div>
								<br />
								<div class="form-item">
									<span class="form-title">Date of Birth:</span> <input type="calendar" name="date_of_birth" />
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