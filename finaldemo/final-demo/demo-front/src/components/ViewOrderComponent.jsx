import React, { Component } from 'react'
import OrderService from './OrderService'

class ViewOrderComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: 'this.props.match.params.id',
            order: {}
        }
    }

    componentDidMount(){
        function OrderService(){
        OrderService.getOrderById(this.state.id).then( res => {
            this.setState({order: res.data});
        })
    }
}

    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Order Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Order Key: </label>
                            <div> { this.state.order.orderKey }</div>
                        </div>
                        <div className = "row">
                            <label> Table No: </label>
                            <div> { this.state.order.tableNo }</div>
                        </div>
                        <div className = "row">
                            <label> How Much: </label>
                            <div> { this.state.order.piece}</div>
                        </div>
                    </div>

                </div>
            </div>
        )
    }
}

export default ViewOrderComponent;
