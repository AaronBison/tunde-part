import Vue from 'vue'
import Router from 'vue-router'
import RootUsers from '@/components/RootUsers'
import RootEvery from '@/components/RootEvery'
import Admin from '@/components/Admin'
import Model3d from '@/components/Model3d'
import Model3dE from '@/components/Model3d'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'RootEvery',
      component: RootEvery,
      children: [
        {
          path: '/model3de',
          name: 'Model3d',
          component: Model3dE
        },
      ]
    },
    {
      path: '/user',
      name: 'RootUsers',
      component: RootUsers,
      children: [
        {
          path: '/admin',
          name: 'Admin',
          component: Admin
        },
        {
          path: '/model3d',
          name: 'Model3d',
          component: Model3d
        },
      ]
    }
  ]
})
