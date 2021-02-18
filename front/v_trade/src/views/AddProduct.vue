<template>
    <div>
        <NavMenu></NavMenu>

        <el-form ref="form" :model="p" label-width="80px">
            <el-form-item label="产品名称">
                <el-input v-model="p.name"></el-input>
            </el-form-item>
            <el-form-item label="产品价格" >
                <el-input type="number" @input="oninput"  v-model="p.price"></el-input>
            </el-form-item>



        <h4>产品图片：</h4>
        <div title="上传" v-show="divOfUpload" width="35%" style="text-align: center;">
            <el-upload class="upload-demo" action="#" drag multiple :headers="headers" :auto-upload="false"
                       :file-list="fileList" :on-change="handleChange">
                <i class="el-icon-upload"></i>
                <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
                <div class="el-upload__tip" slot="tip">上传图片</div>
            </el-upload>
        </div>
            <el-form-item label="产品品牌">
                <el-input v-model="p.brand"></el-input>
            </el-form-item>
            <el-form-item label="产品种类">
                <el-input v-model="p.category"></el-input>
            </el-form-item>
            <el-form-item label="产品库存">
                <el-input v-model="p.stock"></el-input>
            </el-form-item>
            <el-form-item label="属性一">
                <el-input v-model="p.properties1"></el-input>
            </el-form-item>
            <el-form-item label="属性二">
                <el-input v-model="p.properties2"></el-input>
            </el-form-item>
            <el-form-item label="产品内容描述">
                <el-input type="textarea" v-model="p.content"></el-input>
            </el-form-item>
        </el-form>

        <div slot="footer" class="dialog-footer">
            <el-button @click="canceldialogOfUpload()">取 消</el-button>
<!--            <el-button type="primary" @click="test()">上 传</el-button>-->
            <el-button type="primary" @click="confirmUpload()">上 传</el-button>
        </div>
    </div>
</template>

<script>
    import NavMenu from "@/components/NavMenu";
    export default {
        name: "AddProduct",
        components: {NavMenu},
        data(){
            return{
                divOfUpload: true,
                fileList: [],
                headers: {
                    'Content-Type': 'multipart/form-data'
                },
                p:{
                    id:"0",
                    name:"",
                    price:"",
                    mainImg:"",
                    content:"",
                    brand:"",
                    category:"",
                    stock:0,
                    flag:"0",
                    created:"1611575977606",
                    properties1:"",
                    properties2:"",
                    courierFees:0,
                    merchant:"str",

                },
                merchant:{
                    merchantId:"0",
                    userId:"0",
                    merchantName:"str",
                    shopName:"str",
                    merchantImg:"str",
                    merchantDescription:"str",

                },

            }
        },
        created(){

        },
        methods: {
            handleChange(file, fileList) { //文件数量改变
                this.fileList = fileList;
            },

            confirmUpload() {

                var numReg = /^[0-9]+$/
                var numRe = new RegExp(numReg)
                if (!numRe.test(this.p.stock)) {
                    this.$message({
                        type: 'error',
                        message: '请正确输入库存 ',
                        duration: 2000,
                        showClose: true,
                    })
                    return null
                }
                if (this.p.name==""){
                    this.$message({
                        type: 'error',
                        message: '请输入产品名称 ',
                        duration: 2000,
                        showClose: true,
                    })
                    return null
                }
                if (this.p.price==""){
                    this.$message({
                        type: 'error',
                        message: '请输入产品价格 ',
                        duration: 2000,
                        showClose: true,
                    })
                    return null
                }

                if (this.fileList==""){
                    this.$message({
                        type: 'error',
                        message: '请放入图片 ',
                        duration: 2000,
                        showClose: true,
                    })
                    return null
                }

                //确认上传
                var param = new FormData();
                this.fileList.forEach(
                    // eslint-disable-next-line no-unused-vars
                    (val, index) => {
                        param.append("file", val.raw);

                    }
                );
                // console.log("通过检验")

                this.$axios.post("/qiniu/upload", param).then(res => {
                    // console.log(res)
                    this.p.mainImg=res.data.data

                    this.$axios.get('/get_one_merchant_by_user_id/'+this.$store.getters.getUser.id).then(res=>
                    {
                        this.merchant=res.data.data
                        this.p.merchant=this.merchant.shopName

                            this.$axios.post("/merchant_add_one_product", this.p).then(res => {
                                console.log(res)

                            });

                    })

                    this.divOfUpload=false

                    this.$router.push("/merchant")
                });


                this.$message({
                    message: "上传成功！",
                    duration: 2000
                });
            },
            canceldialogOfUpload(){
                this.divOfUpload=false
            },
            // eslint-disable-next-line no-unused-vars
            oninput(e) {
                // 通过正则过滤小数点后两位
                e = (e.match(/^\d*(\.?\d{0,2})/g)[0]) || null
                //
                // console.log('e',e.target.value)
                // console.log(e)
            },
            test(){
                if(this.p.name=="")
                {
                    console.log("为空")
                }
                // console.log(this.p.price)
                // console.log(typeof this.p.price);
                var numReg = /^[0-9]+$/
                var numRe = new RegExp(numReg)
                if (!numRe.test(this.p.stock)) {
                    this.$message({
                        type: 'error',
                        message: '请正确输入库存 ',
                        duration: 2000,
                        showClose: true,
                    })
                    return null
                }



        }   }
    }
</script>

<style scoped>

</style>