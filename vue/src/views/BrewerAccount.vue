<template>
  <div id="grid">
      <app-header-brewer-account id="header" :brewery="brewery" />
      <nav-pane-brewer-account id="nav"/>
      <brewer-beer-list id="beer-list"/>
      <brewery-update id="update-brewery"/>
  </div>
</template>

<script>
import AppHeaderBrewerAccount from '../components/AppHeaderBrewerAccount.vue';
import BrewerBeerList from '../components/BrewerBeerList.vue';
import NavPaneBrewerAccount from '../components/NavPaneBrewerAccount.vue';
import BreweryUpdate from '../components/BreweryUpdate.vue';

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
        this.brewery = this.$store.state.breweries.find( curBrewery => {
            return curBrewery.brewer === this.$store.state.curUser.id;
        });
    }
}
</script>

<style scoped>
#grid{
    display: grid;
    grid-template-rows: 1fr 4fr;
    grid-template-areas:
    "header"
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