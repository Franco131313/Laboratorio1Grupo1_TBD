<template>
    <div>
      <!-- Otro contenido de la página de registro -->
      <RegistroForm /> <!-- Agrega el formulario de registro como un componente -->
    </div>
  </template>
  
  <script>
  import RegistroForm from 'components/RegistroForm.vue'; // Asegúrate de importar el formulario de registro
  
  export default {
    components: {
      RegistroForm, // Registra el componente de formulario para su uso en la plantilla
    },
    // Otras opciones y lógica para la página de registro
  };
  </script>
  