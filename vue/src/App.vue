<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }" v-if="$route.name != 'home'">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div> -->
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
