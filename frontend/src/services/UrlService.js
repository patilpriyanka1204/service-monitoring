import axios from 'axios';

const URL_API_BASE_URL = "http://localhost:8080/services";

class UrlService {

    getServices(){
        return axios.get(URL_API_BASE_URL);
    }

    getServiceById(serviceId){
        return axios.get(URL_API_BASE_URL + '/' + serviceId);
    }


    createService(service){
        return axios.post(URL_API_BASE_URL, service);
    }

    updateService(service, serviceId){
        return axios.put(URL_API_BASE_URL + '/' + serviceId, service);
    }

    deleteService(serviceId){
        return axios.delete(URL_API_BASE_URL + '/' + serviceId);
    }

    serviceMonitor(){
        return axios.get(URL_API_BASE_URL+'/monitors');
    }
}

export default new UrlService()