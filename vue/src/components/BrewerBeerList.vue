<template>
  <div class="brewery-beer-list">
    <div id="rating">
    <!-- <div id=rating v-for="beer in beers" v-bind:key="beer.id"> -->
      <!-- <img v-for="index in beer.rating" v-bind:key="index"src="../assets/images/beer-rating.png" -->
      <img v-for="index in rating" v-bind:key="index" src="../assets/images/beer-rating.png">
      <button id="edit-button">Edit</button>

    </div>

  </div>
</template>

<script>
export default {
  // props: ['beers'],
  data() {
    return {
      rating: 5
    }
  }
}
</script>

<style scoped>
  .brewery-beer-list {
    background: rgba(251, 230, 194, 0.7);
    display: grid;
    border: 1px solid rgb(172, 13, 13);
    border-radius: 0 0 10px 0;
    grid-template-columns: 1fr 1fr 4fr;
    grid-template-areas: "beer-rating edit-buttons beer-list";
    row-gap: 20px;
  }

  img {
    width: 30px;
  }


</style>