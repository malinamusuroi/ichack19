import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import './NavigationHeader.css';

export class NavigationHeader extends Component {

  render() {
	return (
		<div class="header">
			<h3 style={{ margin: "0", fontWeight: "normal", display: "inline", fontStyle: "italic" }}>
			  Homeless Helper
			</h3>

			<div class="nav-links-wrapper">
				{navigationLink("Home", "/")}
				{navigationLink("Register", "/register")}
				{navigationLink("Cashier", "/cashier")}
			</div>
      </div>
	);
  }

}

function navigationLink(title, path) {
	return (
		<Link to={path} style={{}}>
			<h3 class="nav-link" style={{ margin: "0", fontWeight: "normal" }}>
				{title}
			</h3>
		</Link>
	);
}

export default NavigationHeader;