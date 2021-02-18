<template>
    <div>
        <br><br><div><el-button class="right_btn" @click="add_all_cart_order()" type="success">全部支付</el-button></div>
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
                        v-for="o in order"
                        :key="o.id"
                >
                    <el-row>
                        <el-col :span="12"><div class="grid-content bg-purple"><h4>订单编号：{{o.id}}</h4></div></el-col>
<!--                        <el-col :span="12"><div class="grid-content bg-purple-light"><h4>创建时间：{{o.time}}</h4></div></el-col>-->
                    </el-row>
                    <div class="block">
                        <el-row>
                            <el-col :span="5"><div class="grid-content bg-purple"><el-image class="omage" :src="o.productImg"></el-image></div>
                            </el-col>
                            <el-col :span="15"><div class="grid-content bg-purple-light">
<!--                                <h5>单价：{{o.productPrice}} <span>   </span>数量：{{o.amount}}</h5>-->
<!--                                <h5>数量：{{o.amount}}</h5>-->
<!--                                <h5>邮费：{{o.courier}}</h5>-->
<!--                                <h5>总价：{{o.sumMoney}}</h5>-->
<!--                                <h5>属性： {{o.productProperties}}</h5>-->

                            <el-row>
                                <el-col :span="6"><div class="grid-content bg-purple">单价：{{o.productPrice}}</div></el-col>
                                <el-col :span="6"><div class="grid-content bg-purple-light">数量：{{o.amount}}</div></el-col>
                                <el-col :span="6"><div class="grid-content bg-purple">邮费：{{o.courier}}</div></el-col>
                                <el-col :span="6"><div class="grid-content bg-purple-light">总价：{{o.sumMoney}}</div></el-col>
                            </el-row>
                                <h4>属性： {{o.productProperties}}</h4>
                                <el-row>
                                    <el-col :span="8"><div class="grid-content bg-purple"><el-input v-model="o.name"  placeholder="请输入收件人"></el-input></div></el-col>
                                    <el-col :span="8"><div class="grid-content bg-purple-light"><el-input v-model="o.phone" placeholder="请输入收件号码"></el-input></div></el-col>
                                    <el-col :span="8"><div class="grid-content bg-purple"><el-input v-model="o.address" placeholder="请输入收件地址"></el-input></div></el-col>
                                </el-row>
                            </div>
                            </el-col>
                        </el-row>


<!--                        <h4>备注：{{o.note}} </h4>-->
                        <el-row>
                            <el-col :span="12"><div class="grid-content bg-purple">
                                <el-button class="mostright">查看详情</el-button>
                                </div>
                            </el-col>
                            <el-col :span="12"><div class="grid-content bg-purple-light">
                                <el-row>
                                    <el-col :span="12"><div class="grid-content bg-purple"><el-button class="mostright" @click="delete_cart(o.id)">删除</el-button></div></el-col>
                                    <el-col :span="12"><div class="grid-content bg-purple-light"><el-button class="mostright" @click="pay_cart(o)">支付</el-button></div></el-col>
                                </el-row>


                            </div></el-col>
                        </el-row>

                    </div>
                </el-timeline-item>
            </el-timeline>
        </div>

    </div>
</template>

<script>
    export default {
        name: "ShopCart",
        data() {
            return {
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
                oneOrder:{
                    name:"",
                    phone:"",
                    address:"",
                },
                reverse: true,
                visible: false,
                visible2:false,
                userInfo:{
                    id:"0",
                    phone:"0",
                    address:"str",
                    name:"str",
                    userid:"0",
                    },
                no:"",
            };
        },
        created() {
            const _this=this

            this.$axios.get('/get_all_cart/'+_this.$store.getters.getUser.id).then(
                res=> {
                    _this.order=res.data.data
                    console.log(_this.order)
                })

            // this.$axios.get('/get_one_userinfo/'+_this.$store.getters.getUser.id).then(
            //     res=> {
            //         _this.userInfo=res.data.data
            //         console.log(_this.userInfo)
            //     })

        },
        methods: {

            get_all_cart(){
                const _this=this
                this.$axios.get('/get_all_cart/'+_this.$store.getters.getUser.id).then(
                    res=> {
                        _this.order=res.data.data
                        // console.log(_this.order)
                    })
            },

            handleClick(tab, event) {
                console.log(tab, event);
            },
            delete_cart(id){
                // this.delete_item(id)
                // this.visible=true
                this.$axios.get('/delete_cart/'+id).then(
                    res=> {
                       console.log(res)
                        this.get_all_cart()
                        this.$message("删除成功")
                    })
            },
            delete_item(id){
            console.log(id)
            //     this.$axios.get('/delete_cart/'+id).then(
            //         res=> {
            //             console.log(res)
            //             this.get_all_cart()
            //             this.$message("删除成功")
            //         })
            //     this.visible=false
            },
            pay_cart(id){
                // this.visible2=true
                console.log(id)

                this.$axios.post('/add_one_cart_order' ,id).then(
                    res => {-
                        this.get_all_cart()
                        console.log(res)
                        if (res.data.data=="支付成功"){
                            this.$message("支付成功")
                        }else{
                            this.$message("账户余额不足")
                        }
                    })

            },
            pay_item(){
                // console.log(id)
                // if (this.userInfo.name==""){
                //     this.$message("未填写收件人")
                //     return null
                // }
                // if (this.userInfo.phone==""){
                //     this.$message("未填写收件号码")
                //     return null
                // }
                // if (this.userInfo.address==""){
                //     this.$message("未填写收件地址")
                //     return null
                // }
                // this.order.address=order.address
                this.$message("支付成功")
                this.visible2=false
                // this.$axios.post('/add_one_cart_order' ,order).then(
                //     res => {
                //
                //
                //         console.log(res)
                //     })
            },
            add_all_cart_order(){
                if (this.order.length==0){
                    this.$message("购物车为空")
                    return null;
                }
                this.$axios.post('/add_all_cart_order' ,this.order).then(
                    res => {

                        this.get_all_cart()

                        console.log(res.data.data)
                        if (res.data.data=="支付成功"){
                            this.$message("支付成功")
                        }else{
                            this.$message("账户余额不足")
                        }
                    })
            }
        }
    };
</script>

<style scoped>
    .omage{
        height: 100px;
        width: 100px;
        /*margin: 10px 5px 15px 20px;*/
    }
    .right_btn{
        float: right;
    }
</style>