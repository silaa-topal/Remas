import React, { Component } from 'react';
import ReservationComponent from "../components/reservationcomponent";
import OrderComponent from "../components/ordercomponent";
import ViewOrderComponent from "../components/ViewOrderComponent";
import ViewReservationComponent from "../components/ViewReservationComponent";

import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import { Link } from "react-router-dom"

import reservationcomponent from '../components/reservationcomponent';
import ordercomponent from '../components/ordercomponent';



class waiterpage extends Component {
  render() {
    return (
      <div>

        <h3>this is the waiter page</h3>

        <Router>

          

            <nav className="navbar navbar-expand-sm navbar-dark bg-dark mb-4">
              <div className="container">
                <Link to="/"> Waiter Page </Link>
                <Route render={({ history }) => (
                  <button class="button" onClick={
                    () => { history.push('/addreservation') }
                  }> Add Reservation </button>)} />
                <Route render={({ history }) => (
                  <button class="button" onClick={
                    () => { history.push('/viewreservation') }
                  }> View Reservation </button>)} />                  
                <Route render={({ history }) => (
                  <button class="button" onClick={
                    () => { history.push('/addorder') }
                  }> Add Order </button>)} />                
                <Route render={({ history }) => (
                  <button class="button" onClick={
                    () => { history.push('/vieworder') }
                  }> View Order </button>)} />
               <Route render={({ history }) => (
                  <button class="button" onClick={
                    () => { history.push('/changestatus') }
                  }> Status Order </button>)} />
                <Route render={({ history }) => (
                  <button class="button" onClick={
                    () => { history.push('/cancelorder') }
                  }> Cancel Order </button>)} />
                <Route render={({ history }) => (
                  <button class="button" onClick={
                    () => { history.push('/changeorder') }
                  }> Change Order </button>)} />
                <Route render={({ history }) => (
                  <button class="button" onClick={
                    () => { history.push('/updatetablestatus') }
                  }> Update TableStat </button>)} />   
                <Route render={({ history }) => (
                  <button class="button" onClick={
                    () => { history.push('/createreceipts') }
                  }> Create Receipts </button>)} />                                                  

              </div>
            </nav>

            <Switch>
              <div className="container">
                <Route path="/" exact={true} component={waiterpage} />
                <Route path="/addreservation" exact={true} component={reservationcomponent} />
                <Route path="/viewreservation" exact={true} component={ViewReservationComponent} />
                <Route path="/vieworder" exact={true} component={ViewOrderComponent} />
                <Route path="/addorder" exact={true} component={ordercomponent} />


              
              </div>
            </Switch>

         

        </Router>



      </div>

    );
  }
}

export default waiterpage;