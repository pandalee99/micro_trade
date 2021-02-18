<template>
    <div>
        <NavMenu></NavMenu>
<!--        <h1>用户页</h1>-->
        <el-row>
            <el-col :span="12"><div class="grid-content bg-purple">

                <el-col :span="12">
<!--                    <div class="sub-title">circle</div>-->
                    <div class="demo-basic--circle">
<!--                        <div class="block"><el-avatar :size="150"  :src="user.userImg"></el-avatar></div>-->
                        <img :src="user.userImg"  class="image">
<!--                        <div class="block" v-for="size in sizeList" :key="size">-->
<!--                            <el-avatar :size="size" :src="circleUrl"></el-avatar>-->
<!--                        </div>-->
                    </div>
                </el-col>
            </div></el-col>
            <el-col :span="12"><div class="grid-content bg-purple-light">
                <div v-show="notedit">
                <h5>用户ID：{{user.id}}</h5>
                <h5>用户昵称：{{user.userNickname}}</h5>
<!--                用户昵称：<el-input-->
<!--                        placeholder="请输入内容"-->
<!--                        v-model="user.userNickname"-->
<!--                        :disabled="true">-->
<!--                </el-input>-->
                <h5>用户性别：{{user.sex}}</h5>
                <h5>钱包余额：{{user.money}} 元</h5>
<!--                <h5>{{user.roles}}</h5>-->
                <h5>个人简介：{{user.description}}</h5>
                </div>
                <div v-show="!notedit"><br>
                    <el-input v-model="user.userNickname" placeholder="请输入内容"></el-input><br>

                    <el-input v-model="user.sex" placeholder="请输入内容"></el-input><br>
                    <el-input v-model="user.description" placeholder="请输入内容"></el-input><br>
                    <el-button @click="editC()">完成</el-button>

                </div>
                <el-button @click="edit()">编辑</el-button>
            </div></el-col>
        </el-row><br><br><br>

<!--用户部分-->
        <el-row :gutter="16">
<!--              <router-link :to="{name: 'Collection' , params: {UserId: this.$store.getters.getUser.id} } ">-->
            <router-link :to="{name: 'Collection'} ">
            <el-col :span="6">
                <el-card shadow="hover">
                    我的收藏
                </el-card>
            </el-col> </router-link>
            <router-link :to="{name: 'UserCare'  } ">
            <el-col :span="6">
                <el-card shadow="hover">
                    我的关注
                </el-card>
            </el-col></router-link>
            <router-link :to="{name: 'UserBrowsingHistory'} ">
            <el-col :span="6">
                <el-card shadow="hover">
                    浏览历史
                </el-card>
            </el-col></router-link>
            <el-col :span="6">
                <el-card shadow="hover">
                    保留
                </el-card>
            </el-col>
        </el-row>

<!--订单部分--><br><br><br>
        <el-tabs v-model="activeName" type="card" @tab-click="handleClick">
            <el-tab-pane label="待支付" name="first">
                <br><br>
                <div class="block">
                    <div class="radio">
                    排序：
                    <el-radio-group v-model="reverse">
                        <el-radio :label="true">倒序</el-radio>
                        <el-radio :label="false">正序</el-radio>
                    </el-radio-group>
                    </div><br><br>


<!--                    订单管理-->
                <el-timeline :reverse="reverse">
                    <el-timeline-item
                            v-for="(o, index) in order"
                            :key="index" v-show="o.state=='未支付'"
                            >
                        <el-row>
                            <el-col :span="12"><div class="grid-content bg-purple"><h4>订单编号：{{o.id}}</h4></div></el-col>
                            <el-col :span="12"><div class="grid-content bg-purple-light"><h4>创建时间：{{o.time}}</h4></div></el-col>
                        </el-row>
                        <div class="block">
                            <el-row>
                                <el-col :span="12"><div class="grid-content bg-purple"><el-image class="omage" :src="o.productImg"></el-image></div>
                                    </el-col>
                                <el-col :span="12"><div class="grid-content bg-purple-light">
                                    <h4>单价：{{o.productPrice}}</h4>
                                    <h4>数量：{{o.amount}}</h4>
                                    <h4>邮费：{{o.courier}}</h4>
                                    <h4>总价：{{o.sumMoney}}</h4>
                                    <h4>属性： {{o.productProperties}}</h4>
                                </div></el-col>
                            </el-row>
                            <h4>备注：{{o.note}} </h4><el-button class="mostright">查看详情</el-button>
                            <el-button class="mostright" @click="pay_one_order(o.id)">等待支付</el-button>


                        </div>
                    </el-timeline-item>
                </el-timeline>
            </div>
            </el-tab-pane>
            <el-tab-pane label="待收货" name="second">待收货</el-tab-pane>
            <el-tab-pane label="待评价" name="third">待评价</el-tab-pane>
            <el-tab-pane label="全部订单" name="fourth">全部订单</el-tab-pane>
        </el-tabs>
    </div>
</template>

<script>

    import NavMenu from "@/components/NavMenu";
    export default {
        name: "User",
        components: {NavMenu,},
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
                // userInfo:{
                //     id:"",
                //     userNickname:"str",
                //     sex:"",
                //     description:"str",
                // },
                activeName: 'first',
                input:'',
                notedit:true,
                reverse: true,
                order: [{
                    id:"",
                    userId:"",
                    productId:"",
                    name:"",
                    phone:"",
                    address:"",
                    state:"",
                    commentWord:"",
                    commentImg:"",
                    note:"",
                    courier:"0",
                    amount:"",
                    sumMoney:"",
                    productProperties:"",
                    time:"",
                    productName:"",
                    productImg:"",
                    productPrice:"",
                }],
                p:{
                    id:"0",
                    name:"str",
                    price:"BigDecimal",
                    mainImg:"str",
                    content:"str",
                    brand:"str",
                    category:"str",
                    stock:"",
                    flag:"0",
                    created:"1611575977606",
                    properties1:"str",
                    properties2:"str",
                    courierFees:"BigDecimal",
                    merchant:"str",

                },

            }
        },
        created() {
            const _this=this
            this.$axios.get('/user/'+_this.$store.getters.getUser.id).then(
                res=> {
                    _this.user=res.data.data
                    console.log(_this.user)
            })

            this.$axios.get('/get_all_order/'+_this.$store.getters.getUser.id).then(
                res=> {
                    _this.order=res.data.data
                    console.log(_this.order)
                })


        },
        methods: {
            created_get_all_order(){
                const _this=this
                this.$axios.get('/get_all_order/'+_this.$store.getters.getUser.id).then(
                    res=> {
                        _this.order=res.data.data
                        console.log(_this.order)
                    })
            },
            handleClick(tab, event) {
                console.log(tab, event);
            },
            edit(){
                this.notedit=false
            },
        editC(){
            this.notedit=true
            // const _this=this
            // // _this.user=this.user
            //
            // _this.userInfo.id=this.user.id
            // _this.userInfo.userNickname=this.user.userNickname
            // _this.userInfo.sex=this.user.sex
            // _this.userInfo.description=this.user.description
            // console.log(_this.userInfo)
            this.$axios.post('/update_user',this.user).then(

                res=> {
                        console.log(res)
                })
        },

            pay_one_order(id){
                console.log(id)
                this.$axios.get('/pay_one_order/'+id).then(

                    res=> {
                        console.log(res)
                        if (res.data.data=="支付成功"){
                            this.$message("支付成功")
                        }else{
                            this.$message("账户余额不足")
                        }
                        this.created_get_all_order()
                    })
            }
        }
        ,
    }
</script>

<style scoped>
.image{
    text-align: center;
    float: right;
    margin: 10px 5px 15px 20px;
}
    .omage{
        height: 150px;
        width: 150px;
        /*margin: 10px 5px 15px 20px;*/
    }
    .mostright{
        float: right;
    }

</style>