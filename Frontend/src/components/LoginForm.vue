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
          return; // Detiene la función si los campos están vacíos
        } else {
          if (!this.correoValido){
            alert('Escribe un correo con formato válido');
            return;
          } else {

          }
        }
        // Aquí puedes agregar la lógica para iniciar sesión
        // Puedes hacer una petición a tu API para autenticar al usuario
        // o realizar cualquier acción necesaria
      },
      validarCorreo() {
        // Utiliza una expresión regular para validar el formato del correo
        const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
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
  