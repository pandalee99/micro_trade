<template>

    <div>
        <NavMenu></NavMenu>

        <div class="block">
            <el-timeline>
                <el-timeline-item v-for="m in merchants" :key="m.merchantId" placement="top">
                    <el-card>
                        <h4>{{m.shopName}}</h4>
                        <el-row>
                            <el-col :span="12"><div class="grid-content bg-purple">
                                <el-image class="shop_image" :src="m.merchantImg"> </el-image>
                            </div></el-col>
                            <el-col :span="12"><div class="grid-content bg-purple-light">
                                <el-button class="shop_right" type="warning" @click="delete_care(m.merchantId)">取消关注</el-button>
                            </div></el-col>
                        </el-row>

                        <h4>{{m.merchantDescription}}</h4>
                    </el-card>
                </el-timeline-item>

            </el-timeline>
        </div>
    </div>
</template>

<script>
    import NavMenu from "@/components/NavMenu";
    export default {
        name: "UserCare",
        components: {NavMenu},
        data(){
            return{
                merchants:[{
                    merchantId:"0",
                    userId:"0",
                    merchantName:"str",
                    shopName:"str",
                    merchantImg:"str",
                    merchantDescription:"str",

                }],
            }
        },
        created() {
            this.$axios.get('/get_all_merchant_by_user_id/'+this.$store.getters.getUser.id).then(res=>
            {
                this.merchants=res.data.data
                // console.log(this.merchants)
                // console.log(_this.lists)

            })
        },
        methods:{
            created_user_care() {
                this.$axios.get('/get_all_merchant_by_user_id/'+this.$store.getters.getUser.id).then(res=>
                {
                    this.merchants=res.data.data
                    // console.log(this.merchants)
                    // console.log(_this.lists)

                })
            },

            delete_care(id){
                // console.log(id)
                this.$axios.get('/delete_focus/'+id+"/"+this.$store.getters.getUser.id).then(res=>
                {
                    console.log(res)
                    this.$message("取消关注成功")
                    this.created_user_care()


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