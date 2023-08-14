<template>
  <div id="whole-page">
      <ind-beer-header :beer="beer"/>
      
      <div id="main-space">
          <div id="left-grid">
              <p>test</p>
          </div>
          <div id="right-grid">
              <p>test</p>
          </div>
      </div>
  </div>
</template>

<script>
import IndBeerHeader from '../components/IndBeerHeader.vue'

export default {
    components: {
        IndBeerHeader
    }, 
    created() {
        //breweryService.getBeerById(this.$route.params(id))
        //promise: set this.beer to response.data
    },
    data () {
        return {
            beer: {}
        }
    }, 
    methods: {
        
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