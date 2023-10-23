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
          type="nombre"
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
            <q-input
            v-model.number="model"
            type="number"
            filled
            style="max-width: 200px"
          />
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
    created() {
    this.getGeolocation();
  },
    setup () {
    return {
      model: ref(null),
    }
  },
    data() {
      return {
        nombre: '',
        correo: '',
        contrasenia: '',
        //ubicacion: '',
        correoValido: true, // Variable para almacenar si el correo es válido
        voluntarioSelected: false,
        coordinadorSelected: false,
        rol: '',
        coordinates: {
          lat: 0,
          lng: 0
        },
        idUsuario: null,
        idVoluntario: null,
      };
    },
    methods: {
      getGeolocation() {
      if ("geolocation" in navigator) {
        navigator.geolocation.getCurrentPosition((position) => {
          this.coordinates.lat = position.coords.latitude;
          this.coordinates.lng = position.coords.longitude;
        });
      } else {
        alert("Geolocalización no es compatible en este navegador.");
      }
    },
    registrarUsuario() {
  if (!this.nombre || !this.correo || !this.contrasenia) {
    alert('Por favor, completa todos los campos.');
    return;
  } else {
    if (!this.correoValido) {
      alert('Escribe un correo con formato válido');
      return;
    } else {
      // Obtener las coordenadas de latitud y longitud
      const latitud = this.coordinates.lat;
      const longitud = this.coordinates.lng;

      const usuarioData = {
        email: this.correo,
        password: this.contrasenia,
        rol: this.voluntarioSelected ? 'voluntario' : 'coordinador',
      };

      if (this.voluntarioSelected) {
        const voluntarioData = {
          nombre: this.nombre,
          latitud: latitud, // Agregar latitud
          longitud: longitud, // Agregar longitud
        };

        // Agrega voluntarioData a usuarioData
        usuarioData.voluntarioData = voluntarioData;
      }

      // Realiza una solicitud POST al backend para registrar al usuario
      axios
        .post('http://localhost:8082/api/usuarios/agregar-usuario', usuarioData)
        .then((response) => {
          // La solicitud fue exitosa, muestra un mensaje de éxito
          const get1 = "http://localhost:8082/api/usuarios/buscar?email=";
          const get2 = this.correo;
          const get3 = get1 + get2;
          axios
            .get(get3)
            .then((response) => {
              // Almacena el ID de usuario en la variable 'idUsuario'
              this.idUsuario = response.data.id_USUARIO;

              if (this.voluntarioSelected) { // Verifica si es voluntario
                const voluntarioData = {
                  nombre: this.nombre,
                  latitud: latitud, // Agregar latitud
                  longitud: longitud, // Agregar longitud
                };
                const link1 = "http://localhost:8082/api/voluntario/nuevo-voluntario?id=";
                const link2 = this.idUsuario;
                const link = link1 + link2;
                // Realiza una solicitud POST para crear al voluntario
                axios
                  .post(link, voluntarioData)
                  .then((voluntarioResponse) => {
                    const get4 = "http://localhost:8082/api/voluntario/buscar?nombre=";
                    const get5 = this.nombre;
                    const get6 = get4 + get5;
                    axios
                      .get(get6)
                      .then((response) => {
                        this.idVoluntario = response.data.id_VOLUNTARIO;
                        const enlace1 = "http://localhost:8082/api/volHabilidad/nueva-vol-habilidad?idVol=";
                    const enlace2 = "&idHab=";
                    const enlace3 =  enlace1 + this.idUsuario + enlace2 + this.model;
                    axios
                      .post(enlace3)
                      .then((response) => {
                      alert('Usuario registrado exitosamente');
                    // También puedes redirigir al usuario a otra página
                    this.$router.push('/');
                    });
                      });
                  })
                  .catch((voluntarioError) => {
                    // La solicitud al backend para crear el voluntario falló
                    alert('Error al registrar al voluntario. Inténtalo de nuevo.');
                    console.error(voluntarioError);
                  });
              }
            });
            
        })
        .catch((error) => {
          // La solicitud al backend para registrar al usuario falló
          alert('Error al registrar al usuario. Inténtalo de nuevo.');
          console.error(error);
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