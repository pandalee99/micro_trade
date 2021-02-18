import router from "./router";
import store from './store'
// 路由判断登录 根据路由配置文件的参数
router.beforeEach((to, from, next) => {
    if (to.matched.some(record => record.meta.requireAuth)) { // 判断该路由是否需要登录权限

        const token = localStorage.getItem("token")

        // console.log(localStorage.getItem("userInfo"))
        if (sessionStorage.getItem("userInfo")==null){
            store.commit("REMOVE_INFO")
            next({
                path: '/login'
            })
            // console.log("清空")
        }else {

            // console.log("Permission——token:" + token)
        }

        if (token) { // 判断当前的token是否存在 ；登录存入的token
            // eslint-disable-next-line no-empty
            if (to.path === '/login') {
            } else {
                next()
            }
        } else {
            next({
                path: '/login'
            })
        }
    } else {
        next()
    }
})

