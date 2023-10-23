<template>
  <q-page class="pagina fixed-center">
    <q-page-container>
      <!-- Título de la página -->
      <div class="q-mb-md">
        <q-card class="q-pa-md">
          <div class="text-h6">Crear Formulario de Ingreso de Emergencia</div>
        </q-card>
      </div>

      <!-- Formulario de ingreso de emergencia -->
      <q-card class="q-pa-md">
        <q-card-section class="text-h6">Detalles de Emergencia</q-card-section>
        <q-card-section>
          <q-input v-model="formData.nombre" label="Nombre de la emergencia" />
          <q-input v-model="formData.descrip" autogrow label="Descripción de la emergencia" />
          <q-input v-model="formData.fecha_inicio" label="Fecha de inicio" type="date" />
          <q-input v-model="formData.fecha_fin" label="Fecha de finalización" type="date" />
          <!-- Lista desplegable para seleccionar la institución -->
          <q-select
            v-model="formData.ID_INSTITUCION"
            :options="instituciones"
            label="Institución"
          />
          <q-input v-model="formData.latitud_emer" label="Latitud de la ubicación" type="number" />
          <q-input v-model="formData.longitud_emer" label="Longitud de la ubicación" type="number" />
          <!-- Agrega más campos según sea necesario -->
        </q-card-section>

        <q-card-section class="text-h6">Lista de Requisitos</q-card-section>
        <!-- Agrega aquí los campos o componentes para la lista de requisitos -->
        <!-- Puede ser una lista de verificación o cualquier otro elemento que necesites -->

        <q-card-section>
          <!-- Botón para enviar el formulario -->
          <q-btn label="Enviar" color="primary" @click="submitForm" />
        </q-card-section>
      </q-card>

      <q-card-section align="right">
        <!-- Enlace para volver al panel de control del coordinador -->
        <router-link to="/coordinadores">Volver al Panel de Control</router-link>
      </q-card-section>
    </q-page-container>
  </q-page>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      formData: {
        nombre: '',
        descrip: '',
        fecha_inicio: '',
        fecha_fin: '',
        ID_INSTITUCION: null, // Aquí se almacenará el ID de la institución seleccionada
        latitud_emer: 0,
        longitud_emer: 0,
        // Agrega más campos según sea necesario
      },
      instituciones: [], // Almacena la lista de instituciones
    };
  },
  created() {
    // Realiza una solicitud GET para obtener la lista de instituciones con sus nombres y IDs
    axios.get('http://localhost:8082/api/institucion/lista-institucion')
      .then((response) => {
        // Formatea los datos para mostrar los nombres de las instituciones en la lista desplegable
        // y asociar el ID correspondiente a cada una
        this.instituciones = response.data.map((institucion) => ({
          label: institucion.nombre,
        }));
      })
      .catch((error) => {
        console.error('Error al obtener la lista de instituciones:', error);
      });
  },
  methods: {
  submitForm() {
    this.formData.ID_INSTITUCION = this.$refs.mySelect.getEmittingOptionValue(this.formData.ID_INSTITUCION);
    console.log(this.formData.ID_INSTITUCION);
    // Realiza la solicitud POST al controlador para crear la emergencia
    axios.post('http://localhost:8082/api/emergencia/nueva-emergencia', this.formData)
      .then((response) => {
        // La emergencia se creó con éxito
        console.log('Emergencia creada:', response.data);
        alert('Emergencia Creada');
        // Redirige al usuario a la página deseada
        // Puedes utilizar Vue Router o la herramienta de enrutamiento que estés utilizando.
        this.$router.push('/coordinadores');
      })
      .catch((error) => {
        // Ocurrió un error al crear la emergencia
        console.error('Error al crear la emergencia:', error);
      });
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
