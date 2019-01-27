import React, { Component } from 'react';
import NavigationHeader from '../navigation/NavigationHeader';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import "../profile/Profile.css";
import "./Home.css";

export class Home extends Component {
	render() {
		return (
			<div>
				<NavigationHeader />
				<div class="app-body">
					<div class="home-segment home-segment-border">
						<p class="segment-title">Register new users</p>
						<i class="far fa-address-card home-icon"></i>
						<p>Register new users to immediately start using the credit system.</p>
						{navButton("Go to register", "/register")}
						
					</div>
					<div class="home-segment home-segment-border">
						<p class="segment-title">Search existing users</p>
						<i class="fas fa-search home-icon"></i>
						<p>Search existing users on the system by ID.</p>
						{navButton("Search...", "/register")}
					</div>
					<div class="home-segment">
						<p class="segment-title">Cashier</p>
						<i class="fas fa-cash-register home-icon"></i>
						<p>Run cashier functionality with a selected user.</p>
						{navButton("Go to cashier", "/cashier")}
					</div>
				</div>	
			</div>
		)
	}
}

function navButton(text, path) {
	return (
	<Link to={path}>
		<div class="nav-button">
			{text}
		</div>
	</Link>
	);
}

export default Home;