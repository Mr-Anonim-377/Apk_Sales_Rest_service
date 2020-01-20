import Vue from 'vue'
import Router from 'vue-router'
import mainPageComponent from '@/components/routComponents/mainPageComponent'
Vue.use(Router)

export default new Router({
  routes: [
    {path: '/',
      name: 'mainPage',
      component: mainPageComponent},
    {path: '/r',
      name: 'mainPager',
      component: mainPageComponent}
  ]
})
