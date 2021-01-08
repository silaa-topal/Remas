import React, { Component } from 'react';
import {default as AdminService} from '../services/AdminService';

class ListAdminsComponent extends Component {
    constructor(props){
        super(props)
        this.state = {
                admins: []
        }
    }

    componentDidMount(){
        AdminService.getAdmins().then((res)=>{
            this.setState({admins: res.data});
        });
    }

    render() {
        return (
            <div>
                <h2 className="text-center"> admins </h2>
                <div className="row">
                    <table className = "table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>name</th>
                                <th>restaurant</th>
                                <th>email</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.admins.map(
                                    admins => 
                                    <tr key = {admins.id}>
                                        <td>{admins.first_name}</td>
                                        <td>{admins.restaurant_name}</td>
                                        <td>{admins.email}</td>
                                    </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}

export default ListAdminsComponent;