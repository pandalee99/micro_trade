<template>
    <div>
<!--    <Header></Header>-->
        <NavMenu></NavMenu>
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
<!--                <div class="demo-image__placeholder">-->
<!--                    <div class="block">-->
<!--                        <span class="demonstration">默认</span>-->
<!--                        <el-image :src="p.img"></el-image>-->
<!--                    </div>-->
<!--                    -->
<!--                </div>-->
            </div></el-col>
            <el-col :span="12"><div class="grid-content bg-purple-light">
<!--                <h3>{{p.name}}</h3>-->
<!--                <h4>价格： {{p.price}} CNY</h4>-->


<!--                <h4>收货地址： <el-select v-model="id" placeholder="请选择">-->
<!--                    <el-option-->
<!--                            v-for="item in addresss"-->
<!--                            :key="item.id"-->
<!--                            :label="item.address"-->
<!--                            :value="item.id">-->
<!--                    </el-option>-->
<!--                </el-select>-->
<!--                </h4>-->


                <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
                    <el-form-item label="产品名称"  >
<!--                        <el-input v-model="ruleForm.name"></el-input>-->
<!--                        <p v-model="ruleForm.name"></p>-->
                        {{p.name}}
                    </el-form-item>
                    <el-form-item label="产品价格">
                        <!--                        <el-input v-model="ruleForm.name"></el-input>-->
                        {{p.price}}
                    </el-form-item>
                    <el-form-item label="收件人" prop="name">
                        <el-select v-model="ruleForm.name" placeholder="请选择收件人">
                            <el-option  v-for="item in addresss" :key="item.id"
                                        :label="item.name" :value="item.id"></el-option>
                        </el-select>
                        <el-button  @click="add_userinfo_show()" round>增加收货信息</el-button>
                    </el-form-item>
                    <el-form-item label="电话号码" prop="phone">
                        <el-select v-model="ruleForm.phone" placeholder="请选择电话号码">
                            <el-option  v-for="item in addresss" :key="item.id"
                                        :label="item.phone" :value="item.id"></el-option>
                        </el-select>
                    </el-form-item>
                    <el-form-item label="收货地址" prop="region">
                        <el-select v-model="ruleForm.region" placeholder="请选择活动区域">
                            <el-option  v-for="item in addresss" :key="item.id"
                                        :label="item.address" :value="item.id"></el-option>
                        </el-select>
                    </el-form-item>


<!--                    </el-form-item>-->
<!--                    <el-form-item label="即时配送" prop="delivery">-->
<!--                        <el-switch v-model="ruleForm.delivery"></el-switch>-->
<!--                    </el-form-item>-->

<!--                    <el-form-item label="属性一" prop="p1">-->
<!--                        <el-radio-group >-->
<!--                            <el-radio v-for="p in pos1" :key="p.id" :label="p.pos">{{p.pos}}</el-radio>-->

<!--                        </el-radio-group>-->
<!--                    </el-form-item>-->
<!--                    <el-form-item label="属性二" prop="p2">-->
<!--                        <el-radio-group v-model="ruleForm.p2">-->
<!--                            <el-radio v-for="p in ruleForm.p2"  :key="p.po" :label="p.po"> {{p.po}}</el-radio>-->

<!--                        </el-radio-group>-->
<!--                    </el-form-item>-->
<!--                    <el-form-item label="活动形式" prop="desc">-->
<!--                        <el-input type="textarea" v-model="ruleForm.desc"></el-input>-->
<!--                    </el-form-item>-->

                    <div v-if="r1">属性一：</div>
                    <br>
                    <div>
                        <el-radio-group  v-if="r1" v-model="id1" @change="addp1(id1)">属性一
                            <el-radio-button v-show="r.id"  v-for="r in radio1" :key="r.id" :label="r.name" ></el-radio-button>
                        </el-radio-group>
                    </div>
                    <div v-if="r2">属性二：</div>
                    <br>
                    <div>
                        <el-radio-group v-if="r2" v-model="id2" @change="addp2(id2)">
                            <el-radio-button v-show="r.id"  v-for="r in radio2" :key="r.id" :label="r.name"></el-radio-button>

                        </el-radio-group>
                    </div>
    <br>
                    <el-input-number v-model="num" @change="handleChange" :min="1" :max="10" label="描述文字"></el-input-number>
                    <br>
                    <br>
                    <br>
                    <el-form-item>
                        <el-button v-if="collection"   @click="add_collection()">    加入收藏</el-button>
                        <el-button v-else type="warning" @click="delete_collection()">    取消收藏</el-button>
                        <el-button @click="add_shopping_cart('ruleForm')">加入购物车</el-button>
                        <el-button type="primary" @click="submitForm('ruleForm')">购买</el-button>
<!--                        <el-button @click="resetForm('ruleForm')">重置</el-button>-->
<!--                        <el-button  @click="test()">测试</el-button>  -->
                    </el-form-item>
                </el-form>

                <br>
                <br>
                <br>


            </div></el-col>

            <br>
            <br>

        </el-row>
        <el-row :gutter="12">
            <el-col :span="12">
                <el-card shadow="hover">
                    <h4>店铺名称：{{merchant.shopName}}   </h4>
                    <el-image class="shop_image" :src="merchant.merchantImg"> </el-image>

                    <el-button  class="shop_right" @click="goto_merchant(merchant.merchantId)">    进入商店</el-button>
                    <!--                        <h4>店铺介绍：{{merchant.merchantDescription}}</h4>-->
                </el-card>
            </el-col>

        </el-row><br>
<!--        <h4 v-for="c in contents" :key="c.id">{{c.name}}</h4>-->
        <el-card class="box-card">
            <div slot="header" class="clearfix">
                <span>产品信息</span>
<!--                <el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>-->
            </div>
            <div v-for="c in contents" :key="c.id" class="text item">
                {{c.name}}
            </div>
        </el-card>


        <el-dialog
                title="提示"
                :visible.sync="dialogVisible"
                width="30%"
                >
            <span>是否购买</span>
            <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="submitForm('ruleForm')">确 定</el-button>

  </span>
        </el-dialog>

        <el-dialog
                title="提示"
                :visible.sync="addUserInfoDialogVisible"
                width="30%"
        >

            <el-input prop="name" v-model="addUserInfo.name" placeholder="请输入名字"></el-input>
            <el-input v-model="addUserInfo.phone" placeholder="请输入电话号码"></el-input>
            <el-input v-model="addUserInfo.address" placeholder="请输入收件地址"></el-input>

            <span slot="footer" class="dialog-footer">
    <el-button @click="addUserInfoDialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="add_userinfo()">确 定</el-button>

  </span>
        </el-dialog>

    </div>

</template>

<script>
    import NavMenu from "@/components/NavMenu";
    export default {
        name: "ProductDetail",
        components: {NavMenu},
        data(){
            return {
                p: {
                    id: "",
                    name: "找不到该产品",
                    img: "",
                    price: "",


                    // title:"默认",
                    // content:"内容"
                },
                contents:{
                    id:"",
                    name:"",
                },
                num: 1,

                // 收货地址
                infos:{
                    info:{
                        id:"1",
                        address:"",
                    }
                },
                radio1:{
                    id: '',
                    name:"",
                },
                r1:true,

                radio2:{
                    id: '',
                    name:"",
                },
                r2:true,
                p1:"",
                p2:"",
                dialogVisible: false,
                addresss:[{
                    id:"",
                    name:"",
                    phone:"",
                    address:"",
                }],
                    // options: [{
                    //     id: '选项1',
                    //     label: '黄金糕'
                    // }, {
                    //     id: '选项2',
                    //     label: '双皮奶'
                    // }, {
                    //     id: '选项3',
                    //     label: '蚵仔煎'
                    // }, {
                    //     id: '选项4',
                    //     label: '龙须面'
                    // }, {
                    //     id: '选项5',
                    //     label: '北京烤鸭'
                    // }],
                    id: '0',
                id1:'0',
                id2:'0',

                ruleForm: {
                    name: '',
                    phone: '',
                    price: '',
                    region: '',
                    date1: '',
                    date2: '',
                    delivery: false,
                    type: [],
                    // p1:{
                    //     id:'',po:""},
                    // p2:{po:""},
                    desc: ''
                },

                rules: {
                    name: [
                        { required: true, message: '请选择收件人', trigger: 'change' }
                    ],
                    phone: [
                        { required: true, message: '请选择电话号码', trigger: 'change' }
                    ],
                    region: [
                        { required: true, message: '请选择活动区域', trigger: 'change' }
                    ],
                    date1: [
                        { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
                    ],
                    date2: [
                        { type: 'date', required: true, message: '请选择时间', trigger: 'change' }
                    ],
                    type: [
                        { type: 'array', required: true, message: '请至少选择一个活动性质', trigger: 'change' }
                    ],
                    // p1: [
                    //     { required: true, message: '请选择属性', trigger: 'change' }
                    // ],
                    // p2: [
                    //     { required: true, message: '请选择属性', trigger: 'change' }
                    // ],
                    desc: [
                        { required: true, message: '请填写活动形式', trigger: 'blur' }
                    ]
                },


                order:{
                    id:"",
                    userId:"",
                    productId:"",
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
                },
                addUserInfoDialogVisible:false,
                addUserInfo:{
                    userid:'',
                    name:'',
                    address:'',
                    phone:'',
                },
                merchant:{
                    merchantId:"0",
                    userId:"0",
                    merchantName:"str",
                    shopName:"str",
                    merchantImg:"str",
                    merchantDescription:"str",

                },
                cart:{
                    id :"",
                    productId:"",
                    userId:"",
                    quantity:"",
                    properties:"",
                    name:"",
                    phone:"",
                    address:"",
                },
                collection:true,

            }
        },
        created() {
            const Id=this.$route.params.ProductId
            // console.log(pId)
            const _this=this
            this.$axios.get('/product/'+Id).then(res=>
            {
                const product=res.data.data.product
                _this.p.id=product.id
                _this.p.name=product.name
                _this.p.img=product.mainImg
                _this.p.price=product.price
                _this.p.content=product.content


                _this.order.id=product.id;
                _this.order.productName=product.name
                _this.order.productImg=product.mainImg
                _this.order.productPrice=product.price

                _this.radio1=res.data.data.radio1
                _this.radio2=res.data.data.radio2
                if (_this.radio1.length==1){
                    _this.r1=false
                }
                if (_this.radio2.length==1){
                    _this.r2=false
                }
                _this.contents = res.data.data.contents
                // _this.ownBlog=(blog.userId===_this.$store.getters.getUser.id)

                this.$axios.get('/get_one_merchant_by_product_id/'+_this.p.id).then(res=>
                {
                    _this.merchant=res.data.data
                    console.log(_this.merchant)


                    // console.log(_this.lists)

                })
                this.$axios.get('/if_collection/'+_this.p.id+"/"+this.$store.getters.getUser.id).then(res=>
                {
                    console.log(res)
                    if (res.data.data=="未收藏"){
                        this.collection=true
                    }else {this.collection=false}


                })

                this.$axios.get('/add_user_browsing_history/'+_this.p.id+"/"+this.$store.getters.getUser.id).then(

                    // eslint-disable-next-line no-unused-vars
                    res => {
                        // console.log(res.data.data)
                        // _this.$router.push("/buy/"+res.data.data)
                    }
                )



            })
            // _this.user.address=this.$store.getters.getUser.username
            this.$axios.get('/userinfo/'+_this.$store.getters.getUser.id).then(res=>
            {
                _this.addresss=res.data.data.lists


                // console.log(_this.lists)

            })

            // console.log(this.p.id)





        },
        methods:{
        submitForm(formName) {
            this.$refs[formName].validate((valid) => {
                if (valid) {

                    const _this=this //预存
                    // alert('submit!'); this.ruleForm.region  _this.order.address=
                    _this.order.productId=this.p.id
                    _this.order.userId=_this.$store.getters.getUser.id
                    _this.order.amount=this.num
                    let orderaddress=this.addresss.find((item)=>{
                        return item.id===this.ruleForm.region;
                    })
                    //名字
                    _this.order.address=orderaddress.address
                    let ordername=this.addresss.find((item)=>{
                        return item.id===this.ruleForm.name;
                    })
                    //电话
                    _this.order.address=orderaddress.address
                    let orderphone=this.addresss.find((item)=>{
                        return item.id===this.ruleForm.phone;
                    })
                    //地址
                    _this.order.address=orderaddress.address
                    _this.order.name=ordername.name
                    _this.order.phone=orderphone.phone
                    _this.order.state="未支付"

                    //属性判断
                    if (this.r1!=true){//如果不存在
                        _this.order.productProperties=''
                    }else {
                        if (_this.p1==""){alert("未选择属性一")
                            return null;}
                        _this.order.productProperties=_this.order.productProperties+_this.p1

                    }
                    if (this.r2!=true){
                        _this.order.productProperties=''

                    }else {
                        if (_this.p2==""){alert("未选择属性二")
                            return null;}
                        if (this.r1){
                        _this.order.productProperties=_this.order.productProperties+" "+_this.p2
                        }else {
                            _this.order.productProperties=_this.order.productProperties+" "+_this.p2
                        }

                    }




                    this.$axios.post('/addorder',this.order).then(

                        // eslint-disable-next-line no-unused-vars
                        res => {
                            console.log(res.data.data)
                            if (res.data.data=='抢购失败'){
                                this.$message('抢购失败');
                                return false;
                            }
                            _this.$router.push("/buy/"+res.data.data)
                        }
                    )
                    // _this.$router.push("/shop")
                } else {
                    this.$message('信息不全');
                    return false;
                }
            })
        },

            handleChange() {
                // console.log(value);
            },


            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
            test(){
            console.log(this.radio1)
            },
            addp1(name){
            // const _this=this
                this.p1=""
                this.p1=name
                // console.log(_this.p1)
            },

            addp2(name){
                // const _this=this
                // _this.p2=name
                this.p2=""
                this.p2=name
                // console.log(_this.p2)
            },
            add_userinfo_show(){
            this.addUserInfoDialogVisible=true
            },
            add_userinfo(){
            console.log(this.addUserInfo)

                const _this=this
                _this.addUserInfo.userid=_this.$store.getters.getUser.id
                // console.log(_this.addUserInfo)
                if (_this.addUserInfo.name===''){
                    this.$message('请输入收件人姓名');
                    return null
                }
                console.log(_this.addUserInfo)
                if (_this.addUserInfo.address===''){
                    this.$message('请输入收件人地址');
                    return null
                }
                if (_this.addUserInfo.phone===''){

                    this.$message('请输入收件人电话');
                    return null
                }
                var numReg = /^[0-9]+$/
                var numRe = new RegExp(numReg)
                if (!numRe.test(_this.addUserInfo.phone)) {
                    this.$message({
                        type: 'error',
                        message: '请正确输入电话号码 ',
                        duration: 2000,
                    })
                    return null
                }
                // console.log(_this.addUserInfo)
                this.$axios.post('/add_userInfo',_this.addUserInfo).then(

                    // eslint-disable-next-line no-unused-vars
                    res => {
                        this.$message({
                            message: '增加信息成功 ',
                            duration: 2000,
                        })
                        this.addUserInfoDialogVisible=false
                        this.$axios.get('/userinfo/'+_this.$store.getters.getUser.id).then(res=>
                        {
                            _this.addresss=res.data.data.lists


                            // console.log(_this.lists)

                        })
                    }
                )
            },
            add_shopping_cart(formName){
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        const _this=this
                        _this.cart.productId = this.p.id
                        _this.cart.userId = this.$store.getters.getUser.id
                        _this.cart.quantity = this.num

                        if (this.r1!=true){//如果不存在
                            _this.cart.properties=''
                        }else {
                            if (_this.p1==""){alert("未选择属性一")
                                return null;}
                            _this.cart.properties=_this.cart.properties+_this.p1

                        }
                        if (this.r2!=true){
                            _this.cart.properties=''

                        }else {
                            if (_this.p2==""){alert("未选择属性二")
                                return null;}
                            if (this.r1){
                                _this.cart.properties=_this.cart.properties+" "+_this.p2
                            }else {
                                _this.cart.properties=_this.cart.properties+" "+_this.p2
                            }

                        }
                        // console.log(_this.cart)
                        let orderaddress=this.addresss.find((item)=>{
                            return item.id===this.ruleForm.region;
                        })
                        //名字
                        _this.cart.address=orderaddress.address
                        let ordername=this.addresss.find((item)=>{
                            return item.id===this.ruleForm.name;
                        })
                        //电话
                        _this.cart.address=orderaddress.address
                        let orderphone=this.addresss.find((item)=>{
                            return item.id===this.ruleForm.phone;
                        })
                        //地址
                        _this.cart.address=orderaddress.address
                        _this.cart.name=ordername.name
                        _this.cart.phone=orderphone.phone

                        this.$axios.post('/add_shopping_cart', _this.cart).then(
                            res => {
                                console.log(res)
                                // _this.$router.push("/buy/"+res.data.data)
                                this.$message("加入购物车成功")
                            })
                            }
                })
            },

            goto_merchant(id){
            const _this=this
                _this.$router.push("/merchant_shop/"+id)

            },
            add_collection(){
                this.$axios.get('/add_collection/'+this.p.id+"/"+this.$store.getters.getUser.id).then(res=>
                {
                    console.log(res)
                    this.collection=false
                    this.$message("收藏成功")


                })
            },
            delete_collection(){
                this.$axios.get('/delete_collection/'+this.p.id+"/"+this.$store.getters.getUser.id).then(res=>
                {
                    console.log(res)
                    this.collection=true
                    this.$message("取消收藏成功")


                })
            }

        },





    }
</script>

<style scoped>
    .text {
        font-size: 14px;
    }

    .item {
        margin-bottom: 18px;
    }

    .clearfix:before,
    .clearfix:after {
        display: table;
        content: "";
    }
    .clearfix:after {
        clear: both
    }

    .box-card {
        width: 1000px;
        /*margin: 0 auto;*/
    }
    .shop_image{
        width: 50px;
        height: 50px;
    }
    .shop_right{
        float: right;
    }
</style>