<template>
    <div class="home">    
        
    <div id="brewery-banner" class="banner">
        <h1 v-bind:key="key"> {{selectedBrewery.name}} </h1> 
    </div>
        <div id="brewery-details"></div>
        <div id="details-content"> 
            <h2> Brewery Details</h2>
        <ul>
            <li v-for="(value, key) in filteredDetails" v-bind:key="key"> 
                 <span class='keys'>{{`${key}: `}}</span>
                 <span>{{ `${value != null ? value : ''}` }}</span>
                 <p></p>
            </li>
        </ul>
        </div>    
        
    <div id="map-label"> 
    </div>
    <div id="map-content">
        <h2>Map</h2>
    </div>
    </div>


</template>

<script>
import breweryService from '../services/BreweryService'
export default {
    data() {
        return {
            selectedBrewery: {}
        }    
    },
    // RETRIEVE DIRECTLY FROM STORE
    // computed: {
    //     selectedBrewery() {
    //         return this.$store.state.breweries.find(brewery => {
    //             return brewery.id === this.$route.params.id;
    //         });
    //     }
    // }

    // RETRIEVE FROM DATABASE
    created() {
        breweryService.getBreweryById(this.$route.params.id)
            .then(resp => {
                if (resp.status === 200) {
                    this.selectedBrewery = resp.data;
                }
            });
    },
    computed: {
        filteredDetails() {
            let filtered = {};
            let removedItems = ['id', 'brewerId', 'name', 'openDbId', 'latitude', 'longitude'];
            for (const key in this.selectedBrewery) {
                if (!removedItems.includes(key)) {
                    filtered[key] = this.selectedBrewery[key];
                }
            }
            return filtered;
        }
    }
}
</script>

<style scoped>

#brewery-banner {
    background-image: url("../assets/brewery-banner.jpg");
    background-position: 60% 85%;
    filter: brightness(80%);
    border: 1px solid black;
    height: 300px;
    display: flex;
    justify-content: flex-start;
    align-items: center;
    
}

h1 {
    margin-left: 400px;
    margin-block-start: 100px;
    font-size: 80px;
    color: white;
    

}

.keys {
    text-transform: capitalize;
    font-weight: bold;
}
ul {
    list-style-type: none;
    margin-top: 30px;
}

.home {
  display: grid;
  border: 1px solid black;
    grid-template-columns: 2fr 2fr;
    grid-template-areas: 
    "banner banner"
    "brewery-details map-label"
    "details-content map-content";
    row-gap: 20px;
    
}
#brewery-details {
    grid-area: brewery-details;
}
#map-label {
    grid-area: map-label;
}
.banner {
  grid-area: banner;

}
#details-content {
  grid-area: details-content;
  margin-left: 300px;
  border: 1px solid black;
  
}
#map-content {
  grid-area: map-content;
  margin-left: 40px;
  margin-right: 200px;
  border: 1px solid black;
}
.grid-container {
  border: 1px solid black;
  padding: 20px;
}


</style>