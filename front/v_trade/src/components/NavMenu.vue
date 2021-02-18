<template>
    <div class="size">
        <el-menu
                :default-active="activeIndex2"
                class="el-menu-demo"
                mode="horizontal"
                @select="handleSelect"
                background-color="#545c64"
                text-color="#fff"
                active-text-color="#ffd04b"
        >
<!--            <el-link href="/blogs">商城首页？？</el-link>   -->
            <el-link href="/shop"><el-menu-item index="1">首 页</el-menu-item></el-link>

                <el-link href="/my_care"><el-menu-item index="2">
                <a target="_blank">我的关注</a>
            </el-menu-item></el-link>


            <el-link @click="openSearch">
            <el-menu-item index="2">
                <a target="_blank" >搜索商品</a>
            </el-menu-item></el-link>


            <el-link href="/user_friend">
                <el-menu-item index="2">
                    <a target="_blank">我的好友</a>
                </el-menu-item></el-link>
            <el-link href="/cart">
                <el-menu-item index="2">
                    <a target="_blank">我的购物车</a>
                </el-menu-item></el-link>



            <el-link href="/user">
            <el-menu-item index="2">
                <a target="_blank">用户中心</a>
            </el-menu-item></el-link>

            <el-link v-show="auth" href="/merchant">
                <el-menu-item index="2">
                    <a target="_blank">我是商家</a>
                </el-menu-item></el-link>
            <el-link  v-show="logined">
            <el-menu-item index="2">
                <a target="_blank" @click="qqOut">退出登录</a>
            </el-menu-item></el-link>
            <el-link  v-show="!logined">
                <el-menu-item index="2">
                    <a target="_blank" @click="tologin">需要登录</a>
                </el-menu-item></el-link>

            <el-drawer
                    title="我是标题"
                    :visible.sync="drawer"
                    :with-header="false"
            direction="ttb">
                <div class="inputStyle">
                <el-autocomplete
                        v-model="state"
                        :fetch-suggestions="querySearchAsync"
                        placeholder="请输入内容"
                        @select="handleSelect"
                ></el-autocomplete>
                </div>
                <div class="search_btn">
                <el-button type="success"  @click="search_product">搜索</el-button></div>
            </el-drawer>

<!--            <el-submenu index="2">-->
<!--                <template slot="title">我的工作台</template>-->
<!--                <el-menu-item index="2-1">选项1</el-menu-item>-->
<!--                <el-menu-item index="2-2">选项2</el-menu-item>-->
<!--                <el-menu-item index="2-3">选项3</el-menu-item>-->
<!--                <el-submenu index="2-4">-->
<!--                    <template slot="title">选项4</template>-->
<!--                    <el-menu-item index="2-4-1">选项1</el-menu-item>-->
<!--                    <el-menu-item index="2-4-2">选项2</el-menu-item>-->
<!--                    <el-menu-item index="2-4-3">选项3</el-menu-item>-->
<!--                </el-submenu>-->
<!--            </el-submenu>-->
            <el-link type="primary" href="/login" class="class-name">
            <el-avatar v-show="!hasLogin"
                    shape="square"
                    :size="50"
                    :src="user.avatar"
                    class="class-name">
<!--                    @click="onEventClick"-->
            </el-avatar>
            </el-link>
            <el-link type="primary" @click="logout" class="class-name">
            <el-avatar v-show="hasLogin"
                       shape="square"
                       :size="50"
                       :src="user.avatar"
                       >
                <!--                    @click="onEventClick"-->

            </el-avatar>
            </el-link>
        </el-menu>

    </div >
</template>

<script>
    export default {
        props: [],
        components: {},
        data() {
            return {
                // 在此自动生成
                activeIndex2:"1",
                squareUrl:"https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png",
                user:{
                    username:'未登录',
                    avatar: 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png',
                    role: "normal",
                    userImg:"",
                    address:"",
                    level:"1",

                },
                auth:false,
                hasLogin:false,
                logined:false,
                drawer:false,
                restaurants: [],
                state: '',
                timeout:  null

            };
        },
        watch: {},
        computed: {},
        created() {
            // const _this=this

            // localStorage.getItem("userInfo")
            // console.log(localStorage.getItem("userInfo"))
            // console.log(JSON.stringify(localStorage.getItem("user")))
            if (this.$store.getters.getUser.username){
            this.user.username=this.$store.getters.getUser.username
            this.user.avatar=this.$store.getters.getUser.userImg
            this.user.role=this.$store.getters.getUser.roles
                this.user.level=this.$store.getters.getUser.level
                this.logined=true

            // console.log(this.user.role)

            this.hasLogin=true
        }
            // console.log(this.user)
            if (this.user.level=="2"){this.auth=true}
            },

        mounted() {
            this.restaurants = this.loadAll();
        },
        methods: {
            tologin(){
                const _this=this
                // eslint-disable-next-line no-undef
                QC.Login.signOut()
                _this.$router.push("/login")
            },
            qqOut () {
                const _this=this
                // eslint-disable-next-line no-undef
                QC.Login.signOut()
                console.log("qq已经退出登录")
                _this.$store.commit("REMOVE_INFO")
                _this.$router.push("/login")
            },
            // 在此自动生成
            request() {
                // 网络请求，可选
            },

            logout(){
                const  _this=this
                // _this.$axios.get("/qq").then((response) => {
                //     // then 指成功之后的回调 (注意：使用箭头函数，可以不考虑this指向)
                //     console.log(response);
                // })

//其实只需要清空本地的token即可了
//                 _this.$store.commit("REMOVE_INFO")
                _this.$router.push("/login")
            },
            // onEventClick(){
            //     const  _this=this
            //     if (user.username==='未登录'){
            //         _this.$router.push("/login")
            //     }
            // }
            openSearch(){
                this.drawer=true
            },
            search_product(){
                const _this=this
                if (_this.state==''){
                    this.$message({
                        message: '输入框为空 ',
                        duration: 2000,
                    })
                    return null
                }
                const name=_this.state
                _this.$router.push("/search/"+name)

            },

            //  search  Load
            loadAll() {
                return [
                    { "value": "手机"},
                    { "value": "零食" },
                    { "value": "书本" },
                    { "value": "工具" },

                ];
            },
            querySearchAsync(queryString, cb) {
                var restaurants = this.restaurants;
                var results = queryString ? restaurants.filter(this.createStateFilter(queryString)) : restaurants;

                clearTimeout(this.timeout);
                this.timeout = setTimeout(() => {
                    cb(results);
                }, 2000 * Math.random());
            },
            createStateFilter(queryString) {
                return (state) => {
                    return (state.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
                };
            },
            handleSelect(item) {
                console.log(item);
            }


            //  search  Load

        },
        fillter: {},

    };
</script>

<style scoped>
    /*  在此自动生成 */
    .size{
        margin-bottom: 5px;
    }
    .class-name{
        float: right;
        margin-top:3px;
        margin-right: 5px;
    }
    .el-menu-demo{}
    .inputStyle {
        text-align:center;
        vertical-align:middle;
        margin-top: 75px;
        margin-right: 200px;
    }
    .search_btn{
        text-align:center;
        vertical-align:middle;
        margin-top: 25px;
        margin-right: 200px;
    }
</style>