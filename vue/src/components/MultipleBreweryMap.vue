<template>
  <div>
    <div ref="map" style="width: 100%; height: 500px;"></div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      map: null,
      markers: [],
      breweries: []
    };
  },
  mounted() {
    // this.initMap();
    this.fetchBreweries();
  },
  methods: {
    // initMap() {
    //   const mapOptions = {
    //     zoom: 4,
    //     center: new google.maps.LatLng(39.8283, -98.5795) // Center of the USA
    //   };
    //   this.map = new google.maps.Map(this.$refs.map, mapOptions);
    // },
    fetchBreweries() {
      // Your API call to get brewery data here
      fetch('MY_API_KEY')
        .then(response => response.json())
        .then(data => {
          this.breweries = data;
          this.addMarkers();
        });
    },
    // addMarkers() {
    //   this.breweries.forEach(brewery => {
    //     const marker = new google.maps.Marker({
    //       map: this.map,
    //       position: new google.maps.LatLng(brewery.latitude, brewery.longitude),
    //       title: brewery.name
    //     });
    //     this.markers.push(marker);
    //   });
    // },
  }
};

</script>

<style scoped>
/* Add any styles you need for the component */
</style>
