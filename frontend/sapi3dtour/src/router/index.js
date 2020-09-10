import Vue from 'vue'
import Router from 'vue-router'
import RootUsers from '@/components/RootUsers'
import RootEvery from '@/components/RootEvery'
import Admin from '@/components/Admin'
import Model3d from '@/components/Model3d'
import Password from '@/components/Password'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'RootEvery',
      component: RootEvery,
      children: [
        { path: '', redirect: { name: 'Model3d' } },
        {
          path: '/model3d',
          name: 'Model3d',
          component: Model3d
        },
      ]
    },
    {
      path: '/user',
      name: 'RootUsers',
      component: RootUsers,
      children: [
        {
          path: '/user/admin',
          name: 'Admin',
          component: Admin
        },
        {
          path: '/user/model3d',
          name: 'Model3d1',
          component: Model3d
        },
      ]
    },
    {
      path: '/password',
      name: 'Jelszó',
      component: Password
    },
  ]
})
