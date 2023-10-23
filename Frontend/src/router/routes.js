
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
      { path: '', component: () => import('pages/Registro.vue') },
    ]
  },
  {
    path: '/inicio-sesion',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('pages/InicioSesion.vue') },
    ]
  },
  {
    path: '/coordinadores',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('pages/Coordinador.vue') },
    ]
  },
  {
   path: '/coordinadores/emergencia-create',
    component: () => import('layouts/MainLayout.vue'),
    children: [
    { path: '', component: () => import('pages/EmergenciaCreate.vue'),},
    ],
  },
  {
    path: '/coordinadores/emergencia-list',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      {
        path: '',
        component: () => import('pages/EmergenciaList.vue'),
      },
    ],
  },
  {
    path: '/coordinadores/emergencia/:id',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      {
        path: '',
        component: () => import('pages/EmergenciaDetails.vue'),
      },
    ],
  },  
  // Always leave this as last one,
  // but you can also remove it
  {
    path: '*',
    component: () => import('pages/Error404.vue')
  }
]

export default routes
