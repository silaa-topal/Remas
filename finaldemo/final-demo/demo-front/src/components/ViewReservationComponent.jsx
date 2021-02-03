import React, { Component } from 'react'
import ReservationService from "./ReservationService"


class ViewReservationComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                reservations: []
        }
        this.addReservation = this.addReservation.bind(this);
        this.editReservation = this.editReservation.bind(this);
        this.deleteReservation = this.deleteReservation.bind(this);
    }

    deleteReservation(id){
        ReservationService.deleteReservation(id).then( res => {
            this.setState({reservations: this.state.reservation.filter(reservation => reservation.id !== id)});
        });
    }
    viewReservation(id){
        this.props.history.push(`/view-reservation/${id}`);
    }
    editReservation(id){
        this.props.history.push(`/add-reservation/${id}`);
    }

    componentDidMount(){
        function ReservationService(){
        ReservationService.getReservation().then((res) => {
            this.setState({ reservations: res.data});
        });
    }
}

    addReservation(){
        this.props.history.push('/addreservation');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Reservation List</h2>
                 <div className = "row">
                    <button className="btn btn-primary" onClick={this.addReservation}> Add Reservation</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Reservation Name</th>
                                    <th> Reservation Table No</th>
                                    <th> Reservation Date</th>
                                    <th> Reservation Hour</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.reservations.map(
                                        reservation => 
                                        <tr key = {reservation.id}>
                                             <td> {reservation.name} </td>   
                                             <td> {reservation.tableNo}</td>
                                             <td> {reservation.Date}</td>
                                             <td>
                                                 <button onClick={ () => this.editReservation(reservation.id)} className="btn btn-info">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteReservation(reservation.id)} className="btn btn-danger">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewReservation(reservation.id)} className="btn btn-info">View </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ViewReservationComponent;
