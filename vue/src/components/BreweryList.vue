<template>
  <div> 
      <ul>
          <li v-for="brewery in breweryList" :key="brewery.id"> {{ brewery.name }}</li>
      </ul>
  </div>
</template>

<script>
import breweryService from '../services/BreweryService'
export default {
    created() {
        breweryService.getBreweries().then(response => {
            this.$store.commit('GET_BREWERIES', response.data);
    })
    },
    computed: {
        breweryList() {
            return this.$store.state.breweries;
        }
    },
    methods: {
         
        }
    }


</script>

<style>

</style>