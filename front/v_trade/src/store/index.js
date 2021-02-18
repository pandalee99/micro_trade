import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)
export default new Vuex.Store({
  state: {
    token: '',
    userInfo: JSON.parse(sessionStorage.getItem("userInfo"))
  },
  mutations: {
    //只能通过方法去修改state属性
    //形如set方法
    SET_TOKEN: (state, token) => {
      state.token=token
      localStorage.setItem("token",token)
    },
    SET_USERINFO: (state, userInfo) => {
      state.userInfo=userInfo
      // localStorage.setItem("userInfo",userInfo)
      sessionStorage.setItem("userInfo",JSON.stringify(userInfo))
      // localStorage.setItem("userInfo",JSON.parse(sessionStorage.getItem("userInfo")))
      // localStorage.setItem("user",userInfo)
    },


    REMOVE_INFO:(state) => {
      state.token=''
      state.userInfo=''
      localStorage.setItem("token",'')
      sessionStorage.setItem("userInfo",JSON.stringify(''))
    }
  },
  getters:{
    //get方法
    getUser: state => {
      return state.userInfo
    },
    getmyToken: state => {
      console.log(state)
      return ""
    }
  },

  actions: {
  },
  modules: {
  }
})
