<template>
  <div>
      <section id="nav-pane">
        <span id="beers">My Beers</span>
        <button id="update" @click="$store.commit('CHANGE_BREWER_PAGE_VIEW', 'brewery_update')">Update Brewery</button>
      </section>
  </div>
</template>

<script>
export default {

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