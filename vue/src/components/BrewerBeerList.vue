<template>
  <div class="brewery-beer-list">
    <div v-for="beer in beers" v-bind:key="beer.id">
      <div class="data-div">
        <div id="image">
          <img
          class="beer-rating"
          v-for="index in rating"
          v-bind:key="index"
          src="../assets/images/beer-rating.png"
          
        /></div>
        <button
          class="edit-button"
          @click="$store.commit('CHANGE_BREWER_PAGE_VIEW', 'beer_edit')"
          id="btn"
        >
          Edit
        </button>
        <span class="beer-name" id="beer-name">{{ beer.name }}</span
        >
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
  /* display: grid; */
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
}
img {
  width: 30px;
}
.data-div {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas: "image btn beer-name";
  gap: 10px;
}

#image {
  grid-area: image;
}

#btn {
  grid-area: btn;
}

#beer-name {
  grid-area: beer-name;
}
</style>