<template>
  <div class="brewery-beer-list">
    
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
  background: white;
  border: 1px solid rgb(172, 13, 13);
  border-radius: 0 10px 10px 0;
  padding: 2rem;
}
.beer-rating {
  grid-area: beer-ratings;
}

.beer-name {
  grid-area: beer-list;
  font-size: 2rem;
  color: rgb(244,139,41);
}
img {
  width: 30px;
}
.data-div {
  display: grid;
  grid-template-columns: 1fr 1.5fr 2.5fr 1fr;
  grid-template-areas: ". image beer-name .";
  
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



</style>