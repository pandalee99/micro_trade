<template>
    <div>
        <NavMenu></NavMenu>
        <el-row>
            <el-col :span="12"><div class="grid-content bg-purple">

                <el-col :span="12">
                    <!--                    <div class="sub-title">circle</div>-->
                    <div class="demo-basic--circle">
                        <!--                        <div class="block"><el-avatar :size="150"  :src="user.userImg"></el-avatar></div>-->
                        <img :src="merchant.merchantImg"  class="image">
                        <!--                        <div class="block" v-for="size in sizeList" :key="size">-->
                        <!--                            <el-avatar :size="size" :src="circleUrl"></el-avatar>-->
                        <!--                        </div>-->
                    </div>
                </el-col>
            </div></el-col>

            <el-col :span="12"><div class="grid-content bg-purple-light">
                <div >
                    <h5>商家ID：{{merchant.merchantId}}</h5>
                    <h5>商家昵称：{{merchant.merchantName}}</h5>
                    <!--                用户昵称：<el-input-->
                    <!--                        placeholder="请输入内容"-->
                    <!--                        v-model="user.userNickname"-->
                    <!--                        :disabled="true">-->
                    <!--                </el-input>-->
                    <h5>拥有的商店名称：{{merchant.shopName}}</h5>
                    <h5>商家简介：{{merchant.merchantDescription}}</h5>
                </div>

            </div></el-col>
        </el-row><br><br><br>
        <el-row :gutter="16">
            <!--              <router-link :to="{name: 'Collection' , params: {UserId: this.$store.getters.getUser.id} } ">-->
            <router-link :to="{name: 'AddProduct'} ">
                <el-col :span="6">
                    <el-card shadow="hover">
                        增加商品
                    </el-card>
                </el-col> </router-link>
            <router-link :to="{name: 'PublishMessage'  } ">
            <el-col :span="6">
                <el-card shadow="hover">
                    发布消息
                </el-card>
            </el-col>
                            </router-link>

        </el-row><br><br><br>
        <el-tabs v-model="activeName" type="card" @tab-click="handleClick">
            <el-tab-pane label="我的产品" name="first">

                <el-timeline >
                    <el-timeline-item
                            v-for="(p, index) in products"
                            :key="index"
                    >

                        <el-row>
                            <el-col :span="12"><div class="grid-content bg-purple"><h4>产品ID：{{p.id}}</h4></div></el-col>
                            <el-col :span="12"><div class="grid-content bg-purple-light"><h4>创建时间：{{p.created}}</h4></div></el-col>
                        </el-row>
                        <div class="block">
                            <el-row>

                                <el-col :span="12"><div class="grid-content bg-purple">
                                    <router-link :to="{name: 'ProductDetail' , params: {ProductId: p.id} } ">
                                    <el-image class="omage" :src="p.mainImg"></el-image>
                                    </router-link>
                                </div>
                                </el-col>
                                <el-col :span="12"><div class="grid-content bg-purple-light">
                                    <h4>单价：{{p.price}}</h4>
                                    <h4>库存：{{p.stock}}</h4>
                                    <h4>品牌：{{p.brand}}</h4>
                                    <h4>种类：{{p.category}}</h4>
                                    <h4>属性一： {{p.properties1}}</h4>
                                    <h4>属性二： {{p.properties2}}</h4>
                                </div></el-col>
                            </el-row>
                            <h4>产品描述：{{p.content}} </h4><el-button class="mostright">查看详情</el-button>



                        </div>
                    </el-timeline-item>
                </el-timeline>

            </el-tab-pane>
            <el-tab-pane label="保留" name="second">保留</el-tab-pane>
<!--            <el-tab-pane label="角色管理" name="third">角色管理</el-tab-pane>-->
<!--            <el-tab-pane label="定时任务补偿" name="fourth">定时任务补偿</el-tab-pane>-->
        </el-tabs>
    </div>
</template>

<script>
    import NavMenu from "@/components/NavMenu";
    export default {
        name: "Merchant",
        components: {NavMenu},
        data(){
            return{
                merchant:{
                    merchantId:"0",
                    userId:"0",
                    merchantName:"",
                    shopName:"",
                    merchantImg:"",
                    merchantDescription:"",

                },
                activeName: 'first',
                products:[{
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

                }],

            }
        },
        created() {
            this.get_one_merchant_by_user_id()
        },
        methods:{
            get_one_merchant_by_user_id(){
                // console.log("执行")
                this.$axios.get('/get_one_merchant_by_user_id/'+this.$store.getters.getUser.id).then(res=>
                {
                    this.merchant=res.data.data
                    // console.log(this.merchants)
                    // console.log(_this.lists)
                    this.get_all_product_by_merchant_id(this.merchant.merchantId)
                    localStorage.removeItem("merchant")
                    localStorage.setItem("merchant",JSON.stringify(this.merchant))

                })
            },
            get_all_product_by_merchant_id(id){
                this.$axios.get('/get_all_product_by_merchant_id/'+id).then(res=>
                {
                    this.products=res.data.data


                })
            }
            ,
            handleClick(tab, event) {
                console.log(tab, event);
            }

        }
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