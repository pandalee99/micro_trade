<template>
    <div>
        <NavMenu></NavMenu>
        <div class="block">
            <el-timeline>
                <el-timeline-item   v-for="u in user" :key="u.id" placement="top" >
                    <router-link :to="{name: 'Chat' , params: {FriendId: u.id} } ">
                    <el-card shadow="hover">
                        <el-row >
                            <el-col :span="4"><div class="grid-content bg-purple">
                                <h5>{{u.userNickname}}</h5>
                                <el-image
                                        style="width: 50px; height:50px"
                                        :src="u.userImg"
                                        ></el-image>

                            </div></el-col>
                            <el-col :span="20"><div class="grid-content bg-purple-light"></div></el-col>
                        </el-row>
                    </el-card>
                    </router-link>
                </el-timeline-item>
            </el-timeline>
        </div>
    </div>
</template>

<script>
    import NavMenu from "@/components/NavMenu";
    export default {
        name: "UserFriend",
        components: {NavMenu},
        data(){
            return{
                user:[{
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

                }],
            }
        },
        created(){
            this.$axios.get('/user_friend/'+this.$store.getters.getUser.id).then(

                res=> {
                        this.user=res.data.data
                })
        },
    }
</script>

<style scoped>

</style>