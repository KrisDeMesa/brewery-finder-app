<template>
    <div>    
        
    <div id="brewery-banner">
        <h1 v-bind:key="key"> {{selectedBrewery.name}} </h1> 
    </div>
        <ul>
            <li v-for="(value, key) in filteredDetails" v-bind:key="key"> 
                 <span class='keys'>{{`${key}: `}}</span>
                 <span>{{`${value}`}}</span>
                 <p></p>
            </li>
        </ul>    
        

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
            for (const key in this.selectedBrewery) {
                if (key != 'id' && key != 'brewerId') {
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
    background-color: blue;
    border: 1px solid black;
    height: 220px;
    display: flex;
    justify-content: flex-start;
    align-items: center;
}

h1 {
    border: 1px solid black;
    margin-left: 400px;
    margin-block-start: 100px;
    font-size: 60px;
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




</style>