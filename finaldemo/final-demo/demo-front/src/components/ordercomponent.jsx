import React, { Component } from 'react';
import OrderService from "./OrderService"




class ordercomponent extends Component {
    constructor(props) {
        super(props)

        this.state = {

            id: 'this.props.match.params.id',
            orderKey: '' ,
            tableNo: '',
            piece: '',

        }
        
        this.changeorderKeyHandler = this.changeorderKeyHandler.bind(this);
        this.changetableNoHandler = this.changetableNoHandler.bind(this);
        this.changepieceHandler = this.changepieceHandler.bind(this);
        
    }
    
    componentDidMount(){
        
                if(this.state.id === '_add'){
            return
        }else{

            function OrderService(){
            OrderService.getOrdernById(this.state.id).then( (res) =>{
                let order = res.data;
                this.setState({orderKey: order.orderKey,
                    tableNo : order.piece,
                    piece : order.piece,

                });
            });
        }
        }
    }
    
        saveOrUpdateOrder = (e) => {
        e.preventDefault();
        let order = {orderKey: this.state.orderKey, tableNo: this.state.tableNo, piece: this.state.piece};
        console.log('order => ' + JSON.stringify(order));
        
        function OrderService(){
        if (this.state.id === '_add') {
            OrderService.createOrder(order).then(res => {
                this.props.history.push('/order');
            });
        } else {
            OrderService.updateOrder(order, this.state.id).then(res => {
                this.props.history.push('/order');
            });
        }
    }
}
    
    
    
    
        changeorderKeyHandler= (event) => {
        this.setState({orderKey: event.target.value});
    }
        changetableNoHandler= (event) => {
        this.setState({tableNo: event.target.value});
    }
        changepieceHandler= (event) => {
        this.setState({piece: event.target.value});
    }

    
    cancel(){
        this.props.history.push('/order');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Order</h3>
        }else{
            return <h3 className="text-center">Update Order</h3>
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
                                            <h3 className = "text-center"> Add Order </h3>
                                        </div>
                                        <div className = "form-group">
                                            <label> Order Key: </label>
                                            <input placeholder="Order Key" name="orderKey" className="form-control" 
                                                value={this.state.orderKey} onChange={this.changeorderKeyHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Table No: </label>
                                            <input placeholder="Table No" name="tableNo" className="form-control" 
                                                value={this.state.tableNo} onChange={this.changetableNoHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> How Many: </label>
                                            <input placeholder="How Many" name="piece" className="form-control" 
                                                value={this.state.piece} onChange={this.changepieceHandler}/>
                                        </div>
                                      
                                        

                                        <button className="btn btn-success" onClick={this.saveOrUpdateOrder}>Save</button>
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
export default ordercomponent;

