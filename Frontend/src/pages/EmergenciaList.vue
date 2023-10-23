<template>
  <div>
    <router-link to="/coordinadores">Volver a Panel de Control</router-link>
    <q-card class="formulario fixed-center">
    <input v-model="filter" placeholder="Buscar" @input="filterEmergencias" />
    <table>
      <thead>
        <tr>
          <th>Nombre de la Emergencia</th>
          <th>Descripción</th>
          <th>Fecha de Inicio</th>
          <th>Fecha de Finalización</th>
          <th>Estado</th>
          <th>Acciones</th> <!-- Nueva columna para acciones -->
        </tr>
      </thead>
      <tbody>
        <tr v-for="emergencia in filteredEmergencias" :key="emergencia.id">
          <td>{{ emergencia.nombre }}</td>
          <td>{{ emergencia.descrip }}</td>
          <td>{{ emergencia.fecha_inicio }}</td>
          <td>{{ emergencia.fecha_fin }}</td>
          <td>{{ emergencia.estado }}</td>
          <td>
            <!-- Agregar un enlace que dirija a los detalles de la emergencia -->
            <router-link :to="'/coordinadores/emergencia/' + emergencia.id_EMERGENCIA">Ver Detalles</router-link>
          </td>
        </tr>
      </tbody>
    </table>
  </q-card>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      filter: '',
      emergencias: [],
    };
  },
  computed: {
    filteredEmergencias() {
      return this.emergencias.filter((emergencia) => {
        return (
          emergencia.estado.toLowerCase().includes(this.filter.toLowerCase())
        );
      });
    },
  },
  methods: {
    filterEmergencias() {
      // Aplicar un filtro local en lugar de una nueva solicitud al servidor
    },
    fetchEmergencias() {
      axios
        .get('http://localhost:8082/api/emergencia/lista-emergencia')
        .then((response) => {
          this.emergencias = response.data;
        })
        .catch((error) => {
          console.error('Error al obtener las emergencias:', error);
        });
    },
  },
  watch: {
    filter() {
      // Puedes aplicar el filtro directamente aquí
    },
  },
  created() {
    this.fetchEmergencias();
  },
};
</script>

<style lang="sass" scoped>
.formulario
  min-width: 300px
  max-width: 900px
  min-height: 300px
</style>