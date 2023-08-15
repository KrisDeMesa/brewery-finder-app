<template>
  <div>
      <beer-lover-header id="beer-lover-header" />
      <div id="main">
          <div id="ratings">
                <div v-for="rating in ratings" :key="rating.beerId">

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


export default {
  components: { BeerLoverHeader },
    data() {
        return {
            ratings: []
        }
    },
    created () {
        ratingReviewService.getRatingsByUser(this.user.id)
            .then( response => {
                this.ratings = response.data;
                
            })
    }
}
</script>

<style>

</style>