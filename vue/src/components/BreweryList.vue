<template>
    <div>
        <router-link v-for="brewery in breweryList" v-bind:key="brewery.id" :to="{ name: 'brewery-details', params: {id: brewery.id}}"> 
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
  },
  methods: {},
};
</script>

<style>

</style>