import React, { Component } from 'react';
import NavigationHeader from '../navigation/NavigationHeader';
import '../App.css';
import "../profile/Profile.css";
import "./Cashier.css";
import { PlayerIdentifier } from "./PlayerIdentifier";
import { CreditBalance } from "../profile/CreditBalance";
import { NewItemEntry } from "./NewItemEntry";

var getProfileUrl = "https://homelesshelper.herokuapp.com/getCashierReceiverInfo"

export class Cashier extends Component {

	constructor(props) {
		super(props);
		this.state = {
			name: (this.props.userId === undefined) ? "Select a user" : "Loading...",
			balance: (this.props.userId === undefined) ? "-.--" : -1.0
		};
		this.setState = this.setState.bind(this);

		//get user info.
		if (this.props.userId !== undefined) {
			fetch(getProfileUrl.concat("/", this.props.userId))
				.then(function (response) {
					return response.json();
				})
				.then((response) => {
					this.setState({
						name: response["name"],
						balance: response["balance"],
					})
				});
		}
	}
	
	render() {
		return (
			<div>
				<NavigationHeader />
				<div class="app-body">
					<PlayerIdentifier name={this.state.name} />
					<div class="right-wrapper">
						<CreditBalance balance={this.state.balance} />
						<NewItemEntry userId={this.props.userId} />
					</div>
                </div>	
			</div>
		)
	}
}

export default Cashier;