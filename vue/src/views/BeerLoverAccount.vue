<template>
  <div>
      <beer-lover-header id="beer-lover-header" />
      <div id="main">
          <div id="ratings">
                <p>My Ratings</p>
                <div v-for="rating in ratings" :key="rating.beerId">
                    <span>{{rating.amount}}</span>
                    <span>{{getBeerName(rating.beerId)}}</span>
                </div>
                    
          </div>
          <div id="reviews">
              <p>My Reviews</p>
          </div>
      </div>
  </div>
</template>

<script>
import BeerLoverHeader from '../components/BeerLoverHeader.vue'
import ratingReviewService from '../services/RatingReviewService.js'
import breweryService from '../services/BreweryService.js'

export default {
  components: { BeerLoverHeader },
    data() {
        return {
            ratings: []
        }
    },
    created () {
        ratingReviewService.getRatingsByUser(this.$store.state.user.id)
            .then( response => {
                this.ratings = response.data;
                
            })
    }, 
    methods: {
        getBeerName(beerId) {
            breweryService.getBeer(beerId)
                .then( response => {
                    return response.data.name;
                })
                .catch( error => {
                    if(error.response) {
                        return '';
                    }
                });
        }
    }
}
</script>

<style>

</style>