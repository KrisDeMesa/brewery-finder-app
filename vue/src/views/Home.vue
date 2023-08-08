<template>
  <div class="home">
    <!-- <app-header/> -->
    
    
    <div id="filter" class="grid-container">
      <h3 id="filter-header">Filter</h3>
      <div id="filter-content">filter content</div>
      </div>

    <div class="grid-container">
      <h3 id="brewerylist-header">Brewery List</h3>
      <brewery-list id="brewerylist-content" />
      </div>

    <div id="map" class="grid-container">
      <h2 id="map-header">Map</h2>
      <div id="map-content">map content</div>
      </div>
    
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
.home {
  display: grid;
    grid-template-columns: 2fr 4fr 3fr;
    grid-template-areas: 
    "filter-header brewerylist-header map-header"
    "filter-content brewerylist-content map-content";
    row-gap: 20px;
    
}
#filter-header {
  grid-area: filter-header;
}
#brewerylist-header {
  grid-area: brewerylist-header;
}
#map-header {
  grid-area: map-header;
}
#filter-content {
  grid-area: filter-content;
}
#brewerylist-content {
  grid-area: brewerylist-content;
}
#map-content {
  grid-area: map-content;
}
.grid-container {
  border: 1px solid black;
  padding: 20px;
}
</style>
