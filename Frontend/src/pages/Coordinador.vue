<template>
    <q-page class="pagina fixed-center">
      <q-page-container>
        <!-- Panel de control del coordinador -->
        <div class="q-mb-md">
          <q-card class="q-pa-md">
            <div class="text-h5">Panel de Control de Coordinadores</div>
            <!-- Agrega contenido adicional de bienvenida o información aquí -->
          </q-card>
        </div>
  
        <!-- Lista de opciones -->
        <q-card class="q-pa-md">
          <q-card-section class="text-h5">Opciones</q-card-section>
          <q-card-actions vertical>
            <q-btn flat rounded color="primary" class="text-h5" @click="redirectToEmergenciaCreate">Crear nueva emergencia</q-btn>
            <q-btn flat rounded color="primary" class="text-h5" @click="redirectToEmergenciaList">Ver lista de emergencias</q-btn>
          </q-card-actions>
        </q-card>
      </q-page-container>
    </q-page>
  </template>
  
  <script>
  export default {
    methods: {
    redirectToEmergenciaCreate() {
      // Redirige a la página de registro
      this.$router.push('/coordinadores/emergencia-create');
    },
    redirectToEmergenciaList() {
      // Redirige a la página de inicio de sesión
      this.$router.push('/coordinadores/emergencia-list');
    }
  }
  };
  </script>

<style lang="sass" scoped>
.pagina
  min-width: 600px
  max-width: 600px
  min-height: 400px
</style>
  