<template>
  <div>
    <input v-model="filter" placeholder="Buscar" @input="filterEmergencias" />
    <table>
      <thead>
        <tr>
          <th>Nombre de la Emergencia</th>
          <th>Descripción</th>
          <th>Fecha de Inicio</th>
          <th>Fecha de Finalización</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="emergencia in filteredEmergencias" :key="emergencia.id">
          <td>{{ emergencia.nombre }}</td>
          <td>{{ emergencia.descrip }}</td>
          <td>{{ emergencia.fecha_inicio }}</td>
          <td>{{ emergencia.fecha_fin }}</td>
        </tr>
      </tbody>
    </table>
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
          emergencia.nombre.toLowerCase().includes(this.filter.toLowerCase()) ||
          emergencia.descrip.toLowerCase().includes(this.filter.toLowerCase())
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
