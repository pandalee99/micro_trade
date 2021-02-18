<template>
    <div class="m-content">

        <H3>头部信息，可随意改</H3>
        <div class="block">
            <el-avatar :size="50" :src="user.avatar"></el-avatar>
            <div>{{user.username}}</div>

            <div class="maction">
                <span> <el-link href="/blogs">商城首页？？</el-link></span>
                <el-divider direction="vertical"></el-divider>
                <span>  <el-link type="success" href="/blog/add">我的订单？</el-link></span>

                <el-divider direction="vertical"></el-divider>
                <span v-show="!hasLogin">  <el-link type="primary" href="/login">登录</el-link></span>

                <span v-show="hasLogin">   <el-link type="danger" @click="logout">退出</el-link></span>


                <span v-show="user.role=='ROLE_ADMIN'  "> <el-link href="/blogs"> 我是管理员</el-link></span>
<!--                <span v-if="user.role=='ROLE_ADMIN' ">  <el-link href="/blogs"> 我是管理员</el-link> </span>-->
            </div>

        </div>
    </div>
</template>

<script>
    export default {
        name: "Header",
        data(){
            return {
                user:{
                    username:'请先登录',
                    avatar: 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png',
                    role: "normal"
                },
                hasLogin:false
            }
        },
        methods:{
        //     logout(){
        //         const  _this=this
        //         _this.$axios.get("/logout",{
        //             headers:{
        //                 "Authorization": localStorage.getItem("token")
        //             }
        //
        //             // eslint-disable-next-line no-unused-vars
        //         }).then(res=>{
        //             _this.$store.commit("REMOVE_INFO")
        //             _this.$router.push("/login")
        //         })
        //     }
        // },
            logout(){
                const  _this=this
                // _this.$axios.get("/qq").then((response) => {
                //     // then 指成功之后的回调 (注意：使用箭头函数，可以不考虑this指向)
                //     console.log(response);
                // })

//其实只需要清空本地的token即可了
                _this.$store.commit("REMOVE_INFO")
                _this.$router.push("/login")
            }
        }
        ,
        created() {
            if (this.$store.getters.getUser.username){

            // if (this.userInfo.id){
                this.user.id=this.$store.getters.getUser.id
                this.user.username=this.$store.getters.getUser.username
                this.user.avatar=this.$store.getters.getUser.avatar
                this.user.role=this.$store.getters.getUser.role
                // console.log(this.user.role)

                this.hasLogin=true
            }
        }
    }
</script>

<style scoped>
    .m-content{
        max-width: 960px;
        margin: 0 auto;
        text-align: center;
    }

    .maction{
        margin: 10px;
    }
</style>