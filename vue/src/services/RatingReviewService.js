import axios from 'axios';
const http =axios.create({
    baseURL: "http://localhost:9000"
});
export default {

  getBeerAvgRating(beerId) {
      return http.get(`/beers/${beerId}/rating`);
  },
  getBeerReviews(beerId) {
      return http.get(`/beers/${beerId}/reviews`);
  }

}
