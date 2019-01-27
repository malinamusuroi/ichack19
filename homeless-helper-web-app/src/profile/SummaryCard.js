import React, { Component } from 'react';
import "./Profile.css";

export class SummaryCard extends Component {
	render() {
		return (
			<div class="summary-card-wrapper">
				<img src="https://upload.wikimedia.org/wikipedia/commons/8/89/Portrait_Placeholder.png" />
				<div class="information">
					{personsName(this.props.name)}
					{dateOfBirth(this.props.dob)}
					{summaryTitle}
					{summary(this.props.summary)}
				</div>
			</div>
		)
	}
}

function personsName(name) {
	return (
		<p class="persons-name">
			{name}
		</p>
	)
}

function dateOfBirth(DOB) {
	return (
		<p class="date-of-birth">
			{"DOB: " + DOB}
		</p>
	)
}

function gender(gender) {
	return (
		<p class="date-of-birth">
			{(gender == "F") ? "♀" : "♂ " }
		</p>
	)
}

var summaryTitle = <p class="summary-title">
    Summary:
</p>

function summary(summary) {
	return (
		<p class="summary">
			{summary}
	    </p>
	)
}

export default SummaryCard;