<template>
  <div>
      <ind-beer-header />
      <p>test</p>
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