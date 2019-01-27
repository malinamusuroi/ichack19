import React, { Component } from 'react';
import "./Profile.css";

export class PurchaseList extends Component {
	render() {
		return (
			<div class="table-wrapper">
				<p>
					Purchases
				</p>
				{purchaseList(this.props, "gfgh ")}
			</div>
		)
	}
}

function purchaseList(props, purchases) {
	return (
		<table class="purchases">
			<col width="1*" />
			<col width="1*" />
			<col width="1*" />
			<tr>
				<th>Purchase Description</th>
				<th>Credits</th>
				<th>Timestamp</th>
			</tr>

			{props.list.map((data) => {
				return (
					<tr>
						<td>{data.description}</td>
						<td>{parseFloat(data.amount)}</td>
						<td>{data.timestamp}</td>
					</tr>
				)
			})}
		</table>
	);
}

export default PurchaseList;