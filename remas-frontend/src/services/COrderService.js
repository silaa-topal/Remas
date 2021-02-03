import axios from 'axios';

const Order_LIST = "http://localhost:8080/api/v1/chef/orders"

class COrderService{

    getOrders(){
        return axios.get(Order_LIST);
    }
    updateCOrders(id){
        return axios.patch(Order_LIST,id);
    }

    
}

export default new COrderService()