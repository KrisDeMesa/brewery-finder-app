<template>
  <div class="brewery-update">

    <!-- <form> -->
      <div class="left-form">

          <div class="labels" for= "name" id="name-label">Name: </div>
          <div class="labels" for="type" id="type-label">Brewery Type: </div>
          <div class="labels" for="phone" id="phone-label">Phone: </div>
          <div class="labels" for="website" id="website-label">Website: </div>
          <div class="labels" for="hours" id="hours-label">Hours: </div>

        <div class="input-field">
          <input type="text" id="name" :value="brewery.name"/>
        </div>

        <div class="input-field">
          <select name="type" id="type"> 
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
          <input type="text" id="phone" :value="brewery.phoneNumber"/>
        </div>
    

        <div class="input-field">
          <input type="text" id="website" :value="brewery.website"/>
        </div>

         <div class="input-field">
          <input type="text" id="hours" :value="brewery.hours"/>
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
          <input type="text" id="street1" :value="brewery.streetAddress1"/>
        </div>

        <div class="input-field">
          <input type="text" id="street2" :value="brewery.streetAddress2" />
        </div>

        <div class="input-field">  
          <input type="text" id="city" :value="brewery.city"/>
        </div>

        <div class="input-field">
          <input type="text" id="state" :value="brewery.stateProvince"/>
        </div>

        <div class="input-field">
          <input type="text" id="zip" :value="brewery.postalCode"/>
        </div>

        <div class="input-field">
          <textarea id="history" :value="brewery.history"></textarea>
        </div>

        <button id=submit>Submit Changes</button>

      </div>
  </div>
</template>

<script>
export default {
  props: ['brewery']
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
  grid-template-rows: 100px 100px 100px 100px;
  grid-template-areas: 
  "name-label name"
  "type-label type"
  "phone-label phone"
  "website-label website"
  "hours-label hours"
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