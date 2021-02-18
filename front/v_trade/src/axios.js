import axios from 'axios'
import Element from 'element-ui'
import router from './router'
import store from './store'


//默认路径
axios.defaults.baseURL="http://localhost:8001"

//服务器路径
// axios.defaults.baseURL="http://sodse.com:8001"


//前置拦截
axios.interceptors.request.use(config=>{
    return config
})
//返回拦截到的信息
axios.interceptors.response.use(response=>{
    let res = response.data;

    // console.log("=======")
    console.log(res)


    if (res.code===200){
        return response
    }else {
        Element.Message.error('密码错误了',{duration:2*1000});
    }

    //阻止进入后面的逻辑
    return Promise.reject(response.data.msg)
},
    //用户名不存在
    error=>{
    console.log(error)
        // 如果返回头有数据
        if (error.response.data){
            error.message=error.response.data.msg


        }
        // 调用store的index.js方法使用remove将其清空
        if (error.response.status===401){
            store.commit("REMOVE_INFO")
            router.push("/login")
        }
        // if (error.response.status===400){
        //     store.commit("REMOVE_INFO")
        //     router.push("/login")
        // }

        Element.Message.error(error.message,{duration:2*1000});
        //阻止返回
        return Promise.reject(error)
    }
)