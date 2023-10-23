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
          <!-- Agrega aquí los campos del formulario para ingresar detalles de emergencia -->
          <!-- Por ejemplo: Nombre de la emergencia, descripción, fecha, ubicación, etc. -->
  
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
  export default {
    methods: {
      submitForm() {
        // Agrega la lógica para enviar el formulario aquí
        // Puedes enviar los datos del formulario al servidor o realizar otras acciones necesarias.
        // Ejemplo: guardar los detalles de emergencia y requisitos en la base de datos.
        // Después de enviar el formulario, puedes redirigir al coordinador a la página deseada.
        this.$router.push('/coordinator-dashboard');
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
  