<template>
  <div class="app-header">
      <div id="main-header">
        <router-link :to="{ name: 'home' }"><img class="nav-link" id="ontap-logo" src="../assets/images/ontap-logo.png" alt="on-tap"></router-link>
        <form class="search-name">
            <label for="breweryname">Name </label>
            <input type="text" id="breweryname" name="breweryname">
            
        </form>
        <form action="" class="search-location">
            <label for="location">City or State </label>
            <input type="text" id="location" name="location">
        </form>
        
        <div class="account-menu">
            
            <button class="menu-btn"> Account Menu
                
            </button>
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
.account-menu {
    grid-area: menu;
    justify-self: right;
    margin-right: 80px;
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
    background: rgba(251,230,194, .7);
    border: 1px solid rgb(172, 13, 13);
    border-bottom: none;
    border-radius: 10px 10px 0 0;
    padding-top: 20px;
}

label {
    font-size: 20px;
}

</style>