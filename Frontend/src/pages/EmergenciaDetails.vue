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
        <q-card-section class="text-h7">Nombre de la Emergencia: {{ emergencia.nombre }}</q-card-section>
        <q-card-section class="text-h7">Descripción: {{ emergencia.descrip }}</q-card-section>
        <q-card-section class="text-h7">Fecha de Inicio: {{ emergencia.fecha_inicio }}</q-card-section>
        <q-card-section class="text-h7">Fecha de Finalización: {{ emergencia.fecha_fin }}</q-card-section>
        <q-card-section class="text-h7">ID Institucion: {{ emergencia.id_INSTITUCION }}</q-card-section>
        <q-card-section class="text-h7">Latitud Emergencia: {{ emergencia.latitud_emer }}</q-card-section>
        <q-card-section class="text-h7">Longitud Emergencia: {{ emergencia.longitud_emer }}</q-card-section>
        <q-card-section class="text-h7">Estado: {{ emergencia.estado }}</q-card-section>
        <!-- Agrega más detalles aquí -->
      </q-card>

      <q-card-section align="right">
        <!-- Enlace para volver a la lista de emergencias -->
        <router-link to="/coordinadores/emergencia-list">Volver a la Lista de Emergencias</router-link>
      </q-card-section>
    </q-page-container>
  </q-page>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      emergencia: {},
    };
  },
  created() {
    // Recupera el ID de la emergencia desde la ruta (puedes obtenerlo como un parámetro de ruta)
    const emergenciaId = this.$route.params.id;

    // Realiza una solicitud al servidor para obtener los detalles de la emergencia con el ID correspondiente
    axios
    .get(`http://localhost:8082/api/emergencia/lista-emergencia`)
    .then((response) => {
      this.emergencia = response.data[emergenciaId-1]; // Asigna los detalles de la emergencia
        console.log(this.emergencia);
      })
      .catch((error) => {
        console.error('Error al obtener los detalles de la emergencia:', error);
      });
  },
};
</script>

<style lang="sass" scoped>
.pagina
  min-width: 600px
  max-width: 600px
  min-height: 400px
</style>
