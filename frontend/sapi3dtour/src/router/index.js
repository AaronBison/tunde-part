import Vue from 'vue'
import Router from 'vue-router'
import RootUsers from '@/components/RootUsers'
import RootEvery from '@/components/RootEvery'
import Admin from '@/components/Admin'
import Valami from '@/components/Valami'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'RootUsers',
      component: RootUsers,
      children: [
        {
          path: '/admin',
          name: 'Admin',
          component: Admin
        },
        {
          path: '/valami',
          name: 'Valami',
          component: Valami
        },
      ]
    },
    {
      path: '/every',
      name: 'RootEvery',
      component: RootEvery,
      children: [
        {
          path: '/every/valami',
          name: 'Valami',
          component: Valami
        }
      ]
    }
  ]
})
