<template>
    <div>
       <NavMenu></NavMenu>
        <el-row :gutter="12">
            <el-col :span="12">
                <el-card shadow="hover">
                    <h4>名称：{{merchant.shopName}}   </h4>
                    <el-image class="shop_image" :src="merchant.merchantImg"> </el-image>

                    <el-button v-if="focus" class="shop_right" @click="add_care()">    关注</el-button>
                    <el-button v-else class="shop_right" @click="delete_care()">    取消关注</el-button>
                    <!--                        <h4>店铺介绍：{{merchant.merchantDescription}}</h4>-->
                    <h4>描述：{{merchant.merchantDescription}}</h4>
                </el-card>
            </el-col>

        </el-row><br>
        <el-row>
            <!--            :offset="index > 0 ? 2 : 0-->
            <el-col :span="8" v-for="p in products" :key="p.id"  >
                <router-link :to="{name: 'ProductDetail' , params: {ProductId: p.id} } ">
                    <el-card :body-style="{ padding: '1px' }">
                        <!--                    <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png" class="image">-->
                        <img :src="p.mainImg" class="image">
                        <div style="padding: 14px;">
                            <span>{{p.name}}</span>
                            <div class="bottom clearfix">
                                <time class="time">{{ p.created }}</time>
                                <!--                            <el-button type="text" class="button">操作按钮</el-button>-->
                            </div>
                        </div>
                    </el-card>

                </router-link>
            </el-col>
        </el-row>

    </div>
</template>

<script>
    import NavMenu from "@/components/NavMenu";
    export default {
        name: "MerchantShop",
        components: {NavMenu},
        data(){
            return{
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
                merchant:{
                    merchantId:"0",
                    userId:"0",
                    merchantName:"str",
                    shopName:"str",
                    merchantImg:"str",
                    merchantDescription:"str",

                },
                focus:true


            }
        },
        created() {
            // console.log(this.$route.params.MerchantId)
            this.$axios.get('/get_merchant_product/'+this.$route.params.MerchantId).then(
                res=> {

                    this.products=res.data.data
                    console.log(this.products)
                    // this.$message("获取成功")
                })
            this.$axios.get('/get_one_merchant/'+this.$route.params.MerchantId).then(res=>
            {
                this.merchant=res.data.data
                console.log(this.merchant)
                // console.log(_this.lists)

            })
            this.$axios.get('/if_focus/'+this.$route.params.MerchantId+"/"+this.$store.getters.getUser.id).then(res=>
            {
                console.log(res)
                if (res.data.data=="未关注"){
                    this.focus=true
                }else {this.focus=false}


            })
        },
        methods:{
            add_care(){
                this.$axios.get('/add_focus/'+this.$route.params.MerchantId+"/"+this.$store.getters.getUser.id).then(res=>
                {
                    console.log(res)
                    this.focus=false
                    this.$message("关注成功")


                })
            },
            delete_care(){
                this.$axios.get('/delete_focus/'+this.$route.params.MerchantId+"/"+this.$store.getters.getUser.id).then(res=>
                {
                    console.log(res)
                    this.focus=true
                    this.$message("取消关注成功")


                })
            }
        }

    }
</script>

<style scoped>
    .shop_image{
        width: 50px;
        height: 50px;
    }
    .shop_right{
        float: right;
    }
</style>