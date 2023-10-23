<template>
    <q-page>
      <q-card class="formulario fixed-center">
        <q-card-section>
          <div class="text-h5 text-center">Registro de Usuario</div>
        </q-card-section>
  
        <q-card-section>
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
          <q-select v-model="model" :options="optionsIns" label="Elegir institucion" />
          </q-card-section>
        <!-- q-card-section>
          <Mapa />
        </!-->
        <q-card-section>
          <q-checkbox
          v-model="voluntarioSelected"
          label="Registrarse como voluntario"
          @input="onCheckboxChange('voluntario')"
        />
        
        <!-- Casilla de verificación para registrarse como coordinador -->
        <q-checkbox
          v-model="coordinadorSelected"
          label="Registrarse como coordinador"
          @input="onCheckboxChange('coordinador')"
        />
    
        <!-- Componente adicional: lista desplegable -->
        <div v-if="voluntarioSelected">
          <q-card-section>
            <q-select v-model="model" :options="optionsHab" label="Elegir Habilidad" />
          </q-card-section>
        </div>
        </q-card-section>
        <q-card-actions align="right">
          <q-btn
            color="primary"
            label="Registrarse"
            @click="registrarUsuario"
          />
        </q-card-actions>
        <q-card-section align="right">
          <router-link to="/">Volver al Inicio</router-link>
        </q-card-section>
      </q-card>
    </q-page>
  </template>
  
  <script>
  import { ref } from 'vue'
  import axios from 'axios';
  
  export default {
    setup () {
    return {
      model: ref(null),
      optionsHab: [
        'Habilidad 1', 'Habilidad 2', 'Habilidad 3', 'Habilidad 4', 'Habilidad 5'
      ],
      optionsIns: [
        'Institucion 1', 'Institucion 2', 'Institucion 3'
      ]
    }
  },
    data() {
      return {
        correo: '',
        contrasenia: '',
        //ubicacion: '',
        correoValido: true, // Variable para almacenar si el correo es válido
        voluntarioSelected: false,
        coordinadorSelected: false,
        rol: '',
      };
    },
    methods: {
      registrarUsuario() {
        if (!this.correo || !this.contrasenia) {
          alert('Por favor, completa todos los campos.');
          return; // Detiene la función si los campos están vacíos
        } else {
          if (!this.correoValido){
            alert('Escribe un correo con formato válido');
            return;
          //} else if(!this.ubicacion){
            //alert('Por favor, permite recibir la ubicacioón');
          } else {
            const usuarioData = {
              email: this.correo,
              password: this.contrasenia,
              rol: this.voluntarioSelected ? 'voluntario' : 'coordinador',
            };

            // Realiza una solicitud POST al backend para registrar al usuario
            axios
              .post('http://localhost:8080/api/usuarios/agregar-usuario', usuarioData)
              .then((response) => {
                // La solicitud fue exitosa, muestra un mensaje de éxito
                alert('Usuario registrado exitosamente');
                // También puedes redirigir al usuario a otra página, por ejemplo, la página de inicio de sesión
                this.$router.push('/');
              })
              .catch((error) => {
                // La solicitud al backend falló, muestra un mensaje de error
                alert('Error al registrar al usuario. Inténtalo de nuevo.');
                console.error(error); // Muestra información detallada del error en la consola
              });
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
      onItemClick() {
        console.log('Clicked on an Item');
      },
      onCheckboxChange(selected) {
        if (selected === 'voluntario') {
          this.coordinadorSelected = false; // Desmarca la casilla de coordinador
        } else if (selected === 'coordinador') {
          this.voluntarioSelected = false; // Desmarca la casilla de voluntario
        }
      },
    },
  };
  </script>
  
<style lang="sass" scoped>
.formulario
  min-width: 400px
  max-width: 600px
  min-height: 200px
</style>