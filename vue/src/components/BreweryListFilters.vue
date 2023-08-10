<template>
  <div class="filter-container">
    <div class="filter-name">
        <input id="filter-name" v-model="filterValue" @input="filterData" placeholder="Brewery name" />
        <ul>
        <li v-for="item in filteredItems" :key="item.id">{{ item.name }}</li>
        </ul>
    </div>
    
    <div class="filter-location">
        <input id="filter-location" v-model="filterValue" @input="filterData" placeholder="Location" />
        <ul>
        <li v-for="item in filteredItems" :key="item.id">{{ item.name }}</li>
        </ul>
    </div>
    
    <div class="filter-brewery-type">
        <input id="brewery-type-filter" list="brewery-type" name="" placeholder="Select Brewery Type"/>
            <datalist id="brewery-type">
                <option value="Brewpub"></option>
                <option value="Micro"></option>
                <option value="Nano"></option>
                <option value="Large"></option>
                <option value="Planning"></option>
                <option value="Bar"></option>
                <option value="Contract"></option>
                <option value="Proprietor"></option>
                <option value="Closed"></option>
            </datalist>
    </div>
        
        
    <div class="filter-params"></div>
  </div>
</template>

<script>
export default {


}
</script>

<style>
.filter-container {
    margin-top: 30px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    
}
#brewery-type-filter {
    width: 300px;
    height: 30px;
}
#filter-name {
    justify-items: center;
    width: 300px;
    height: 30px;
}

#filter-location {
    justify-items: center;
    width: 300px;
    height: 30px;

}

.filter-name , .filter-location, #brewery-type-filter {
    margin-bottom: 30px;
    margin-right: 20px;
}


</style>