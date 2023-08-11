<template>
  <div>
     <div id="nav-pane">
        
          <button id="beers" class="buttons" @click="beerListPageView">My Beers</button>

          <button id="add" class="minor-button" @click="beerAddPageview()">Add Beer</button>

          <button id="edit" class="minor-button" @click="beerEditPageView()">Edit Beer</button>
        
          <button id="update" class="buttons" @click="breweryUpdatePageView">Update Brewery</button>
        
      </div>
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
    },
    beerEditPageView() {
      return this.$store.commit('CHANGE_BREWER_PAGE_VIEW', 'beer_edit');
    },
    beerAddPageView() {
      return this.$store.commit('CHANGE_BREWER_PAGE_VIEW', 'beer_add');
    }
  }
}
</script>

<style scoped>
#nav-pane{
  height: 50%;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-around;
}
.buttons {
  width: 50%;
  height: 3rem;
  cursor: pointer !important;
  background-color: white;
  color: rgb(172, 13, 13); 
  border-radius: 10px;
  border: 1px solid rgb(172, 13, 13);
}
.minor-button {
  width: 25%;
  height: 2rem;
  cursor: pointer !important;
  background-color: white;
  color: rgb(172, 13, 13); 
  border-radius: 10px;
  border: 1px solid rgb(172, 13, 13);
}
.buttons:hover{
  color: rgb(244,139,41);
  border-color: rgb(244,139,41);
}

.minor-button:hover{
  color: rgb(244,139,41);
  border-color: rgb(244,139,41);
}


</style>