<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <app-header v-show="!hideHeader" />
    
    <router-view />

  </div>
</template>

<script>
import AppHeader from './components/AppHeader.vue'

export default {
  components: {
    AppHeader,
    
  },
  computed: {
    hideHeader() {
      return this.$route.name === 'login' || this.$route.name === 'register';
    }
  }
}
</script>

<style>
  @import url('https://fonts.googleapis.com/css2?family=Archivo&display=swap');
  * {
    font-family: 'Archivo', sans-serif;
  }
</style>