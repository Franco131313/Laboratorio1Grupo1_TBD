<template>
  <q-page>
      <q-card class="formulario fixed-center">
          <q-card-section>
              <h6>Iniciar Sesión</h6>
          </q-card-section> 
          <q-card-section>
              <q-input
              v-model="correo"
              label="Correo"
              @blur="validarCorreo"
              />
          </q-card-section>
          <q-card-section>
              <q-input
              v-model="contrasenia"
              label="Contraseña"
              type="password"
              />
          </q-card-section>
          <q-card-section>
              <q-btn
              color="primary"
              label="Iniciar Sesión"
              @click="iniciarSesion"
              />
          </q-card-section>
          <q-card-section>
              <router-link to="/">Volver al Inicio</router-link>
          </q-card-section>
      </q-card>
  </q-page>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      correo: '',
      contrasenia: '',
      correoValido: true,
    };
  },
  methods: {
    iniciarSesion() {
      if (!this.correo || !this.contrasenia) {
        alert('Por favor, completa todos los campos.');
        return;
      } else {
        if (!this.correoValido) {
          alert('Escribe un correo con formato válido');
          return;
        } else {
          axios
            .get(`http://localhost:8082/api/usuarios/buscar?email=${this.correo}`)
            .then((response) => {
              const usuario = response.data;
              if (usuario && usuario.password === this.contrasenia) {
                if (usuario.rol === 'coordinador') {
                  // Usuario es un coordinador, redirige a la página de coordinador
                  this.$router.push('/coordinadores'); // Cambia '/coordinador' por la ruta deseada
                } else {
                  // Usuario no es coordinador, redirige a la página de usuario
                  this.$router.push('/'); // Cambia '/perfil' por la ruta deseada
                }
              } else {
                alert('Inicio de sesión fallido. Comprueba tu correo y contraseña.');
              }
            })
            .catch((error) => {
              console.error('Error al iniciar sesión:', error);
              alert('Error al iniciar sesión. Inténtalo de nuevo.');
            });
        }
      }
    },
    validarCorreo() {
      const emailPattern = /^[a-zA-Z0-9._-]+@[a-zAZ0-9.-]+\.[a-zA-Z]{2,4}$/;
      this.correoValido = emailPattern.test(this.correo);
    },
  }
};
</script>

<style lang="sass" scoped>
.formulario
  min-width: 400px
  max-width: 600px
  min-height: 100px
</style>
