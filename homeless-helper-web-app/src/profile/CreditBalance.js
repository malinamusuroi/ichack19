import React, { Component } from 'react';
import './Profile.css';

export class CreditBalance extends Component {
	render() {
		return (
			<div class="credit-balance">
				<span>
					Credit Balance:
				</span>
				{creditBalance(this.props.balance)}
			</div>
		)
	}
}

function creditBalance(credits) {
	return (
		<span class="credits">
			{(credits == -1) ? "Loading..." : parseFloat(credits)}
		</span>	
	);
}

export default CreditBalance; 