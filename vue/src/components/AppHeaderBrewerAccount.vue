<template>
  <div class="app-header">
    <div id="main-header">
      <div id="logo-div">
      <router-link :to="{ name: 'home' }"
        ><img
          class="nav-link"
          id="ontap-logo"
          src="../assets/images/ontap-logo.png"
          alt="on-tap"
      /></router-link>
      </div>

      <div id="brewery-name">
          <p>{{brewery.name}}</p>
          </div>

      <div class="account-logout">
        <div id="logout">
          <button class="logout-btn" @click="$router.push({name: 'logout'})" v-if="$store.state.token != ''">Log Out</button>
          </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
    props: ["brewery"]
};
</script>

<style scoped>
.app-header {
    background: rgba(251,230,194, .7);
    border: 1px solid rgb(172, 13, 13);
    border-bottom: none;
    border-radius: 10px 10px 0 0;
    
}
#main-header {
    color: rgb(172, 13, 13);
    display: grid;
    grid-template-columns: 1fr 2fr 1fr;
    grid-template-areas: 
    "logo name logout";
    align-items: center;
    justify-items: center;
}
#logo-div{
    grid-area: logo;
}
#brewery-name{
    grid-area: name;
    text-align: center;
}
#account-logout{
    grid-area: logout;
}
#logout{
    display: flex;
    justify-content: flex-end;
}
.logout-btn{
    background-color: white;
    color: rgb(172, 13, 13);
    height: 30px;
    width: 120px;
    border-radius: 10px;
    border: 1px solid rgb(172, 13, 13);
    
}
.logout-btn:hover {
    cursor: pointer !important;
}
#ontap-logo {
   width: 180px;
   height: auto;
   
}
p{
    font-size: 3.5rem;
}
</style>