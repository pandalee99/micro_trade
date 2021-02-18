<template>
    <div></div>
</template>

<script>
    export default {
        name: "qqtemp",
        data(){
            return{
                user:{
                    id:0,
                    username:"str",
                    password:"str",
                    sex:"str",
                    idCard:0,
                    idImg:"str",
                    flag:0,
                    level:0,
                    userNickname:"str",
                    userImg:"str",
                    roles:"str",
                    money:"BigDecimal",
                    bankCard:0,
                    description:"str",
                    coupon:0,

                },
            }
        },
        created(){
            this.login_after()

        },
        methods:{
            login_after(){
                // const _this=this
                // eslint-disable-next-line no-undef
                if (QC.Login.check()) {//检查是否登录
                    console.log("已经登录");
                    // eslint-disable-next-line no-undef,no-unused-vars
                    QC.Login.getMe(function(openId, accessToken) {
                        // console.log(openId)
                        // console.log(accessToken)
                        // eslint-disable-next-line no-undef
                        console.log(QC.api('get_user_info'))
                        var paras = {};
                        // eslint-disable-next-line no-undef
                        QC.api('get_user_info', paras)
                            // 指定接口访问成功的接收函数，s为成功返回Response对象
                            .success(function (s) {
                                // 成功回调，通过s.data获取OpenAPI的返回数据
                                console.log('qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq')
                                console.log(s)
                                // console.log(s.data)
                                // console.log(s.data.nickname)


                                //后端测试：
                                // eslint-disable-next-line no-unused-vars
                                // _this.$axios.get('/qq').then(res => {})
                                //我把调用成功的返回数据打印到控制台，可以把这些参数发请求到后台，存入数据库
                                // this.$axios.post('/qq_register_and_login', _this.user).then(res => {
                                //
                                //     console.log(res)
                                //     const jwt=res.headers['authorization']
                                //     const userInfo=res.data.data
                                //     //把登录时候获取到的数据共享出去，
                                //     // 以便于其他页面能够有权限访问，不至于每次都要登录
                                //     this.$store.commit("SET_TOKEN",jwt)
                                //     this.$store.commit("SET_USERINFO",userInfo)
                                //     //获取信息
                                //     console.log(this.$store.getters.getUser)
                                //     // console.log(userInfo)
                                //     //页面跳转功能
                                //     if (userInfo.roles=="ROLE_USER"){
                                //         this.$router.push("/shop")}
                                //     else {this.$router.push("/admin")}
                                //
                                //
                                // })
                            })
                            // 指定接口访问失败的接收函数，f为失败返回Response对象
                            // eslint-disable-next-line no-unused-vars
                            .error(function (f) {
                                // 失败回调
                                alert('获取用户信息失败！')
                            })
                    })
                }
            },


            use_url_qq_login(){
                const id=this.$route.query.code

                console.log(id)
                this.$axios.get("https://graph.qq.com/oauth2.0/" +
                    "show?which=Login&grant_type=authorization_code" +
                    "&client_id=101881248" +
                    "&client_secret=05f580147001f9e5b20867c378d433e6" +
                    "&code=" +
                    id +
                    "&redirect_uri=http://www.sodse.com/qqtemp&state=ok" +
                    "&fmt=json"
                ).then(res=> {
                    console.log(res)

                })
            }
        }
    }
</script>

<style scoped>

</style>