import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import NavigationHeader from './navigation/NavigationHeader';
import { BrowserRouter as Router, Route, Link, Switch, Redirect } from "react-router-dom";
import { Profile } from "./profile/Profile";
import { Home } from "./home/Home";
import { Cashier } from "./cashier/Cashier";
import { Register } from "./register/Register";
import { Error } from "./error/Error";

class App extends Component {
  render() {
	  return (
		<Router>
			<div>
			    <Switch>
					<Route exact path="/" component={Home} />
					<Route path="/profile/:id" render={(props) => (<Profile userId={props.match.params.id} />)} />
					<Route exact path="/cashier" component={Cashier} />
					<Route path="/cashier/:id" render={(props) => (<Cashier userId={props.match.params.id} />)} />
					<Route path="/register" component={Register} />
					<Route path="/pageNotFound" component={Error} />
					<Redirect from="*" to="/pageNotFound" />
               </Switch>
			</div>
        </Router>
    );
  }
}

export default App;
