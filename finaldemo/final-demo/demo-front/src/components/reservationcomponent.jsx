import React, { Component } from 'react';
import ReservationService from "./ReservationService"




class reservationcomponent extends Component {
    constructor(props) {
        super(props)

        this.state = {

            id: 'this.props.match.params.id',
            name: '',
            tableNo: '',
            resDate: '',
            resHour: ''

        }
        
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeTableNoHandler = this.changeTableNoHandler.bind(this);
        this.changeResDateHandler = this.changeResDateHandler.bind(this);
        this.changeResHourHandler = this.changeResHourHandler.bind(this);
        
    }
    
    componentDidMount(){
        
                if(this.state.id === '_add'){
            return
        }else{

            function ReservationService(){
            ReservationService.getReservationById(this.state.id).then( (res) =>{
                let reservation = res.data;
                this.setState({name: reservation.name,
                    tableNo : reservation.tableNo,
                    resDate : reservation.resDate,
                    resHour : reservation.resHour
                });
            });
        }
        }
    }
    
        saveOrUpdateReservation = (e) => {
        e.preventDefault();
        let reservation = {name: this.state.name, tableNo: this.state.tableNo, resDate: this.state.resDate, resHour: this.state.resHour};
        console.log('reservation => ' + JSON.stringify(reservation));
        
        function ReservationService(){
        if (this.state.id === '_add') {
            ReservationService.createReservation(reservation).then(res => {
                this.props.history.push('/reservation');
            });
        } else {
            ReservationService.updateReservation(reservation, this.state.id).then(res => {
                this.props.history.push('/reservation');
            });
        }
    }
}
    
    
    
    
        changeNameHandler= (event) => {
        this.setState({name: event.target.value});
    }
        changeTableNoHandler= (event) => {
        this.setState({tableNo: event.target.value});
    }
        changeResDateHandler= (event) => {
        this.setState({resDate: event.target.value});
    }
        changeResHourHandler= (event) => {
        this.setState({resHour: event.target.value});
    }
    
    cancel(){
        this.props.history.push('/reservation');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Reservation</h3>
        }else{
            return <h3 className="text-center">Update Reservation</h3>
        }
    }



    render() {

        return (

            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    
                                }
                                <div className = "card-body">
                                    <form>
                                    <div className = "form-group">
                                            <h3 className = "text-center"> Add Reservation </h3>
                                        </div>
                                        <div className = "form-group">
                                            <label> Customer Name: </label>
                                            <input placeholder="Customer Name" name="name" className="form-control" 
                                                value={this.state.name} onChange={this.changeNameHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Table No: </label>
                                            <input placeholder="Table No" name="tableNo" className="form-control" 
                                                value={this.state.tableNo} onChange={this.changeTableNoHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Reservation Date: </label>
                                            <input placeholder="Reservation Date" name="resDate" className="form-control" 
                                                value={this.state.resDate} onChange={this.changeResDateHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Reservation Hour: </label>
                                            <input placeholder="Reservation Hour" name="resHour" className="form-control" 
                                                value={this.state.resHour} onChange={this.changeResHourHandler}/>
                                        </div>                                        
                                        

                                        <button className="btn btn-success" onClick={this.saveOrUpdateReservation}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
            
        )

    }
    

}
export default reservationcomponent;

