<template>
  <div id="grid">
      <app-header-brewer-account />
      <nav-pane-brewer-account />
      <brewer-beer-list />
      <brewery-update />
  </div>
</template>

<script>
import AppHeaderBrewerAccount from '../components/AppHeaderBrewerAccount.vue';
import BrewerBeerList from '../components/BrewerBeerList.vue';
import NavPaneBrewerAccount from '../components/NavPaneBrewerAccount.vue';
import BreweryUpdate from '../components/BreweryUpdate.vue';

export default {
    components: {
        AppHeaderBrewerAccount,
        NavPaneBrewerAccount,
        BrewerBeerList,
        BreweryUpdate
    }
}
</script>

<style scoped>
#grid{
    display: grid;
    
}
</style>