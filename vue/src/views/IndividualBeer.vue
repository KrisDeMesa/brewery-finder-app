<template>
  <div id="whole-page">
      <ind-beer-header :beer="beer"/>
      
      <div id="main-space" v-show="createdComplete">
          <div id="left-grid">
              <ul>
                  <li>{{beer.type}}</li>
                  <li>{{beer.abv}}</li>
                  <li>{{beer.description}}</li>
                  <li>Average Rating: {{beerAvgRating}}</li>
                </ul>
                
                <select v-model="rating">
                    <option value=""></option>
                    <option value=1>1</option>
                    <option value=2>2</option>
                    <option value=3>3</option>
                    <option value=4>4</option>
                    <option value=5>5</option>
                </select>
                <button type="button" @click="submitRating()">Submit Rating</button>
          </div>
          <div id="right-grid">
              <div v-for="review in reviews" :key="review.userId">
                  {{review.description}}
              </div>
              <textarea rows="5" cols="50" v-model="review">Submit your review here!</textarea>
              <button type="button" @click="submitReview()">Submit Review</button>
          </div>
      </div>
  </div>
</template>

<script>
import IndBeerHeader from '../components/IndBeerHeader.vue'
import breweryService from '../services/BreweryService.js'
import ratingReviewService from '../services/RatingReviewService.js'

export default {
    components: {
        IndBeerHeader
    }, 
    created() {
        breweryService.getBeer(this.$route.params.id)
            .then( response => {
                this.beer = response.data;
            });
        ratingReviewService.getBeerAvgRating(this.$route.params.id)
            .then( response => {
                this.beerAvgRating = response.data;
                this.createdComplete = true;
            });
        ratingReviewService.getBeerReviews(this.$route.params.id)
            .then( response => {
                this.reviews = response.data;
            })
    },
    data () {
        return {
            beer: {},
            beerAvgRating: 0,
            createdComplete: false,
            rating: '',
            reviews: [], 
            review: ''
        }
    }, 
    methods: {
        submitRating() {
            
        },
        submitReview() {
            
        }
    }
}
</script>

<style scoped>
#whole-page{
    
}
#main-space{
    display: grid;
    grid-template-columns: 1fr 1fr;
    grid-template-areas: 
    "left right";
    border: 1px solid black;
    
}
#left-grid{
    grid-area: left;
}
#right-grid{
    grid-area: right;
}
</style>