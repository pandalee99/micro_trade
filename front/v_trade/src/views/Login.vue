<template>

    <div>
<!--		<div><span id="qqLoginBtn"></span></div>-->
        <el-container>
            <el-header>
                <img class="mylogo" src="https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3563879038,322783869&fm=26&gp=0.jpg">
            </el-header>
            <el-main>
                <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                    <el-form-item label="用户名" prop="username">
                        <el-input v-model="ruleForm.username"></el-input>
                    </el-form-item>
                    <el-form-item label="密码" prop="password">
                        <el-input type="password" v-model="ruleForm.password"></el-input>
                    </el-form-item>

<!--                    <el-form-item>-->
<!--                        <el-tooltip class="item" effect="dark" content="QQ一键登录" placement="top-start">-->
<!--                            <el-button round @click="doQQLogin()">QQ登录</el-button>-->
<!--                        </el-tooltip>-->
<!--                    </el-form-item>-->
                    <el-form-item>
                        <el-tooltip class="item" effect="dark" content="QQ一键登录" placement="top-start">
<!--                            <el-button round @click="doQQLogin()">QQ登录</el-button>-->
                            <el-button round @click="useqqlogin()">QQ登录</el-button>
                        </el-tooltip>
<!--                     <div>   <span id="qqLoginBtn"></span></div>-->
                        <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
                        <el-button @click="resetForm('ruleForm')">重置</el-button>
                    </el-form-item>
                </el-form>
            </el-main>
        </el-container>
    </div>
	
	
</template>

<script>




    export default {
        name: "Login",
        data() {
            return {
                ruleForm: {
                    username: 'test',
                    password: '123456'
                },
                timer: '',
                rules: {
                    username: [
                        { required: true, message: '请输入用户名', trigger: 'blur' },
                        { min: 1, max: 20, message: '长度在 1 到 20 个字符', trigger: 'blur' }
                    ],
                    password: [
                        { required: true, message: '请输入密码', trigger: 'change' }
                    ]
                },
                timeout: 2000,
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
                    money:0,
                    bankCard:0,
                    description:"str",
                    coupon:0,

                },
            };
        },
        created(){

        },
        mounted(){
            this.timer = setInterval(this.if_qq_login, this.timeout);
        },
        beforeDestroy() {
            clearInterval(this.timer);
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        const _this=this //预存

                        // alert('submit!');
                        this.$axios.post('/login',this.ruleForm).then(
                            //此处发起axios的post请求，对应后端的/login 路径、
                            // 实体类型为this.ruleForm，也就是我们的表单实体，
                            // 然后，使用then，将其后端返回的验证型 的json消息，进行获取
                            // json数据被返回到了res里面，。
                            res =>{
                                console.log(res.data.data)

                                if (res.data.data=="错误"){
                                    this.$message({
                                        message: '账号名称或密码错误 ',
                                        duration: 2000,
                                    })
                                    return null
                                }
                                const jwt=res.headers['authorization']
                                const userInfo=res.data.data



                                //把登录时候获取到的数据共享出去，
                                // 以便于其他页面能够有权限访问，不至于每次都要登录
                                _this.$store.commit("SET_TOKEN",jwt)
                                _this.$store.commit("SET_USERINFO",userInfo)
                                // localStorage.setItem("userInfo",JSON.stringify(userInfo))

                                //获取信息
                                console.log(_this.$store.getters.getUser)
                                // console.log(userInfo)
                                //页面跳转功能
                                if (userInfo.roles=="ROLE_USER"){
                                _this.$router.push("/shop")}
                                else {_this.$router.push("/admin")}

                            }
                        )
                    }
                    else {
                        console.log('错误提交!!');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
            doQQLogin(){
                window.location.href=
                    "https://graph.qq.com/oauth2.0/show?which=Login&display=pc&response_type=code&client_id=101881248&redirect_uri=http://www.sodse.com/qqtemp&state=ok"
                    // https://graph.qq.com/oauth2.0/authorize?response_type=code&client_id=101881248&redirect_uri=http://www.sodse.com/shop&state=ok
                // this.getqqLoginInfo().then((res) => {
                //     console.log(res)
                //     window.location.href =
                //         "https://graph.qq.com/oauth2.0/show?which=Login&display=pc&response_type=code&client_id=101881248&redirect_uri=http://www.sodse.com/qqCallback&state=ok";
                // });
            },
            // getqqLoginInfo() {
            //     return request({
            //         url: '/oauth2/qq/info',
            //         method: 'get'
            //     })
            // },
            useqqlogin(){//点击QQ登录
                // eslint-disable-next-line no-undef
                QC.Login.showPopup({//打开QQ授权登录界面，授权成功后会重定向
                    appId:"101881248",
                    redirectURI:"http://www.sodse.com/qqtemp" //登录成功后会自动跳往该地址
                    // redirectURI:"http://www.sodse.com/qqtemp/dist/index.html#/qq_login?redirect=http://www.sodse.com/login"
                });




            },
            qqOut () {
                // eslint-disable-next-line no-undef
                QC.Login.signOut()
                console.log("qq已经退出登录")
            },
            if_qq_login(){
                // eslint-disable-next-line no-undef
                if (QC.Login.check()) {//检查是否登录
                    // console.log("qq已经登录");
                    // this.add_qq_user()
                    console.log("QQ已经登录");
                    const _this=this
                    // eslint-disable-next-line no-undef,no-unused-vars
                    QC.Login.getMe(function(openId, accessToken) {
                        console.log(openId)
                        console.log(accessToken)
                        // eslint-disable-next-line no-undef
                        console.log(QC.api('get_user_info'))
                        var paras = {};
                        // eslint-disable-next-line no-undef
                        QC.api('get_user_info', paras)
                            // 指定接口访问成功的接收函数，s为成功返回Response对象
                            .success(function (s) {
                                // 成功回调，通过s.data获取OpenAPI的返回数据
                                // console.log('--------console.log(s.data)---------------')
                                // console.log(s)
                                // console.log(s.data)
                                // console.log(s.data.nickname)
                                // console.log('------console.log(s.data)-------')
                                _this.user.username=s.data.nickname
                                _this.user.userNickname=s.data.nickname
                                _this.user.userImg=s.data.figureurl_qq
                                _this.user.sex=s.data.gender
                                _this.user.password="123456"
                                console.log(_this.user)
                                //后端测试：
                                _this.$axios.post('/register',_this.user).then(res => {
                                    console.log(res)


                                    const jwt=res.headers['authorization']
                                    const userInfo=res.data.data



                                    //把登录时候获取到的数据共享出去，
                                    // 以便于其他页面能够有权限访问，不至于每次都要登录
                                    _this.$store.commit("SET_TOKEN",jwt)
                                    _this.$store.commit("SET_USERINFO",userInfo)

                                    //获取信息
                                    console.log(_this.$store.getters.getUser)
                                    // console.log(userInfo)
                                    //页面跳转功能
                                    if (userInfo.roles=="ROLE_USER"){
                                        _this.$router.push("/shop")}
                                    else {_this.$router.push("/admin")}


                                })

                                //{
                                // 	"username": "postman1",
                                // 	"userNickname": "postman1",
                                // 	"userImg": "postman",
                                // 	"sex": "男"
                                //
                                // }


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
                else {
                    console.log("QQ没有登录")
                }
            },
            add_qq_user(){
                const _this=this
                // eslint-disable-next-line no-undef
                if (QC.Login.check()) {//检查是否登录
                    console.log("已经登录");
                    // eslint-disable-next-line no-undef,no-unused-vars
                    QC.Login.getMe(function(openId, accessToken) {
                        console.log(openId)
                        console.log(accessToken)
                        // eslint-disable-next-line no-undef
                        console.log(QC.api('get_user_info'))
                        var paras = {};
                        // eslint-disable-next-line no-undef
                        QC.api('get_user_info', paras)
                            // 指定接口访问成功的接收函数，s为成功返回Response对象
                            .success(function (s) {
                                // 成功回调，通过s.data获取OpenAPI的返回数据
                                console.log('--------console.log(s.data)---------------')
                                console.log(s)
                                console.log(s.data)
                                console.log(s.data.nickname)
                                console.log('------console.log(s.data)-------')

                                _this.user.username=s.data.nikename
                                _this.user.userImg=s.data.figureurl_qq
                                _this.user.sex=s.data.gender

                                console.log(_this.user)
                                //后端测试：
                                // eslint-disable-next-line no-unused-vars
                                this.$axios.get("/products?currentPage=" + 1).then(res => {
                                    console.log(res)
                                    this.$router.push("/shop")
                                    this.timeout=1000
                                })

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
            }

        },


    }
</script>

<style scoped>
    .el-header, .el-footer {
        background-color: #B3C0D1;
        color: #333;
        text-align: center;
        line-height: 60px;
    }

    .el-aside {
        background-color: #D3DCE6;
        color: #333;
        text-align: center;
        line-height: 200px;
    }

    .el-main {
        /*background-color: #E9EEF3;*/
        color: #333;
        text-align: center;
        line-height: 160px;
    }

    body > .el-container {
        margin-bottom: 40px;
    }

    .el-container:nth-child(5) .el-aside,
    .el-container:nth-child(6) .el-aside {
        line-height: 260px;
    }

    .el-container:nth-child(7) .el-aside {
        line-height: 320px;
    }

    .mylogo{
        height: 80%;
        margin-top: 10px;
    }

    .demo-ruleForm{
        max-width: 500px;
        margin: 0 auto;
    }
</style>