<template>
  <div id="grid">
      <app-header-brewer-account id="header" :brewery="brewery" />
      <nav-pane-brewer-account id="nav"/>
      <brewer-beer-list id="beer-list" v-if="isBreweryBeerList"/>
      <brewery-update id="update-brewery" :brewery="brewery" v-if="isBreweryUpdate"/>
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
            this.brewery = this.$store.state.breweries.find( curBrewery => {
                return curBrewery.brewerId === this.$store.state.curUser.id;
            });
        });

    },
    computed: {
        isBreweryBeerList() {
            return this.$store.state.brewerPageView === 'brewery_beer_list';
        },
        isBreweryUpdate() {
            return this.$store.state.brewerPageView === 'brewery_update';
        }
    }
}
</script>

<style scoped>
#grid{
    display: grid;
    grid-template-rows: 1fr 4fr;
    grid-template-columns: 1fr 4fr;
    grid-template-areas:
    "header header"
    "nav main";
}
#header{
    grid-area: header;
}
#nav{
    grid-area: nav;
    background: rgba(251, 230, 194, 0.7);
    border: 1px solid rgb(172, 13, 13);
    border-right-width: 10px;
    border-right-style: groove;
    border-radius: 0 0 0 10px;
}
#beer-list{
    grid-area: main;
}
#update-brewery{
    grid-area: main;
}
</style>