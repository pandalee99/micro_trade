<template>
    <div>
        <NavMenu></NavMenu>
        <div class="block">
            <el-timeline :reverse="reverse" >
                <el-timeline-item v-for="p in products" :key="p.id" placement="top">
                    <el-row>
                        <el-col :span="20"><div class="grid-content bg-purple">
                    <router-link :to="{name: 'ProductDetail' , params: {ProductId: p.id} } ">
                        <el-card>
                            <h4>{{p.name}}</h4>
                            <el-row>
                                <el-col :span="12"><div class="grid-content bg-purple">
                                    <!--                                <el-image class="collection_image" :src="p.mainImg">-->
                                    <el-row>
                                        <el-col :span="8"><div class="grid-content bg-purple">
                                            <el-image class="collection_image" :src="p.mainImg"> </el-image>
                                        </div></el-col>
                                        <el-col :span="16"><div class="grid-content bg-purple-light">
                                            <h5>{{p.price}}</h5>
                                            <h5>{{p.properties1}}</h5>
                                            <h5>{{p.properties2}}</h5>
                                            <!--                                            <el-button class="collection_right" @click="delete_collection(p.id)">取消收藏</el-button>-->
                                        </div></el-col>
                                    </el-row>
                                    <!--                                </el-image>-->
                                </div></el-col>
                                <el-col :span="12"><div class="grid-content bg-purple-light">

                                </div></el-col>
                            </el-row>


                        </el-card></router-link>
                        </div></el-col>
                        <el-col :span="4"><div class="grid-content bg-purple-light">
                            <el-button class="collection_right" @click="delete_user_browsing_history(p.id)">删除记录</el-button>
                        </div></el-col>
                    </el-row>
                </el-timeline-item>

            </el-timeline>
        </div>
    </div>
</template>

<script>
    import NavMenu from "@/components/NavMenu";
    export default {
        name: "UserBrowsingHistory",
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
                reverse:true,
            }
        },
        created() {
            this.$axios.get('/get_user_browsing_history_by_user_id/'+this.$store.getters.getUser.id).then(res=>
            {
                this.products=res.data.data
                // console.log(this.merchants)
                // console.log(_this.lists)

            })

        },
        methods:{
            created_user_browsing_history() {
                this.$axios.get('/get_user_browsing_history_by_user_id/'+this.$store.getters.getUser.id).then(res=>
                {
                    this.products=res.data.data
                    // console.log(this.merchants)
                    // console.log(_this.lists)

                })
            },

            delete_user_browsing_history(id){
                // console.log(id)
                this.$axios.get('/delete_user_browsing_history/'+id+"/"+this.$store.getters.getUser.id).then(res=>
                {
                    console.log(res)
                    this.$message("取消收藏成功")
                    this.created_user_browsing_history()



                })
            }
        }
    }
</script>

<style scoped>

</style>