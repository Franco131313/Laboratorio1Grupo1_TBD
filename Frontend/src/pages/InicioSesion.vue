<template>
    <div>
      <!-- Otro contenido de la página de registro -->
      <LoginForm /> <!-- Agrega el formulario de registro como un componente -->
    </div>
  </template>
  
  <script>
  import LoginForm from 'components/LoginForm.vue'; // Asegúrate de importar el formulario de registro
  
  export default {
    components: {
      LoginForm, // Registra el componente de formulario para su uso en la plantilla
    },
    // Otras opciones y lógica para la página de registro
  };
  </script>
  