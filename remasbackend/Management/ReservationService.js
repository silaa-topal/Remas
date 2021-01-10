import axios from 'axios';

const RESERVATION_API_BASE_URL = "http://localhost:8080/api/v1/reservation";

class ReservationService {

    getReservation(){
        return axios.get(RESERVATION_API_BASE_URL);
    }

    createReservation(reservation){
        return axios.post(RESERVATION_API_BASE_URL, reservation);
    }

    getReservationById(reservationId){
        return axios.get(RESERVATION_API_BASE_URL + '/' + reservationId);
    }

    updateReservation(reservation, reservationId){
        return axios.put(RESERVATION_API_BASE_URL + '/' + reservationId, reservation);
    }

    deleteReservation(reservationId){
        return axios.delete(RESERVATION_API_BASE_URL + '/' + reservationId);
    }
}

export default new RESERVATIONService()