import React, { Component } from 'react';
import NavigationHeader from '../navigation/NavigationHeader';
import '../App.css';
import "../profile/Profile.css";
import "./Cashier.css";
import { PlayerIdentifier } from "./PlayerIdentifier";
import { CreditBalance } from "../profile/CreditBalance";
import { NewItemEntry } from "./NewItemEntry";

export class Cashier extends Component {
	render() {
		return (
			<div>
				<NavigationHeader />
				<div class="app-body">
					<PlayerIdentifier />
					<div class="right-wrapper">
						<CreditBalance />
						<NewItemEntry />
					</div>
                </div>	
			</div>
		)
	}
}

export default Cashier;