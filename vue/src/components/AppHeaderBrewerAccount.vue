<template>
  <div class="app-header-brewer">
    <div id="main-header">
      <router-link :to="{ name: 'home' }"
        ><img
          class="nav-link"
          id="ontap-logo"
          src="../assets/images/ontap-logo.png"
          alt="on-tap"
      /></router-link>

      <div id="brewery-title">
          <p>{{brewery.name}}</p>
          </div>

      <div class="account-logout">
        <router-link
          v-bind:to="{ name: 'logout' }"
          v-if="$store.state.token != ''"
        >
          <button class="logout-btn">Log Out</button>
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
export default {
    props: ["brewery"]
};
</script>

<style>
</style>