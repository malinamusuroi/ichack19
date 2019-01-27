import React, { Component } from 'react';
import NavigationHeader from '../navigation/NavigationHeader';

export class Error extends Component {
	render() {
		return (
			<div>
				<NavigationHeader />
				<div class="app-body">
					Error: page not found. :^(
				</div>	
			</div> 
		)
	}
}

export default Error;