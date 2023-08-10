<template>
  <div class="brewery-update">
      <div class="left-fields">
        <div class="input-field">
          <label for="name">Name: </label>
          <input type="text" id="name" :value="brewery.name"/>
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

      <div class="right-fields">
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
  grid-template-areas: "left-fields right-fields";
  row-gap: 20px;
}

.left-fields {
  grid-area: left-fields;
  text-align: right;
}

.right-fields {
  grid-area: right-fields;
  text-align: right;
}

.input-field {
  margin: 10px;
}

input {
  margin-right: 0px;
}

</style>