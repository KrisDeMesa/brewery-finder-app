<template>
    <div>
        <router-link class="brewery-link" v-for="brewery in filterBreweries" v-bind:key="brewery.id" :to="{ name: 'brewery-details', params: {id: brewery.id}}">
        <ul>
          <li> {{ brewery.name }} </li>
        </ul>
        </router-link>
        <router-view />
    </div>
</template>

<script>

import breweryService from "../services/BreweryService";
export default {
  created() {
    breweryService.getBreweries().then((response) => {
      this.$store.commit("GET_BREWERIES", response.data);
    });
  },
  computed: {
    breweryList() {
      return this.$store.state.breweries;
    },
    filterBreweries() {
      // return this.$store.state.filrterBreweries;
    const currentSearch = this.$store.state.currentSearch;
    const currentType = this.$store.state.currentType;

    return this.$store.state.breweries.filter(brewery => {
      const nameMatch = brewery.name.toLowerCase().includes(currentSearch.toLowerCase());
      const typeMatch = currentType === '' || brewery.breweryType === currentType;

      return nameMatch && typeMatch;
    });
    }
    
  }
  
};
</script>

<style>

ul {
  list-style-type: none;
}

.brewery-link{
  color: rgb(255, 145, 0);
  font-size: 20px;
  text-decoration: none;
}

</style>