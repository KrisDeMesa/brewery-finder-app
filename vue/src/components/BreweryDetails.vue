<template>
    <div>
        <ul>
            <li v-for="(value, key) in selectedBrewery" v-bind:key="key" > {{`${key}: ${value}`}} </li>
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
    }
}
</script>

<style>

</style>