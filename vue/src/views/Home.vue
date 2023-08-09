<template>
  <div class="home">
    <!-- <app-header/> -->
    
    
    <div id="filter" class="grid-container">
      <h3 id="filter-header">Filter</h3>
      <div id="filter-content">filter content</div>
      </div>

    <div class="grid-container">
      <h3 id="brewerylist-header">Brewery List</h3>
      <div id="brewerylist-content"><brewery-list /></div>
      </div>

    <div id="map" class="grid-container">
      <h3 id="map-header">Map</h3>
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
  background: rgba(251,230,194, .7);
  border: 1px solid rgb(172, 13, 13);
  border-top: none;
  border-radius: 0 0 10px 10px;
  padding: 30px;
  display: grid;
    grid-template-columns: 2fr 4fr 3fr;
    grid-template-areas: 
    "filter-header brewerylist-header map-header"
    "filter-content brewerylist-content map-content";
    
}

h3{
  font-size: 25px;
  text-align: center;
  margin-bottom: 0px;
  padding-bottom: 40px;
  padding-top: 10px;
}
#filter-header {
  background-color: white;
  color: rgb(172, 13, 13);
  grid-area: filter-header;
  border-radius: 10px 0 0 0;
}
#brewerylist-header {
  background-color: white;
  color: rgb(172, 13, 13);
  grid-area: brewerylist-header;
}
#map-header {
  background-color: rgb(255, 255, 255);
  color: rgb(172, 13, 13);
  grid-area: map-header;
  border-radius: 0 10px 0 0 ;
}
#filter-content {
  background-color: white;
  grid-area: filter-content;
  padding-left: 30px;
}
#brewerylist-content {
  background-color: white;
  grid-area: brewerylist-content;
  padding-top: 10px;
}
#map-content {
  background-color: white;
  grid-area: map-content;
  padding-left: 30px;
}

</style>
