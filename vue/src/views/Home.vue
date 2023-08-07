<template>
  <div class="home">
    <h1>Home</h1>
    <p>If you are seeing this, you are authenticated.</p>
    <brewery-list />
  </div>
</template>

<script>
import BreweryList from '../components/BreweryList.vue';
export default {
  name: "home",
  components: {
    BreweryList
  }
};
</script>
