import axios from 'axios';
const http =axios.create({
    baseURL: "http://localhost:9000"
});
export default {

  getBreweries() {
    return http.get('/breweries/open?city=philadelphia')
  },

  getBreweryById(breweryId) {
    return http.get(`/breweries/${breweryId}`)
  },

  updateBrewery(brewery) {
    return http.put(`/breweries/${brewery.id}`, brewery);
  },

  getBeers(breweryId) {
    return http.get(`/breweries/${breweryId}/beers`);
  }



}
