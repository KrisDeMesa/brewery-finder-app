<template>
  <div class="brewery-beer-list">
    <div id="add-btn">
      <button type="button">Add Beer</button>
    </div>
    <div v-for="beer in beers" v-bind:key="beer.id">
      <div class="data-div">
        <div id="image-div">
          <img
          class="beer-rating"
          v-for="index in rating"
          v-bind:key="index"
          src="../assets/images/beer-rating.png"
          
        /></div>
        <span class="beer-name" id="beer-name">{{ beer.name }}</span
        >
        <div id="btn">
          <button
          class="edit-button"
          @click="$store.commit('CHANGE_BREWER_PAGE_VIEW', 'beer_edit')"
        >
          Edit
        </button>
        </div>
        
      </div>
      
    </div>
  </div>
</template>

<script>
export default {
  props: ["beers"],
  data() {
    return {
      rating: 5,
    };
  },
  computed: {
    numberOfBeers() {
      return this.beers.length;
    },
  },
};
</script>

<style scoped>
.brewery-beer-list {
  background: rgba(251, 230, 194, 0.7);
  border: 1px solid rgb(172, 13, 13);
  border-radius: 0 0 10px 0;
  grid-template-columns: 1fr 1fr 4fr;
  grid-template-areas: "beer-ratings edit-buttons beer-list";
}
.beer-rating {
  grid-area: beer-ratings;
}
.edit-button {
  grid-area: edit-buttons;
}
.beer-name {
  grid-area: beer-list;
  font-size: 1.5rem;
}
img {
  width: 30px;
}
.data-div {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas: "image beer-name btn";
  gap: 10px;
  text-align: center;
  align-items: center;
}

#image-div {
  grid-area: image;
  /* text-align: center; */
}

#btn {
  grid-area: btn;
}

#beer-name {
  grid-area: beer-name;
}
#add-btn{
  text-align: center;
  margin: 1rem 0;
}

</style>