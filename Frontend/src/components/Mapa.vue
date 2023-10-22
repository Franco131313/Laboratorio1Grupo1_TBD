<template>
    <div>
      <h6>Tus Coordenadas</h6>
      <p>{{ coordinates.lat.toFixed(4) }} Latitud, {{ coordinates.lng.toFixed(4) }} Longitud</p>
  
      <!-- Casilla de verificación para registrarse como voluntario -->
      <q-checkbox
        v-model="voluntarioSelected"
        label="Registrarse como voluntario"
        @input="onCheckboxChange('voluntario')"
      />
      
      <!-- Casilla de verificación para registrarse como coordinador -->
      <q-checkbox
        v-model="coordinadorSelected"
        label="Registrarse como coordinador"
        @input="onCheckboxChange('coordinador')"
      />
  
      <!-- Componente adicional: lista desplegable -->
      <div v-if="voluntarioSelected">
        <q-btn-dropdown color="primary" label="Elegir habilidad">
          <q-list>
            <q-item clickable v-close-popup @click="onItemClick">
              <q-item-section>
                <q-item-label>Habilidad 1</q-item-label>
              </q-item-section>
            </q-item>
  
            <q-item clickable v-close-popup @click="onItemClick">
              <q-item-section>
                <q-item-label>Habilidad 2</q-item-label>
              </q-item-section>
            </q-item>
  
            <q-item clickable v-close-popup @click="onItemClick">
              <q-item-section>
                <q-item-label>Habilidad 3</q-item-label>
              </q-item-section>
            </q-item>
          </q-list>
        </q-btn-dropdown>
      </div>
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
        voluntarioSelected: false,
        coordinadorSelected: false,
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
    methods: {
      onItemClick() {
        console.log('Clicked on an Item');
      },
      onCheckboxChange(selected) {
        if (selected === 'voluntario') {
          this.coordinadorSelected = false; // Desmarca la casilla de coordinador
        } else if (selected === 'coordinador') {
          this.voluntarioSelected = false; // Desmarca la casilla de voluntario
        }
      }
    }
  };
  </script>
  