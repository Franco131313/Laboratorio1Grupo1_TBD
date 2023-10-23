<template>
    <div>
      <h6>Tus Coordenadas</h6>
      <p>{{ coordinates.lat.toFixed(4) }} Latitud, {{ coordinates.lng.toFixed(4) }} Longitud</p>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        coordinates: {
          lat: 0,
          lng: 0
        },
      };
    },
    created() {
      // Obtener las coordenadas del usuario
      this.$getLocation({})
        .then(coordinates => {
          this.coordinates = coordinates;
        })
        .catch(error => alert(error));
    },
  };
  </script>
  