<template>
  <div class="brewery-update">
    <!-- <form> -->
      <div class="left-form">
        <div class="input-field">
          <label for="name" class="name-label">Name: </label>
          <input type="text" id="name" class="name-input" :value="brewery.name"/>
        </div>

        <div class="input-field">
          <label for="phone">Phone: </label>
          <input type="text" id="phone" :value="brewery.phoneNumber"/>
        </div>

        <div class="input-field">
          <label for="website">Website: </label>
          <input type="text" id="website" :value="brewery.website"/>
        </div>

      </div>

      <div class="right-form">
        <div class="input-field">
          <label for="street1">Street 1: </label>
          <input type="text" id="street1" :value="brewery.streetAddress1"/>
        </div>

        <div class="input-field">
          <label for="street2">Street 2: </label>
          <input type="text" id="street2" :value="brewery.streetAddress2" />
        </div>

        <div class="input-field">
          <label for="city">City: </label>
          <input type="text" id="street2" :value="brewery.city"/>
        </div>

        <div class="input-field">
          <label for="state">State: </label>
          <input type="text" id="state" :value="brewery.stateProvince"/>
        </div>

        <div class="input-field">
          <label for="zip">Zip: </label>
          <input type="text" id="zip" :value="brewery.postalCode"/>
        </div>

        <div class="input-field">
          <label for="history">History: </label>
          <textarea id="history" :value="brewery.history"></textarea>
        </div>

      </div>
    <!-- </form> -->
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
  /* display: grid;
  grid-template-areas:  */

}

.right-form {
  border: 1px solid black;
  grid-area: right-form;
  /* text-align: right; */
}

form {
  grid-column: span 2;
}

.input-field {
  margin: 10px;
}

input {
  margin-right: 0px;
}

</style>