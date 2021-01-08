import axios from 'axios';

const ADMINS_LIST = "http://localhost:8080/api/v1/admins"

class AdminService{

    getAdmins(){
        return axios.get(ADMINS_LIST);
    }
    
}

export default new AdminService()