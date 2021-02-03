import React, { Component } from 'react';

import welcomepage from "../pages/welcomepage"
import adminpage from "../pages/adminpage";
import chefpage from "../pages/chefpage";
import waiterpage from "../pages/waiterpage";

import Login from "../pages/Login";


import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import {Link} from "react-router-dom"

import { Security, SecureRoute } from "@okta/okta-react";

import { LoginCallback } from "@okta/okta-react";

import { OktaAuth } from '@okta/okta-auth-js';




//import Navbar from "./components/navbar";

//function onAuthRequired({history}){
  //history.push('/login');
//}

const oktaAuth = new OktaAuth({
  issuer: "https://dev-11608087.okta.com/oauth2/defualt",
  client_id: "0oa4r5xq2wGxTcZgd5d6",
  redirectUri: window.location.origin + '/login/callback',
});

class Navbar extends Component {
  render() {
    return (

    <Router>

      <Security oktaAuth={oktaAuth}>

      <nav className="navbar navbar-expand-sm navbar-dark bg-dark mb-4">
        <div className="container">
            <Link to="/"> REMAS </Link>
            <Route render={({history}) => (
            <button onClick={
              () => { history.push('/admin') }
            }> admin </button> )}/>
            <Route render={({history}) => (
            <button onClick={
              () => { history.push('/waiter') }
            }> waiter </button> )}/>
            <Route render={({history}) => (
            <button onClick={
              () => { history.push('/chef') }
            }> chef </button> )}/>
        </div>
      </nav>

      <Switch>
        <div className="container">
          <Route path="/" exact={true} component={welcomepage}/>
          <SecureRoute path="/admin" exact={true} component={adminpage}/>
          <Route path="/waiter" exact={true} component={waiterpage}/>
          <Route path="/chef" exact={true} component={chefpage}/>

          
          <Route path="/login" render={()=> <Login baseUrl="https://dev-11608087.okta.com"/>}/>
          <Route path="/login/callback" component={LoginCallback}/>
        </div>
      </Switch>

      </Security>
      
    </Router>

    );
  }
}

export default Navbar;