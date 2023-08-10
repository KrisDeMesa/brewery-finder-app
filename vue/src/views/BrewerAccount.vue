<template>
  <div id="grid">
      <app-header-brewer-account id="header" :brewery="brewery" />
      <nav-pane-brewer-account id="nav"/>
      <brewer-beer-list id="beer-list"/>
      <brewery-update id="update-brewery" :brewery="brewery"/>
  </div>
</template>

<script>
import AppHeaderBrewerAccount from '../components/AppHeaderBrewerAccount.vue';
import BrewerBeerList from '../components/BrewerBeerList.vue';
import NavPaneBrewerAccount from '../components/NavPaneBrewerAccount.vue';
import BreweryUpdate from '../components/BreweryUpdate.vue';

import breweryService from '../services/BreweryService.js';

export default {
    data () {
        return {
            brewery: {}
        }
    },
    components: {
        AppHeaderBrewerAccount,
        NavPaneBrewerAccount,
        BrewerBeerList,
        BreweryUpdate
    },
    created() {
        breweryService.getBreweries().then((response) => {
            this.$store.commit("GET_BREWERIES", response.data);
        });
        this.brewery = this.$store.state.breweries.find( curBrewery => {
            return curBrewery.brewerId === this.$store.state.curUser.id;
        });
    }
}
</script>

<style scoped>
#grid{
    display: grid;
    grid-template-rows: 1fr 4fr;
    grid-template-areas:
    "header header"
    "nav main"
    ;
}
#header{
    grid-area: header;
}
#nav{
    grid-area: nav;
}
#beer-list{
    grid-area: main;
}
#update-brewery{
    grid-area: main;
}
</style>