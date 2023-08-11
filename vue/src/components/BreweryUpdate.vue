<template>
  <div class="brewery-update">

    <!-- <form> -->
      <div class="left-form">

          <div class="labels" for= "name" id="name-label">Name: </div>
          <div class="labels" for="type" id="type-label">Brewery Type: </div>
          <div class="labels" for="phone" id="phone-label">Phone: </div>
          <div class="labels" for="website" id="website-label">Website: </div>
          <!-- <div class="labels" for="hours" id="hours-label">Hours: </div> -->

        <div class="input-field">
          <input type="text" id="name" v-model="updatedBrewery.name"/>
        </div>

        <div class="input-field">
          <select name="type" id="type" v-model="updatedBrewery.breweryType"> 
            <option value="bar">Bar</option>
            <option value="brewpub">Brewpub</option>
            <option value="closed">Closed</option>
            <option value="contract">Contract</option>
            <option value="large">Large</option>
            <option value="micro">Micro</option>
            <option value="nano">Nano</option>
            <option value="planning">Planning</option>
            <option value="proprietor">Proprietor</option>
            <option value="regional">Regional</option>
          </select>
        </div>
          
        <div class="input-field">
          <input type="text" id="phone" v-model="updatedBrewery.phoneNumber"/>
        </div>
    

        <div class="input-field">
          <input type="text" id="website" v-model="updatedBrewery.website"/>
        </div>

         <!-- <div class="input-field">
          <input type="text" id="hours" v-model="updatedBrewery.hours"/>
        </div> -->

        <div id="hours-of-operation">
          
          <div id="monday-flex">
            <div id="monday-top">
              <span>Monday</span>
              <span>
                <label for="monday-checkbox">Open:</label>
                <input type="checkbox" id="monday-checkbox" value=true v-model="updatedBrewery.hoursOfOperation[0].openStatus" />
              </span>
            </div>
            <div id="monday-middle">
              <label for="monday-open-select">Open:</label>
              <input type="number" min="1" max="12" id="monday-open-number" />
              <select id="monday-open-am-pm">
                <option value="AM">AM</option>
                <option value="PM">PM</option>
              </select>
            </div>
            <div id="monday-bottom">
              <label for="monday-close-select">Close:</label>
              <input type="number" min="1" max="12" id="monday-close-number" />
              <select id="monday-close-am-pm">
                <option value="AM">AM</option>
                <option value="PM">PM</option>
              </select>
            </div>
          </div>

          <div id="tuesday-flex">
            <div id="tuesday-top">
              <span>Tuesday</span>
              <span>
                <label for="tuesday-checkbox">Open:</label>
                <input type="checkbox" id="tuesday-checkbox" value="open" />
              </span>
            </div>
            <div id="tuesday-middle">
              <label for="tuesday-open-select">Open:</label>
              <input type="number" min="1" max="12" id="tuesday-open-number" />
              <select id="tuesday-open-am-pm">
                <option value="AM">AM</option>
                <option value="PM">PM</option>
              </select>
            </div>
            <div id="tuesday-bottom">
              <label for="tuesday-close-select">Close:</label>
              <input type="number" min="1" max="12" id="tuesday-close-number" />
              <select id="tuesday-close-am-pm">
                <option value="AM">AM</option>
                <option value="PM">PM</option>
              </select>
            </div>
          </div>

          <div id="wednesday-flex">
            <div id="wednesday-top">
              <span>Wednesday</span>
              <span>
                <label for="wednesday-checkbox">Open:</label>
                <input type="checkbox" id="wednesday-checkbox" value="open" />
              </span>
            </div>
            <div id="wednesday-middle">
              <label for="wednesday-open-select">Open:</label>
              <input type="number" min="1" max="12" id="wednesday-open-number" />
              <select id="wednesday-open-am-pm">
                <option value="AM">AM</option>
                <option value="PM">PM</option>
              </select>
            </div>
            <div id="wednesday-bottom">
              <label for="wednesday-close-select">Close:</label>
              <input type="number" min="1" max="12" id="wednesday-close-number" />
              <select id="wednesday-close-am-pm">
                <option value="AM">AM</option>
                <option value="PM">PM</option>
              </select>
            </div>
          </div>

          <div id="thursday-flex">
            <div id="thursday-top">
              <span>Thursday</span>
              <span>
                <label for="thursday-checkbox">Open:</label>
                <input type="checkbox" id="thursday-checkbox" value="open" />
              </span>
            </div>
            <div id="thursday-middle">
              <label for="thursday-open-select">Open:</label>
              <input type="number" min="1" max="12" id="thursday-open-number" />
              <select id="thursday-open-am-pm">
                <option value="AM">AM</option>
                <option value="PM">PM</option>
              </select>
            </div>
            <div id="thursday-bottom">
              <label for="thursday-close-select">Close:</label>
              <input type="number" min="1" max="12" id="thursday-close-number" />
              <select id="thursday-close-am-pm">
                <option value="AM">AM</option>
                <option value="PM">PM</option>
              </select>
            </div>
          </div>

          <div id="friday-flex">
            <div id="friday-top">
              <span>Friday</span>
              <span>
                <label for="friday-checkbox">Open:</label>
                <input type="checkbox" id="friday-checkbox" value="open" />
              </span>
            </div>
            <div id="friday-middle">
              <label for="friday-open-select">Open:</label>
              <input type="number" min="1" max="12" id="friday-open-number" />
              <select id="friday-open-am-pm">
                <option value="AM">AM</option>
                <option value="PM">PM</option>
              </select>
            </div>
            <div id="friday-bottom">
              <label for="friday-close-select">Close:</label>
              <input type="number" min="1" max="12" id="friday-close-number" />
              <select id="friday-close-am-pm">
                <option value="AM">AM</option>
                <option value="PM">PM</option>
              </select>
            </div>
          </div>

          <div id="saturday-flex">
            <div id="saturday-top">
              <span>Saturday</span>
              <span>
                <label for="saturday-checkbox">Open:</label>
                <input type="checkbox" id="saturday-checkbox" value="open" />
              </span>
            </div>
            <div id="saturday-middle">
              <label for="saturday-open-select">Open:</label>
              <input type="number" min="1" max="12" id="saturday-open-number" />
              <select id="saturday-open-am-pm">
                <option value="AM">AM</option>
                <option value="PM">PM</option>
              </select>
            </div>
            <div id="saturday-bottom">
              <label for="saturday-close-select">Close:</label>
              <input type="number" min="1" max="12" id="saturday-close-number" />
              <select id="saturday-close-am-pm">
                <option value="AM">AM</option>
                <option value="PM">PM</option>
              </select>
            </div>
          </div>

          <div id="sunday-flex">
            <div id="sunday-top">
              <span>Sunday</span>
              <span>
                <label for="sunday-checkbox">Open:</label>
                <input type="checkbox" id="sunday-checkbox" value="open" />
              </span>
            </div>
            <div id="sunday-middle">
              <label for="sunday-open-select">Open:</label>
              <input type="number" min="1" max="12" id="sunday-open-number" />
              <select id="sunday-open-am-pm">
                <option value="AM">AM</option>
                <option value="PM">PM</option>
              </select>
            </div>
            <div id="sunday-bottom">
              <label for="sunday-close-select">Close:</label>
              <input type="number" min="1" max="12" id="sunday-close-number" />
              <select id="sunday-close-am-pm">
                <option value="AM">AM</option>
                <option value="PM">PM</option>
              </select>
            </div>
          </div>

          <!-- <div v-for="day in days" :key="day" :id="`${day}-flex`">
            <div :id="`${day}-top`">
              <span>{{day}}</span>
              <span>
                <label :for="`${day}-checkbox`">Open:</label>
                <input type="checkbox" :id="`${day}-checkbox`" value="open" />
              </span>
            </div>
            <div id="monday-middle">
              <label for="monday-open-select">Open:</label>
              <input type="number" min="1" max="12" id="monday-open-number" />
              <select id="monday-open-am-pm">
                <option value="AM">AM</option>
                <option value="PM">PM</option>
              </select>
            </div>
            <div id="monday-bottom">
              <label for="monday-close-select">Close:</label>
              <input type="number" min="1" max="12" id="monday-close-number" />
              <select id="monday-close-am-pm">
                <option value="AM">AM</option>
                <option value="PM">PM</option>
              </select>
            </div>
          </div> -->
          
        </div>


      </div>

      <div class="right-form">

        <div class="labels" for="street1" id="street1-label">Street 1: </div>
        <div class="labels" for="street2" id="street2-label">Street 2: </div>
        <div class="labels" for="city" id="city-label">City: </div>
        <div class="labels" for="state" id="state-label">State: </div>
        <div class="labels" for="zip" id="zip-label">Zip: </div>
        <div class="labels" for="history" id="history-label">History: </div>

        <div class="input-field">
          <input type="text" id="street1" v-model="updatedBrewery.streetAddress1"/>
        </div>

        <div class="input-field">
          <input type="text" id="street2" v-model="updatedBrewery.streetAddress2"/>
        </div>

        <div class="input-field">  
          <input type="text" id="city" v-model="updatedBrewery.city"/>
        </div>

        <div class="input-field">
          <input type="text" id="state" v-model="updatedBrewery.stateProvince"/>
        </div>

        <div class="input-field">
          <input type="text" id="zip" v-model="updatedBrewery.postalCode"/>
        </div>

        <div class="input-field">
          <textarea id="history" v-model="updatedBrewery.history"></textarea>
        </div>

        <button id=submit @click.prevent="updateBrewery">Submit Changes</button>

      </div>
  </div>
</template>

<script>
import breweryService from '../services/BreweryService.js';
export default {
  
  props: ['brewery'],
  data() {
    return {
      updatedBrewery: {
        id: this.brewery.id,
        brewerId: this.brewery.brewerId,
        name: this.brewery.name,
        breweryType: this.brewery.breweryType,
        phoneNumber: this.brewery.phoneNumber,
        website: this.brewery.website,
        city: this.brewery.city,
        country: this.brewery.country,
        hours: this.brewery.hours,
        streetAddress1: this.brewery.streetAddress1,
        streetAddress2: this.brewery.streetAddress2,
        stateProvince: this.brewery.stateProvince,
        postalCode: this.brewery.postalCode,
        history: this.brewery.history,
        hoursOfOperation: this.brewery.hoursOfOperation
      },
      days: ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday']
    }
  },
  methods: {
    updateBrewery() {
      breweryService.updateBrewery(this.updatedBrewery)
        .then(response => {
          this.$store.commit('UPDATE_BREWERY', response.data);
          this.$router.push({name: 'home'});
        })
    }
  }
};
</script>


<style scoped>
.brewery-update {
  background: rgba(251, 230, 194, 0.7);
  display: grid;
  border: 1px solid rgb(172, 13, 13);
  border-radius: 0 0 10px 0;
  grid-template-columns: 1fr 1fr;
  grid-template-areas: "left-form right-form";
  row-gap: 20px;
}


.left-form {
  border: 1px solid black;
  grid-area: left-form;
  display: grid;
  grid-template-columns: 100px 1fr;
  /* grid-template-rows: 100px 100px 100px 100px; */
  grid-template-areas: 
  "name-label name"
  "type-label type"
  "phone-label phone"
  "website-label website"
  /* "hours-label hours" */
  "hours hours"
}
#hours-of-operation{
  grid-area: hours;
}

.right-form {
  border: 1px solid black;
  grid-area: right-form;
  display: grid;
  grid-template-columns: 100px 1fr;
  grid-template-rows: 100px 100px 100px 100px 100px 100px;
  grid-template-areas:
  "street1-label street1"
  "street2-label street2"
  "city-label city"
  "state-label state"
  "zip-label zip"
  "history-label history"

}
.labels{
  padding-top: 10px;
  padding-left: 10px;
}

#name {
  grid-area: name;
}

#name-label {
  grid-area: name-label;
}

#type{
  grid-area: type;
}

#type-label{
  white-space: nowrap;
  grid-area: type-label;
}

#phone {
  grid-area: phone;
}

#phone-label {
  grid-area: phone-label;
}

#website {
  grid-area: website;
}

#website-label {
  grid-area: website-label;
}

#hours{
  grid-area: hours;
}

#hours-label{
  grid-area: hours-label;
}

#street1{
  grid-area: street1;
}

#street1-label{
  grid-area: street1-label;
}

#street2{
  grid-area: street2;
}

#street2-label{
  grid-area: street2-label;
}

#city{
  grid-area: city;
}

#city-label{
  grid-area: city-label;
}

#state{
  grid-area: state;
}

#state-label{
  grid-area: state-label;
}

#zip{
  grid-area: zip;
}

#zip-label{
  grid-area: zip-label;
}

#history{
  grid-area: history;
}

#history-label{
  grid-area: history-label;
}



.input-field {
  padding: 10px;
  padding-left: 30px;
}

input {
  margin-right: 0px;
}

</style>