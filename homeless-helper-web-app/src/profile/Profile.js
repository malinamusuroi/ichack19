import React, { Component } from 'react';
import NavigationHeader from '../navigation/NavigationHeader';
import '../App.css';
import { SummaryCard } from "./SummaryCard";
import { CreditBalance } from "./CreditBalance";
import { PurchaseList } from "./PurchaseList";
import { DonationsList } from "./DonationsList";

var getProfileUrl = "https://homelesshelper.herokuapp.com/getFullReceiverInfoAndHistory"

export class Profile extends Component {

	constructor(props) {
		super(props);
		this.state = {
			name: "Loading...",
			dob: "Loading...",
			summary: "Loading...",
			balance: -1,
			transactions: [],
			donations: []
		};
		this.setState = this.setState.bind(this);

		// get profile info.
		fetch(getProfileUrl.concat("/", this.props.userId))
			.then(function (response) {
				return response.json();
			})
			.then((response) => {
				this.setState({
					name: response["name"],
					dob: response["dob"],
					summary: response["summary"],
					balance: response["balance"],
					transactions: response["transactions"],
					donations: response["donations"]
				})
			});
	}

	render() {
		return (
			<div>
				<NavigationHeader />
				<div class="app-body">
					<SummaryCard name={this.state.name} dob={this.state.dob} summary={this.state.summary} />
					<div class="right-wrapper">
						<CreditBalance balance={this.state.balance} />
						<PurchaseList list={this.state.transactions} />
						<DonationsList list={this.state.donations} />
					</div>
				</div>	
			</div>
		)
	}
}

export default Profile;