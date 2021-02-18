import Vue from 'vue'
import VueRouter from 'vue-router'
import Shop from "@/views/Shop";
import Login from "@/views/Login";
import User from "@/views/User";
import Admin from "@/views/Admin";
import AccessDenied from "@/views/AccessDenied";
import ProductDetail from "@/views/ProductDetail";
import Buy from "@/views/Buy";
import Collection from "@/views/Collection";
import Cart from "@/views/Cart";
import MerchantShop from "@/views/MerchantShop";
import UserCare from "@/views/UserCare";
import UserBrowsingHistory from "@/views/UserBrowsingHistory";
import Merchant from "@/views/Merchant";
import AddProduct from "@/views/AddProduct";
import PublishMessage from "@/views/PublishMessage";
import MyCare from "@/views/MyCare";
import UserFriend from "@/views/UserFriend";
import Chat from "@/views/Chat";
import qqCallback from "@/views/qqCallback";
import qqtemp from "@/views/qqtemp";
import Search from "@/views/Search";


Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Index',
    redirect: {name: "Shop"}
  },
  {
    path: '/index',
    name: 'Index',
    redirect: {name: "Shop"}
  },
  {
    path: '/shop',
    name: 'Shop',
    component: Shop
  },
  {
    path: '/qqCallback',
    name: 'qqCallback',
    component: qqCallback
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/accessDenied',
    name: 'AccessDenied',
    component: AccessDenied
  },
  {
    path: '/user',
    name: 'UserCenter',
    component: User,
    meta: {
      requireAuth: true
    }
  },
  {
    path: '/buy/:BuyId',
    name: 'Buy',
    component: Buy,
    meta: {
      requireAuth: true
    }
  },

  {
    path: '/product/:ProductId',
    name: 'ProductDetail',
    component: ProductDetail
  },
  {
    path: '/admin',
    name: 'Admin',
    component: Admin,
    meta: {
      requireAuth: true
    }
  },
  {
    path: '/collection',
    name: 'Collection',
    component: Collection,
    meta: {
      requireAuth: true
    }
  },
  {
    path: '/cart',
    name: 'Cart',
    component: Cart,
    meta: {
      requireAuth: true
    }
  },
  {
    path: '/merchant_shop/:MerchantId',
    name: 'MerchantShop',
    component: MerchantShop,
    meta: {
      requireAuth: true
    }
  },
  {
    path: '/user_care',
    name: 'UserCare',
    component: UserCare,
    meta: {
      requireAuth: true
    }
  },
  {
    path: '/user_browsing_history',
    name: 'UserBrowsingHistory',
    component: UserBrowsingHistory,
    meta: {
      requireAuth: true
    }
  },
  {
    path: '/merchant',
    name: 'Merchant',
    component: Merchant,
    meta: {
      requireAuth: true
    }
  },
  {
    path: '/add_product',
    name: 'AddProduct',
    component: AddProduct,
    meta: {
      requireAuth: true
    }
  },

  {
    path: '/publish_message',
    name: 'PublishMessage',
    component: PublishMessage,
    meta: {
      requireAuth: true
    }
  },

  {
    path: '/my_care',
    name: 'MyCare',
    component: MyCare,
    meta: {
      requireAuth: true
    }
  },
  {
    path: '/user_friend',
    name: 'UserFriend',
    component: UserFriend,
    meta: {
      requireAuth: true
    }
  },
  {
    path: '/chat/:FriendId',
    name: 'Chat',
    component: Chat,
    meta: {
      requireAuth: true
    }
  },
  {
    path: '/qqtemp',
    name: 'qqtemp',
    component: qqtemp
  },

  {
    path: '/Search/:name',
    name: 'Search',
    component: Search,
  },


]


const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})


export default router
