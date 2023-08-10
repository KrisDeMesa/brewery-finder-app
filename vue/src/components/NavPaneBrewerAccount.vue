<template>
  <div>
      <section id="nav-pane">
        <button id="beers" @click="beerListPageView">My Beers</button>
        <button id="update" @click="breweryUpdatePageView">Update Brewery</button>
      </section>
  </div>
</template>

<script>
export default {
  methods: {
    breweryUpdatePageView() {
      return this.$store.commit('CHANGE_BREWER_PAGE_VIEW', 'brewery_update');
    },
    beerListPageView() {
      return this.$store.commit('CHANGE_BREWER_PAGE_VIEW', 'brewery_beer_list');
    }
  }
}
</script>

<style scoped>
#nav-pane{
  
  display: flex;
  flex-direction: column;
  align-items: center;
  /* justify-content: center; */
}
</style>