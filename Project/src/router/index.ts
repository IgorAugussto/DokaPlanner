import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '../views/LoginView.vue'
import LoginRegister from '@/views/LoginRegister.vue'
import VisitorRegister from '@/views/VisitorRegister.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'login',
      component: LoginView, // 👈 Cadastro de visitante
    },
    {
      path: '/home',
      name: 'home',
      component: VisitorRegister,  // 👈 Adiciona a rota da tela de login
    },
    {
      path: '/register',
      name: 'register',
      component: LoginRegister // 👈 Cadastro de usuáiro
    },
    {
    path:'/visitor',
    name: 'visitor',
    component: VisitorRegister // 👈 Cadastro de visitante
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue'),
    },
  ],
})

router.beforeEach((to, from, next) => {
  const token = localStorage.getItem('token')

  if (to.meta.requiresAuth && !token) {
    next({ name: 'login' }) // redireciona se não estiver autenticado
  } else {
    next()
  }
})


export default router
