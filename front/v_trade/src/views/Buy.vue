<template>
    <div>
    <NavMenu></NavMenu>
<!--    <h1>购买页面</h1>-->
        <el-row>
            <el-col :span="12"><div class="grid-content bg-purple">
                <div v-if="p.img!=null" class="demo-image">
                    <div class="block">
                        <!--                        <span class="demonstration">fit </span>-->
                        <el-image
                                style="width: 400px; height:400px"
                                :src="p.img"
                                :fit="'fill'"></el-image>
                    </div>
                </div>
                <div v-if="p.img==null"  class="demo-image__error">
                    <div class="block">
                        <span class="demonstration">默认</span>
                        <el-image></el-image>
                    </div>
                </div>
            </div></el-col>
            <el-col :span="12"><div class="grid-content bg-purple-light">
                <h5>产品名称：{{p.name}}</h5>
                <h5>产品属性：{{order.productProperties}}</h5>
                <h5>产品单价：{{p.price}}</h5>
                <el-input-number v-model="num" @change="handleChange" :min="1" :max="10" label="描述文字"></el-input-number>
                <h5>产品总价：{{order.sumMoney}}</h5>
                <h5>收货人： </h5>
                <el-input v-model="order.name" placeholder="请输入内容"></el-input>
                <h5>电话号码：</h5>
                <el-input v-model="order.phone" placeholder="请输入内容"></el-input>
                <h5>收货地址：</h5>
                <el-input v-model="order.address" placeholder="请输入内容"></el-input>

            </div>
            </el-col>

        </el-row>
        <el-row>
            <el-col :span="24"><div class="grid-content bg-purple-dark">
               <h5>备注：</h5>
                <el-input v-model="order.note" placeholder="请输入内容"></el-input>
            </div></el-col>
        </el-row>
        <br><br><br><br><br><br><br><br><br><br><br>
        <el-button   class="main-button" @click="pay_product()" round>进行支付</el-button>
        <br><br><br><br><br><br><br><br><br><br><br>

    </div>

</template>

<script>
    import NavMenu from "@/components/NavMenu";

    export default {
        name: "Buy",
        components: {NavMenu},
        data(){
            return{
                order:{
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
                },
                p: {
                    id: "",
                    name: "找不到该产品",
                    img: "",
                    price: "",
                    content:"",


                    // title:"默认",
                    // content:"内容"
                },
                num: 1,
                input: '',
            }
        },
        created() {
            console.log(this.$route.params.BuyId)

            const _this=this


            this.$axios.get('/prepared_to_pay/'+this.$route.params.BuyId).then(res=>
            {
                // console.log(res)
                _this.order=res.data.data
                _this.num=res.data.data.amount
                // console.log(res.data.data)
                // console.log(_this.order)
                // console.log(res.data.data.amount)
                // console.log(_this.order.id)
                this.$axios.get('/product/'+_this.order.productId).then(res=> {
                    const product = res.data.data.product
                    _this.p.id = product.id
                    _this.p.name = product.name
                    _this.p.img = product.mainImg
                    _this.p.price = product.price
                    _this.p.content = product.content
                }
                )
            }
            )

        },
        methods: {

            pay_product() {
                const _this=this

                this.$axios.post('/pay_product' ,this.order).then(
                    res => {

                        const message=res.data.data
                        if(message=='支付成功'){
                        this.$alert(message, '支付结果', {
                            confirmButtonText: '确定',
                            callback: action => {
                                console.log(action)
                                // this.$message({
                                //     // type: 'info',
                                //     // message: `action: ${ action }`,
                                //
                                // },)
                                _this.$router.push("/shop");
                            }
                        });}else {
                            this.$message('余额不足');
                        }



                    }
                )
            },

            handleChange(value) {
                // console.log(value);
                this.order.sumMoney=value*this.p.price
            },


        }
    }
</script>

<style scoped>
    .main-button{
        /*margin-left: 1000px;*/
        float: right;

    }
</style>