import React, { Component } from 'react';
import "./Profile.css";

export class DonationsList extends Component {
	render() {
		return (
			<div class="table-wrapper">
				<p>
					Donations
				</p>
				{donationsList(this.props)}
         	</div>
		)
	}
}
	
function donationsList(props) {
	return (
		<table class="purchases">
			<col width="1*" />
			<col width="1*" />
			<col width="1*" />
			<tr>
				<th>Donator</th>
				<th>Amount donated</th>
				<th>Timestamp</th>
			</tr>

			{props.list.map((data) => {
				return (
					<tr>
						<td>{data.donator}</td>
						<td>{parseFloat(data.amount)}</td>
						<td>{data.timestamp}</td>
					</tr>
				)
			})}
		</table>
	);
}

export default DonationsList;