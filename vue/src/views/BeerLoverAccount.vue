<template>
  <div class="beer-lover-account">
      <beer-lover-header id="beer-lover-header" />
      <div id="main">
          <div class="left-form"> 
          <div class="headers" id="rating-header">My Ratings</div>
          <div id="ratings">
                <div id="individual-beer" v-for="element in ratingsAndBeers" :key="element.beerId">
                    <div id="category">Beer Name: </div>
                    <span id="info">{{element.name}}</span>
                    <div id="category">My Rating: </div>
                    <span id="info" >{{element.rating}}</span>
                    <br>
                    <div id="category">Type of Beer: </div>
                    <span id="info">{{element.type}}</span>
                </div> 
            </div>
          </div>
          <div class="right-form">
          <div class="headers" id="review-header">My Reviews</div>
          <div id="reviews">
              <div v-for="element in reviewsAndBeers" :key="element.beerId">
                    <span>{{element.name}}</span>
                    <span>{{element.type}}</span>
                    <span>{{element.review}}</span>
                </div>
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

<style scoped>

.beer-lover-account{
    background: rgba(251,230,194);
    height: 100%;
    
}
#main {
    height: 100%;
    background: rgba(251,230,194);
    border: 1px solid rgb(172, 13, 13);
    border-top: none;
    border-radius: 0 0 10px 10px;
    display: grid;
    grid-template-columns: .75fr 1fr;
    grid-template-areas: 
    "left-form right-form";
}

.left-form{
    background: white;
    display: flex;
    flex-direction: column;
    grid-area: left-form;
    margin-left: 30px;
    max-height: 100%;
    border: 1px solid rgb(172, 13, 13);
    border-radius: 10px 0 10px 10px;
    margin-bottom: 30px;
    padding: 10px
}

.right-form{
    background: white;
    display: flex;
    flex-direction: column;
    grid-area: right-form;
    margin-right: 30px;
    max-height: 100%;
    border: 1px solid rgb(172, 13, 13);
    border-radius: 0 10px 10px 10px;
    border-left: none;
    margin-bottom: 30px;
}
#ratings {
    grid-area: ratings;
    padding-top: 30px;
    padding-left: 30px;
}
#reviews {
    grid-area: review;
}

#rating-header, #review-header{
    display: flex;
    justify-content: center;
    font-size: 40px;
    font-weight: 900;
    color: rgb(172, 13, 13);
}

#individual-beer{
    padding-bottom: 20px;
    /* border: 1px solid rgb(172, 13, 13); */
}

#info{
    padding-left: 100px;
}
</style>