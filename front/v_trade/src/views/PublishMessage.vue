<template>
    <div>
        <NavMenu></NavMenu>
        <h3>消息推送</h3>

        <el-form ref="form" :model="message" label-width="80px">
            <el-form-item label="消息名称">
                <el-input type="textarea" v-model="message.moveNewName"></el-input>
            </el-form-item>
            <el-form-item label="内容描述">
                <el-input type="textarea" v-model="message.moveNewContent"></el-input>
            </el-form-item>
        </el-form>


        <div title="上传" v-show="divOfUpload" width="35%" style="text-align: center;">
            <el-upload class="upload-demo" action="#" drag multiple :headers="headers" :auto-upload="false"
                       :file-list="fileList" :on-change="handleChange">
                <i class="el-icon-upload"></i>
                <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
                <div class="el-upload__tip" slot="tip">上传图片</div>
            </el-upload>
        </div>



        <div slot="footer" class="dialog-footer">
            <el-button @click="canceldialogOfUpload()">取 消</el-button>
            <!--            <el-button type="primary" @click="test()">上 传</el-button>-->
            <el-button type="primary" @click="confirmUpload()">发布</el-button>
        </div>
    </div>
</template>

<script>
    import NavMenu from "@/components/NavMenu";
    export default {
        name: "PublishMessage",
        components: {NavMenu},
        data(){
            return{
                divOfUpload: true,
                fileList: [],
                headers: {
                    'Content-Type': 'multipart/form-data'
                },
                message:{
                    id:"0",
                    merchantId:"0",
                    merchantName:"",
                    moveNewName:"str",
                    moveNewCreatTime:"1611920322936",
                    moveNewContent:"str",
                    moveNewImg:"str",

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
            // this.merchant=localStorage.getItem("merchant")
            // console.log(this.merchant)
            // console.log(this.merchant.merchantId)
            this.merchant=JSON.parse(localStorage.getItem("merchant"))
            // console.log(this.merchant.merchantId)


        },

        methods:{
            handleChange(file, fileList) { //文件数量改变
                this.fileList = fileList;
            },

            canceldialogOfUpload(){

            },
            confirmUpload(){
                if (this.message.moveNewName==""){
                    this.$message({
                        type: 'error',
                        message: '请输入消息名称 ',
                        duration: 2000,
                        showClose: true,
                    })
                    return null
                }
                if (this.message.moveNewContent==""){
                    this.$message({
                        type: 'error',
                        message: '请输入消息内容 ',
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
                    this.message.moveNewImg=res.data.data
                    this.message.merchantId=this.merchant.merchantId
                    this.message.merchantName=this.merchant.shopName
                    this.add_message()
                })
            },
            add_message(){
                this.$axios.post("/merchant_add_one_message", this.message).then(res => {

                   console.log(res)
                    this.$router.push("/merchant")
                })
            }

        }
    }
</script>

<style scoped>

</style>