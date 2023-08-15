<template>
  <div>
      <beer-lover-header id="beer-lover-header" />
      <div id="main">
          <div id="ratings">
                <p>My Ratings</p>
                <div v-for="element in ratingsAndBeers" :key="element.beerId">
                    <span>{{element.rating}}</span>
                    <span>{{element.name}}</span>
                    <span>{{element.abv}}</span>
                    <span>{{element.type}}</span>
                </div>
                    
          </div>
          <div id="reviews">
              <p>My Reviews</p>
              <div v-for="element in reviewsAndBeers" :key="element.beerId">
                    
                    <span>{{element.name}}</span>
                    <span>{{element.abv}}</span>
                    <span>{{element.type}}</span>
                    <span>{{element.review}}</span>
                </div>
          </div>
      </div>
  </div>
</template>

<script>
import BeerLoverHeader from '../components/BeerLoverHeader.vue'
import ratingReviewService from '../services/RatingReviewService.js'


export default {
  components: { BeerLoverHeader },
    data() {
        return {
            ratingsAndBeers: [],
            reviewsAndBeers: []
        }
    },
    created () {
        ratingReviewService.getRatingsAndBeersByUser(this.$store.state.user.id)
            .then( response => {
                this.ratingsAndBeers = response.data;
                
            });
        ratingReviewService.getReviewsAndBeersByUser(this.$store.state.user.id)
            .then( response => {
                this.reviewsAndBeers = response.data;
                
            })
    }
}
</script>

<style>

</style>