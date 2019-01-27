import React, { Component } from 'react';

export class NewItemEntry extends Component {
	render() {
		return (
			<div class="new-item-entry-wrapper">
				<div class="new-item-entry-title">
					Enter new item
				</div>
				<form class="new-item-entry-form" action="/TODO" method="post">
					<div class="form-item">
						<span class="form-title">Name:</span>	<input type="text" name="name" />
					</div>
					<br />
					<div class="form-item">
						<span class="form-title">Credits:</span>	<input type="number" name="credits" />
					</div>
					<br />
					<div class="form-item">
						<input type="submit" value="Submit" />
					</div>
				</form>
			</div>
		)
	}
}

export default NewItemEntry;