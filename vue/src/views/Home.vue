<template>
  <div class="home">
    <!-- <app-header/> -->
    
    
    <div class="filter"><h3>Filter</h3></div>
    <div class="brewery-list"><brewery-list/></div>
    <div class="map"><h2>Map</h2></div>
    
  </div>
</template>

<script>
import BreweryList from '../components/BreweryList.vue';
// import AppHeader from '../components/AppHeader.vue'
export default {
  name: "home",
  components: {
    // AppHeader,
    BreweryList
  }
    
    
};
</script>

<style scoped>
* {
  display: grid;
    grid-template-columns: .3fr 1fr .8fr;
    grid-template-areas: 
    "filter brewerylist map";
}
h1 {
  grid-area: map;
}
h3 {
  grid-area: filter;
}
.brewery-list {
  display: flex;
  
  grid-area: brewerylist;
  
}
</style>
