<template>
  <div class="app-header">
    <div id="main-header">
      <div id="logo-div">
        <router-link :to="{ name: 'home' }">
          <img
            @click="defaultHomeView"
            class="nav-link"
            id="ontap-logo"
            src="../assets/images/ontap-logo.png"
            alt="on-tap"
        /></router-link>
      </div>

      <div id="beer-name">
        <p>{{ beer.name }}</p>
      </div>
      <div id="btns">
        <div id="flex-buttons">
          
            <div class="btn-container">
              <button
                class="btn"
                @click="$router.push({ name: 'account-user' })"
              >
                Account Menu
              </button>
            </div>
            <div class="btn-container">
              <button
                class="btn"
                @click="$router.push({ name: 'logout' })"
                v-if="$store.state.token != ''"
              >
                Log Out
              </button>
            </div>
          
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: ["beer"],
  methods: {
        defaultHomeView() {
            this.$store.commit('CHANGE_BREWER_PAGE_VIEW', 'brewery_beer_list');
        }
    }
};
</script>

<style scoped>
.app-header {
  background: rgba(251, 230, 194);
  border-top: 1px solid rgb(172, 13, 13);
  border-radius: 10px 10px 0 0;
  padding-top: 30px;
  padding-bottom: 40px;
}
#main-header {
  color: rgb(172, 13, 13);
  display: grid;
  grid-template-columns: 1fr 2fr 1fr;
  grid-template-areas: "logo name logout";
  align-items: center;
  justify-items: center;
}
#logo-div {
  grid-area: logo;
}
#beer-name {
  grid-area: name;
  text-align: center;
}
#btns {
  grid-area: logout;
}
.btn {
  background-color: white;
  color: rgb(172, 13, 13);
  height: 30px;
  width: 120px;
  border-radius: 10px;
  border: 1px solid rgb(172, 13, 13);
  
}
.btn-container {
    text-align: center;
}
.btn:hover {
  cursor: pointer !important;
}
#ontap-logo {
  width: 180px;
  height: auto;
  margin-right: 40px;
}
#flex-buttons {
  
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  justify-content: space-evenly;
}
</style>