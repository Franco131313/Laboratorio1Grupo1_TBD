<template>
    <q-page class="pagina fixed-center">
      
      <q-page-container>
        <!-- Título de la página -->
        <div class="q-mb-md">
          <q-card class="q-pa-md">
            <div class="text-h6">Lista de Emergencias</div>
          </q-card>
        </div>
  
        <!-- Opciones de filtrado -->
        <q-card class="q-pa-md">
          <q-card-section align="left">
            <!-- Enlace para volver al panel de control del coordinador -->
            <router-link to="/coordinadores">Volver al Panel de Control</router-link>
          </q-card-section>
          <q-card-section class="text-h6">Filtrar Emergencias</q-card-section>
          <!-- Agrega aquí los campos o componentes para filtrar las emergencias -->
          <!-- Puede ser un formulario con campos como fecha, tipo de emergencia, ubicación, etc. -->
  
          <q-card-section>
            <!-- Botón para aplicar el filtro -->
            <q-btn label="Aplicar Filtro" color="primary" @click="applyFilter" />
          </q-card-section>
        </q-card>
  
        <!-- Lista de emergencias -->
        <q-card class="q-pa-md">
          <q-card-section class="text-h6">Lista de Emergencias</q-card-section>
          <q-list>
            <!-- Itera sobre las emergencias y muestra una entrada para cada una -->
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
  export default {
    data() {
      return {
        emergencias: [], // Aquí almacenarás la lista de emergencias
      };
    },
    methods: {
      applyFilter() {
        // Agrega la lógica para aplicar el filtro de emergencias aquí
        // Puedes hacer una solicitud al servidor para obtener las emergencias filtradas.
      },
      viewDetails(emergenciaId) {
        // Agrega la lógica para ver los detalles de una emergencia seleccionada
        // Puedes redirigir a la página de detalles de emergencia pasando el ID como parámetro.
        this.$router.push(`/coordinator-dashboard/emergencia-details/${emergenciaId}`);
      },
    },
  };
  </script>
  
  <style lang="sass" scoped>
  .pagina
    min-width: 600px
    max-width: 600px
    min-height: 400px
  </style>
  