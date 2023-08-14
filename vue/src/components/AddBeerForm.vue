<template>
  <div class="add-brewery">
        <div class="labels" for= "name" id="name-label">Name: </div>
        <div class="labels" for="type" id="abv-label">ABV: </div>
        <div class="labels" for="abv" id="type-label">Type: </div>
        <div class="labels" for="description" id="description-label">Description: </div>
        <!-- <div class="labels" for="image" id="image-label">Image: </div> -->

        <div class="input-field">
          <input type="text" id="name-input" v-model="newBeer.name"/>
        </div>

        <div class="input-field">
          <input type="text" id="abv-input" v-model="newBeer.abv"/>
        </div>

         <div class="input-field">
          <input type="text" id="type-input" v-model="newBeer.type"/>
        </div>

        <div class="input-field">
          <textarea id="description-input" v-model="newBeer.description"/>
        </div>

        <!-- <div class="input-field">
          <input type="text" id="image" v-model="imageUrl"/>
        </div> -->

        <button id="submit" @click.prevent="addBeer">Add Beer</button>
  </div>
</template>

<script>
import BreweryService from '../services/BreweryService'
export default {
    props: ['brewery'],
    data() {
        return {
            newBeer: {
                name: '',
                description: '',
                abv: '',
                type: ''
            }
        }
    },
    methods: {
        addBeer() {
            BreweryService.addBeer(this.newBeer, this.brewery.id)
                .then(response => {
                    if (response.status == 201) {
                        this.$router.push({name: 'home'});
                    }
                })

        }
    }
}
</script>

<style scoped>

.add-brewery {
  background: white;
  display: grid;
  border: 1px solid rgb(172, 13, 13);
  border-radius: 0 10px 10px 10px;
  grid-template-columns: 1fr 1fr;
  grid-template-rows: 100px 100px 100px 100px;
  grid-template-areas: 
  "name-label name-input"
  "abv-label abv-input"
  "type-label type-input"
  "description-label description-input";
  row-gap: 20px;
  margin-bottom: 30px;
  margin-right: 40px;
}

.labels{
  display: flex;
  padding-top: 40px;
  padding-left: 10px;
  justify-content: center;

}

.input-field {
  padding: 40px;
  padding-left: 30px;
}

input {
  margin-right: 0px;
}

#name-label{
  grid-area: name-label;
}

#abv-label {
    grid-area: abv-label;
}

#type-label {
  grid-area: type-label;
}

#description-label {
  grid-area: description-label;
}

/* #image-label {
  grid-area: image-label;
} */

#name{
  grid-area: name-input;
}

#abv {
    grid-area: abv-input;
}

#type {
  grid-area: type-input;
}

#description {
  grid-area: description-input;
}

button {
  display: flex;
  justify-self: right;
  white-space: nowrap;
  height: 40px;
  width: 85px;
  justify-content: center;
  align-items: center;
  margin-top: 40px;
  margin-right: 80px;

}



/* 
#image {
  grid-area: image-input;
} */

</style>