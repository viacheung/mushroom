import { createRouter, createWebHashHistory } from 'vue-router'
import Layout from '../layout/Layout.vue'
import AdminLayout from '../components/admin/layout/Layout'

const routes = [
  { path: '/Login', component: () => import('../views/Login/Login'), hidden: true },

  {
    path: '/',
    name: 'Home',
    component: Layout,
    redirect: '/Index',
    children: [
        {
            path: '/Index',
            component: () => import(/* webpackChunkName: "about" */ '../views/Index/Index')
        },
        {
            path: '/BiShe',
            component: () => import(/* webpackChunkName: "about" */ '../views/BiShe/BiShe_index')
        },
        {
            path: '/BiShe/details',
            component: () => import(/* webpackChunkName: "about" */ '../views/BiShe/BiShe_details')
        },
        {
            path: '/KaiFaGongJu',
            component: () => import(/* webpackChunkName: "about" */ '../views/KaiFaGongJu/KaiFaGongJu_index')
        },
        {
            path: '/XueXiXianLu',
            component: () => import(/* webpackChunkName: "about" */ '../views/XueXiXianLu/XueXiXianLu_index')
        },
        {
            path: '/Blog',
            component: () => import(/* webpackChunkName: "about" */ '../views/Blog/Blog_index')
        },

        {
            path: '/MoYuShiKe',
            component: () => import(/* webpackChunkName: "about" */ '../views/MoYuShiKe/MoYuShiKe_index')
        },
        {
            path: '/ZhouBian',
            component: () => import(/* webpackChunkName: "about" */ '../views/ZhouBian/ZhouBian')
        },
        {
            path: '/ZhouBianDetail',
            component: () => import(/* webpackChunkName: "about" */ '../views/ZhouBian/ZhouBian_detail')
        },
        {
            path: '/Order',
            component: () => import(/* webpackChunkName: "about" */ '../views/Order/Order')
        },
    ]
  },

  {
    path: '/admin',
    name: 'admin',
    component: AdminLayout,
    redirect: '/admin',
    children: [
      {
        path: '/admin',
        component: () => import(/* webpackChunkName: "about" */ '../components/admin/index/Index.vue')
      },
      {
        path: '/admin/itemsList',
        component: () => import(/* webpackChunkName: "about" */ '../components/admin/items/List.vue')
      },
      {
        path: '/admin/itemsForm',
        component: () => import(/* webpackChunkName: "about" */ '../components/admin/items/Form.vue')
      },
      {
        path: '/admin/categoryList',
        component: () => import(/* webpackChunkName: "about" */ '../components/admin/category/List.vue')
      },
      {
        path: '/admin/categoryForm',
        component: () => import(/* webpackChunkName: "about" */ '../components/admin/category/Form.vue')
      },
        {
            path: '/admin/userList',
            component: () => import(/* webpackChunkName: "about" */ '../components/admin/user/List.vue')
        },
        {
            path: '/admin/userForm',
            component: () => import(/* webpackChunkName: "about" */ '../components/admin/user/Form.vue')
        },
        {
            path: '/admin/ZhouBianForm',
            component: () => import(/* webpackChunkName: "about" */ '../components/admin/zhoubian/Form.vue')
        },
        {
            path: '/admin/ZhouBianList',
            component: () => import(/* webpackChunkName: "about" */ '../components/admin/zhoubian/List.vue')
        },
        {
            path: '/admin/OrderList',
            component: () => import(/* webpackChunkName: "about" */ '../components/admin/order/List.vue')
        }
    ]
  },



  {
    path: '/about',
    name: 'About',
    component: Layout,
    children: [{
      path: 'about',
      component: () => import(/* webpackChunkName: "about" */ '../views/Index/Index.vue')
    }]
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
   /* component: () => import(/!* webpackChunkName: "about" *!/ '../views/About.vue')*/
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
