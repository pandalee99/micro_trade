<template>
    <div>
    <NavMenu></NavMenu>
        <div class="block">
            <el-timeline>
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
                    <el-button class="collection_right" type="warning" @click="delete_collection(p.id)">取消收藏</el-button>
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
        name: "collection",
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
            }
        },
        created() {
            this.$axios.get('/get_all_collection_by_user_id/'+this.$store.getters.getUser.id).then(res=>
            {
                this.products=res.data.data
                // console.log(this.merchants)
                // console.log(_this.lists)

            })

        },
        methods:{
            created_user_collection() {
                this.$axios.get('/get_all_collection_by_user_id/'+this.$store.getters.getUser.id).then(res=>
                {
                    this.products=res.data.data
                    // console.log(this.merchants)
                    // console.log(_this.lists)

                })
            },

            delete_collection(id){
                // console.log(id)
                this.$axios.get('/delete_collection/'+id+"/"+this.$store.getters.getUser.id).then(res=>
                {
                    console.log(res)
                    this.$message("取消收藏成功")
                    this.created_user_collection()



                })
            }
        }
    }
</script>

<style scoped>
    .collection_image{
        width: 100px;
        height: 100px;
    }
    .collection_right{
        float: right;
    }
</style>