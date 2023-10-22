<template>
  <div class="fixed-center row">
    <q-card class="my-card">
      <q-card-section class="q-mb-md">
        <div class="text-h4 text-center">Ingreso de usuario</div>
      </q-card-section>

      <q-separator />

      <q-card-actions vertical>
        <q-btn flat rounded color="primary" class="my-btn text-h6" @click="redirectToRegistro">Registro</q-btn>
        <q-btn flat rounded color="primary" class="my-btn text-h6" @click="redirectToInicioSesion">Inicio de Sesión</q-btn>
      </q-card-actions>
    </q-card>
  </div>
</template>

<script>
export default {
  name: 'PageIndex',
  methods: {
    redirectToRegistro() {
      // Redirige a la página de registro
      this.$router.push('/registro');
    },
    redirectToInicioSesion() {
      // Redirige a la página de inicio de sesión
      this.$router.push('/inicio-sesion');
    }
  }
}
</script>

<style lang="sass" scoped>
.my-card
  min-width: 400px
  max-width: 600px
.my-btn
  padding: 16px 32px  // Ajusta el espaciado vertical y horizontal de los botones
</style>
