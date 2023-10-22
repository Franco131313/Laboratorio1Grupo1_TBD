<template>
    <q-page>
      <q-card class="formulario fixed-center">
        <q-card-section>
          <div class="text-h5 text-center">Registro de Usuario</div>
        </q-card-section>
  
        <q-card-section>
          <q-input
            v-model="nombre"
            label="Nombre"
          />
          <q-input
            v-model="correo"
            label="Correo"
            type="email"
            @blur="validarCorreo"
          />
          <q-input
            v-model="contrasenia"
            label="Contraseña"
            type="password"
          />
          <Mapa />
          <!-- Agrega más campos según tus necesidades -->
        </q-card-section>
  
        <q-card-actions align="right">
          <q-btn
            color="primary"
            label="Registrarse"
            @click="registrarUsuario"
          />
        </q-card-actions>
      </q-card>
    </q-page>
  </template>
  
  <script>
  import { ref } from 'vue'
  import Mapa from 'components/Mapa.vue';
  
  export default {
    data() {
      return {
        nombre: '',
        correo: '',
        contrasenia: '',
        ubicacion: '',
        correoValido: true // Variable para almacenar si el correo es válido
        // Agrega más variables de datos según sea necesario
      };
    },
    methods: {
      registrarUsuario() {
        if (this.correoValido) {
          // Aquí puedes agregar la lógica para registrar al usuario
          // Puedes hacer una petición a tu API para guardar los datos en la base de datos
          // o realizar cualquier acción necesaria
        } else {
          // El correo no es válido, muestra un mensaje de error o realiza alguna acción
        }
      },
      validarCorreo() {
        // Utiliza una expresión regular para validar el formato del correo
        const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
        this.correoValido = emailPattern.test(this.correo);
      },
    },
    components: {
      Mapa, // Registra el componente de formulario para su uso en la plantilla
    },
  };
  </script>
  
<style lang="sass" scoped>
.formulario
  min-width: 400px
  max-width: 600px
  min-height: 200px
</style>