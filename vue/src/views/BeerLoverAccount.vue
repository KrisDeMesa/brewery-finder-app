<template>
  <div>
      <beer-lover-header id="beer-lover-header" />
      <div id="main">
          <div id="ratings">
                <p>My Ratings</p>
                <div v-for="n in numberOfRatings" :key="n">
                    <span>{{ratings[n-1].amount}}</span>
                    <span>{{beerNames[n-1]}}</span>
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
            ratings: [],
            beerNames: []
        }
    },
    created () {
        ratingReviewService.getRatingsByUser(this.$store.state.user.id)
            .then( response => {
                this.ratings = response.data;
                for (let i = 0; i < this.numberOfRatings; i++) {
                    this.beerNames[i] = this.getBeerName(this.ratings[i].beerId);
                }
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
                        alert('error');
                    }
                });
        }
    },
    computed: {
        numberOfRatings() {
            return this.ratings.length;
        }
    }
}
</script>

<style>

</style>