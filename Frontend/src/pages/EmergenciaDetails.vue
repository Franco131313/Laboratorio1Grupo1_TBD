<template>
    <q-page class="pagina fixed-center">
      <q-page-container>
        <!-- Título de la página -->
        <div class="q-mb-md">
          <q-card class="q-pa-md">
            <div class="text-h6">Detalles de Emergencia</div>
          </q-card>
        </div>
  
        <!-- Muestra los detalles de la emergencia -->
        <q-card class="q-pa-md">
          <q-card-section class="text-h6">Nombre de la Emergencia: {{ emergencia.nombre }}</q-card-section>
          <!-- Muestra otros detalles de la emergencia aquí -->
          <!-- Por ejemplo: Descripción, fecha, ubicación, requisitos, etc. -->
        </q-card>
  
        <q-card-section align="right">
          <!-- Enlace para volver a la lista de emergencias -->
          <router-link to="/coordinator-dashboard/emergencia-list">Volver a la Lista de Emergencias</router-link>
        </q-card-section>
      </q-page-container>
    </q-page>
  </template>
  
  <script>
  export default {
    data() {
      return {
        emergencia: {}, // Aquí almacenarás los detalles de la emergencia seleccionada
      };
    },
    created() {
      // Recupera los detalles de la emergencia seleccionada, por ejemplo, haciendo una solicitud al servidor.
      // Asigna los detalles a this.emergencia.
    },
  };
  </script>
  
  <style lang="sass" scoped>
  .pagina
    min-width: 600px
    max-width: 600px
    min-height: 400px
  </style>
  