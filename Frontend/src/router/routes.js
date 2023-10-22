
import Registro from 'pages/Registro.vue';
import InicioSesion from 'pages/InicioSesion.vue';

const routes = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('pages/Index.vue') }
    ]
  },
  {
    path: '/registro',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('components/RegistroForm.vue') },
    ]
  },
  {
    path: '/inicio-sesion',
    component: InicioSesion,
    name: 'inicio-sesion',
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: '*',
    component: () => import('pages/Error404.vue')
  }
]

export default routes
