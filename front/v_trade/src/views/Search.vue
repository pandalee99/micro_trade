<template>
    <div>
        <NavMenu></NavMenu>
        <el-row>
            <el-col :span="8" v-for="p in lists" :key="p.id"  style="width: 320px; height: 350px">
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
        name: "Search",
        components: {NavMenu},
        data() {
            return {
                lists: {
                    p: {
                        id: "1",
                        mainImg: "https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png",
                        name: "Test",
                        created: new Date()
                    }
                }
            };
        },
        created(){
            this.get_AllProduct_by_name()

        },
        methods:{

            get_AllProduct_by_name(){
                const _this=this

                _this.$axios.get("/es_search_product_by_name/" + _this.$route.params.name).then(res => {
                    _this.lists = res.data.data
                })
            }
        }
    }
</script>

<style scoped>
    .time {
        font-size: 13px;
        color: #999;
    }

    .bottom {
        margin-top: 13px;
        line-height: 12px;
    }

    .button {
        padding: 0;
        float: right;
    }

    .image {
        width: 60%;
        display: block;
    }

    .clearfix:before,
    .clearfix:after {
        display: table;
        content: "";
    }

    .clearfix:after {
        clear: both
    }
</style>