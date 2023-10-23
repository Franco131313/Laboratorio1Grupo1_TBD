<template>
  <q-page class="pagina fixed-center">
    <q-page-container>
      <!-- ... (Título de la página, Opciones de filtrado) ... -->

      <!-- Lista de emergencias -->
      <q-card class="q-pa-md">
        <q-card-section class="text-h6">Lista de Emergencias</q-card-section>
        <q-list>
          <!-- Itera sobre todas las emergencias y muestra una entrada para cada una -->
          <q-item
            v-for="emergencia in emergencias"
            :key="emergencia.id"
            clickable
            @click="viewDetails(emergencia.id)"
          >
            <q-item-section>
              <q-item-label>{{ emergencia.nombre }}</q-item-label>
            </q-item-section>
          </q-item>
        </q-list>
      </q-card>
    </q-page-container>
  </q-page>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      emergencias: [], // Aquí almacenarás la lista de emergencias
    };
  },
  created() {
    // Realiza una solicitud GET para obtener la lista completa de emergencias
    axios.get('http://localhost:8082/api/emergencia/lista-emergencia')
      .then((response) => {
        // Asigna la lista de emergencias obtenida a la propiedad 'emergencias'
        this.emergencias = response.data;
      })
      .catch((error) => {
        console.error('Error al obtener la lista de emergencias:', error);
      });
  },
  methods: {
    viewDetails(emergenciaId) {
      // Agrega la lógica para ver los detalles de una emergencia seleccionada
      // Puedes redirigir a la página de detalles de emergencia pasando el ID como parámetro.
      this.$router.push(`/coordinator-dashboard/emergencia-details/${emergenciaId}`);
    },
  },
};
</script>
