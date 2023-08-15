<template>
  <div id="whole-page">
      <ind-beer-header :beer="beer"/>
      
      <div id="main-space" >
          <div id="left-grid">
              <ul>
                  <div v-show="showAttributes">
                    <li class="labels" id="beerType" > Type: {{beer.type}} </li>
                    <li class="labels" id="beerAbv"> ABV: {{beer.abv}}%</li>
                    <li class="labels" id="beerDescription"> 
                        "{{beer.description}}"</li>
                  </div>
                  <div v-show="showRating">
                      <li>Average Rating: {{beerAvgRating}}</li>
                  </div>
                  
                </ul>
                
                <select id="dropdown" v-model="rating">
                    <option value=""></option>
                    <option value=1>1</option>
                    <option value=2>2</option>
                    <option value=3>3</option>
                    <option value=4>4</option>
                    <option value=5>5</option>
                </select>
                <br>
                <button id="submitrating" type="button" @click="submitRating()">Submit Rating</button>
          </div>
          <div id="right-grid">
              <div v-for="review in reviews" :key="review.userId">
                  {{review.description}}
              </div>

              <textarea id="reviewarea" rows="5" cols="50" v-model="review" placeholder= " Submit review here...">  </textarea>
              <br
              >
              <button id="sumbitreviewbutton" type="button" @click="submitReview()">Submit Review</button>
              
             </div>
      </div>
  </div>
</template>

<script>
import IndBeerHeader from '../components/IndBeerHeader.vue'
import breweryService from '../services/BreweryService.js'
import RatingReviewService from '../services/RatingReviewService.js'
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
                this.showAttributes = true;
                this.showRating = true;
            })
            .catch( error => {
                if (error.response) {
                    this.errorFlag = true;
                }
                this.showAttributes = true;
            })
        ratingReviewService.getBeerReviews(this.$route.params.id)
            .then( response => {
                this.reviews = response.data;
            })
    },
    data () {
        return {
            beer: {},
            beerAvgRating: 0,
            showAttributes: false,
            showRating: false,
            rating: '',
            reviews: [], 
            review: '',
            errorFlag: false
        }
    }, 
    methods: {
        submitRating() {
            RatingReviewService.addBeerRatings(this.rating)
            .then(response => {
                if(response.status == 201) {
                    this.$router.push({name: 'account-user'})
                }
            })
            
        },
        submitReview() {
            RatingReviewService.addBeerReview(this.review)
            .then (response => {
                if (response.status == 201){
                    this.$router.push({name: 'account-user'})
                }
            })
         
        }
    }
}
</script>

<style scoped>

#main-space{
    display: grid;
    grid-template-columns: 1fr 1fr;
    grid-template-areas: 
    "left right";
    border: 1px solid black;
    
}
#left-grid{
    grid-area: left;
    display: flexbox;
    margin-right: 40px;
    margin-bottom: 30px;
    font-size: 1rem;


}
#right-grid{
    grid-area: right;
    /* display: flexbox; */
    display: flexbox;
    flex-wrap: wrap;
    
    
}
li {
    padding: 10px;
}
#beerType {
   text-decoration-style: dotted;
}
#dropdown {
    border-left-width: 1px;
    padding-left: 16px;
    margin-left: 50px;
}
#submitrating {
    
    padding: 2px;
    margin-left: 50px;
    margin-top: 15px;
   
}
#reviewarea {
    margin-top: 70px;
    margin-right: 40px;
    margin-bottom: 1px;
    font-size: 1rem;
    display: flex;
    align-content: center;
    justify-content: center;
}
#reviewsubmitbutton {
    display: flex;
    align-content: center;
    justify-items: center;
}
/* .beer-filling {
  width: 100px;
  height: 100px;
} */

</style>