<template>
  <div class="app-header">
      <div id="main-header">
        <router-link :to="{ name: 'home' }"><img class="nav-link" id="ontap-logo" src="../assets/images/ontap-logo.png" alt="on-tap"></router-link>
        
        <form class="search-bar">
            <!-- <label for="breweryname">Name </label> -->
            <input type="text" placeholder="Name of Brewery" id="breweryname" name="breweryname">
            
        </form>
        <form action="" class="search-bar">
            <!-- <label for="location">City or State </label> -->
            <input type="text" placeholder="Search for Beers" id="location" name="location">
        </form>
        
        <div id="flex-buttons">
            <div id="account-menu" class="btns">
                <router-link :to="$store.state.user.authorities[0].name === 'ROLE_USER' ? {name: 'account-user'} : {name: 'account-brewer'}">
                <button class="menu-btn"> Account Menu </button>
                </router-link>
            </div>

            <div id="account-logout" class="btns">
                <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">

                <button class="logout-btn"> Log Out </button>

                </router-link>
            </div>
        </div>
      </div>
      
  </div>
</template>

<script>
export default {
    
}
</script>

<style scoped>

#main-header {
    color: rgb(172, 13, 13);
    display: grid;
    grid-template-columns: 1fr 1fr 1fr 1fr;
    grid-template-areas: 
    "logo searchname searchlocation menu";
    justify-content: space-between;
    align-items: center;
}
#flex-buttons{
    display: flex;
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: space-evenly;
}
#account-menu {
    grid-area: menu;
}
#account-logout{
    grid-area: menu;
    justify-self: right;
}
.btns{
    text-align: center;
}
.menu-btn{
    /* margin-left: 80px; */
    background-color: white;
    color: rgb(172, 13, 13);
    height: 30px;
    width: 120px;
    border-radius: 10px;
    border: 1px solid rgb(172, 13, 13)
}

.logout-btn{
    /* margin-right: 60px; */
    background-color: white;
    color: rgb(172, 13, 13);
    height: 30px;
    width: 120px;
    border-radius: 10px;
    border: 1px solid rgb(172, 13, 13)
}
button:hover {
    cursor: pointer !important;
}

#ontap-logo {
   margin-left: 80px ;
   grid-area: logo;
   width: 180px;
   height: auto;
    
}

.nav-link:hover {
    cursor: pointer !important;
}

#breweryname {
    grid-area: searchname;
    justify-self: center;
   
}
#location {
    grid-area: searchlocation;
    justify-self: center;
}

.app-header {
    background: rgba(251,230,194);
    border: 1px solid rgb(172, 13, 13);
    border-bottom: none;
    border-radius: 10px 10px 0 0;
    padding-top: 20px;
}

.search-bar{
    padding-left: 40px
}
input[type="text"]{
    width: 300px;
    height: 40px;
    font-size: 25px;
}



</style>