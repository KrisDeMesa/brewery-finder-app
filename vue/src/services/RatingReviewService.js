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
  },
<<<<<<< HEAD
  getRatingsByUser(userId) {
      return http.get(`/beers/ratings/${userId}`);
=======
  addBeerReview(newBeerReview) {
      return http.post(`/beers/reviews`, newBeerReview)
  },
  addBeerRatings(newBeerRatings) {
      return http.post(`/beers/ratings`, newBeerRatings)
>>>>>>> 117bd1e864dc306489ecfe8b18ab680287f1c1c2
  }

}
