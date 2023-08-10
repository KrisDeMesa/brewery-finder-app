<template>
  <div class="brewery-update">

    <!-- <form> -->
      <div class="left-form">

          <div class="labels" for= "name" id="name-label">Name: </div>
          <div class="labels" for="phone" id="phone-label">Phone: </div>
          <div class="labels" for="website" id="website-label">Website: </div>

        <div class="input-field">
          <input type="text" id="name" :value="brewery.name"/>
        </div>
          
        <div class="input-field">
          <input type="text" id="phone" :value="brewery.phoneNumber"/>
        </div>
    

        <div class="input-field">
          <input type="text" id="website" :value="brewery.website"/>
        </div>

      </div>

      <div class="right-form">
        <div class="input-field">
          <div for="street1" id="street1-label">Street 1: </div>
          <input type="text" id="street1" :value="brewery.streetAddress1"/>
        </div>

        <div class="input-field">
          <div for="street2" id="street1-labe2">Street 2: </div>
          <input type="text" id="street2" :value="brewery.streetAddress2" />
        </div>

        <div class="input-field">
          <div for="city" id="city-label">City: </div>
          <input type="text" id="city" :value="brewery.city"/>
        </div>

        <div class="input-field">
          <div for="state" id="state-label">State: </div>
          <input type="text" id="state" :value="brewery.stateProvince"/>
        </div>

        <div class="input-field">
          <div for="zip" id="zip-label">Zip: </div>
          <input type="text" id="zip" :value="brewery.postalCode"/>
        </div>

        <div class="input-field">
          <div for="history" id="history-label">History: </div>
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
  padding-left: 10px;
  display: grid;
  grid-template-columns: 60px 1fr;
  grid-template-rows: 100px 100px 100px;
  grid-template-areas: 
  "name-label name"
  "phone-label phone"
  "website-label website"

}

.labels{
  padding-top: 10px;
}

#name {
  grid-area: name;
}

#name-label {
  padding-top: 10;
  grid-area: name-label;
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

.right-form {
  border: 1px solid black;
  grid-area: right-form;
  /* text-align: right; */
}

.input-field {
  margin: 10px;
}

input {
  margin-right: 0px;
}

</style>