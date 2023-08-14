<template>
  <div>
      <ind-beer-header :beer="beer"/>
      
      <div></div>
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

<style>

</style>