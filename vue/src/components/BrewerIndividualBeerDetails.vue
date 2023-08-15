<template>
    <div>
        <div class="header">
            <h1> {{beer.name}} </h1>
            <button @click="switchToEdit()">Edit</button>

        </div>
        <div class="beer-details">
            <div class="left-form">
                <span> {{averageRating}} </span>
                    <div v-for="(value, key) in beer" v-bind:key="key" v-show="confirmNotId(key)">
                        <span class="keys">{{`${formatKey(key)}: `}}</span>
                        <span>{{value}}</span>
                    </div>
            </div>

            <div class="right-form"> 
                <div v-for="review in selectedBeerReviews" v-bind:key="review.id">
                    <ul>
                        <li v-for="(value, key) in review" :key="key">
                            <span v-if="filteredReviewData(key)"> {{value}} </span>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import ratingReviewService from '../services/RatingReviewService';
export default {
    props: ["beer"],
    data() {
        return {
            averageRating: '',
            selectedBeerReviews: []
        }
    },
    created() {
        ratingReviewService.getBeerAvgRating(this.beer.id)
            .then(response => {
                this.averageRating = response.data;
            });
        ratingReviewService.getBeerReviews(this.beer.id)
            .then(response => {
                this.selectedBeerReviews = response.data;
            })
    },

    methods: {
        formatKey(key) {
            return String(key).replace(/([a-z])([A-Z])/g, '$1 $2').replace(/([a-z])([1-9])/g, '$1 $2');
        },
        confirmNotId(key) {
            return key != 'id';
        },
        filteredReviewData(key) {
            return key != 'beerId' && key != 'userId';
        },
        switchToEdit() {
            this.$store.commit('CHANGE_BREWER_PAGE_VIEW', 'brewer-beer-edit')
        }
    }
};
</script>

<style scoped>

.beer-details {
    background: white;
    display: grid;
    border: 1px solid rgb(172, 13, 13);
    border-left: none;
    border-radius: 0 10px 10px 0;
    grid-template-columns: 1fr 1fr;
    grid-template-areas: "left-form right-form";
    row-gap: 20px;
    margin-right: 40px;
    margin-bottom: 30px;
}

.left-form {
    grid-area: left-form;
}

.right-form {
    grid-area: right-form;
}

.keys {
    text-transform: capitalize;
    font-weight: bold;
}


</style>