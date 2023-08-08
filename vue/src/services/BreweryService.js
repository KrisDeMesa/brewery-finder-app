import axios from 'axios';
const http =axios.create({
    baseURL: "http://localhost:9000"
});
export default {

  getBreweries() {
    return http.get('/breweries/')
  },

  getBreweryById(breweryId) {
    return http.get(`/breweries/${breweryId}`)
  }

}
