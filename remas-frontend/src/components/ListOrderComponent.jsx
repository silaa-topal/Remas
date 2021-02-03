import React, { Component } from 'react';
import OrderService from '../services/OrderService';

class ListOrderComponent extends Component {
    constructor(props){
        super(props)

        this.state ={
            orders: []
        }
        this.updateCOrder = this.updateCOrder.bind(this);
    }


    updateCOrder(id){
        OrderService.updateCOrders(id);
    }

    render() {
        return (
            <div>
                
                this.state.orders.map(
                    Order =
                    <tr key={Order.id}>
                <td>{Order.order_name}</td>
                <td>{Order.status}</td>
                <td>
                    <button onClick={()=>this.updateCOrder(Order.id)}>Update for Chef</button>
                </td>

                    </tr>
                )

            </div>
        );
    }
}

export default ListOrderComponent;