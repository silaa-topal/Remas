import axios from 'axios';

const Order_LIST = "http://localhost:8080/api/v1/admins"

class OrderService{

    getOrders(){
        return axios.get(Order_LIST);
    }
    updateCOrders(id){
        return axios.get(Order_LIST);
    }

    
}

export default new OrderService()