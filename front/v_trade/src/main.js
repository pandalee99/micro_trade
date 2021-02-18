import Vue from 'vue'
import App from './App.vue'
import store from './store'
import router from './router'
//element-ui
import Element from 'element-ui'
import "element-ui/lib/theme-chalk/index.css"
//axios
import axios from 'axios'
import "./permission"
import "./axios"
import "./components/global"







Vue.use(Element)


Vue.prototype.$axios = axios
Vue.config.productionTip = false




new Vue({
  store,
  router,
  render: h => h(App)
}).$mount('#app')
