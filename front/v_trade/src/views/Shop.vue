<template>
	
    <div>
<!--        <Header></Header>-->
        <NavMenu></NavMenu>
        <Carousel></Carousel>
<!--      <Breadcrumb></Breadcrumb>-->

        <el-row>
<!--            <el-col :span="8" v-for="p in lists" :key="p.id" :offset="index > 0 ? 2 : 0" >-->
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


        <el-pagination class="mpage"
                       background
                       layout="prev, pager, next"
                       :current-page="currentPage"
                       :page-size="pageSize"
                       :total="total"
                       @current-change=page>
        </el-pagination>

    </div>
	
</template>

<style>
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

<script>

    // import QC from 'QC'
    import NavMenu from "@/components/NavMenu";
    import Carousel from "@/components/Carousel";
    export default {
        name: "Shop",
        components: {Carousel, NavMenu},
        data() {
            return {
                currentDate: new Date(),
                currentPage: 1,
                total: 0,
                pageSize: 5,
                lists: {
                    p: {
                        id: "1",
                        mainImg: "https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png",
                        name: "Test",
                        created: new Date()
                    }
                },
                test:{
                    id:"",
                    username:"",
                }
            };
        },
        methods: {
            page(currentPage) {
                const _this = this
                _this.$axios.get("/products?currentPage=" + currentPage).then(res => {
                    console.log(res)
                    _this.lists = res.data.data.lists
                    _this.currentPage = res.data.data.currentPage
                    _this.total = res.data.data.total
                    _this.pageSize = res.data.data.pageSize
                })
            }
        },
        created() {
            this.page(1)


            // 检查是否登录
            // eslint-disable-next-line no-undef
            // if (QC.Login.check()) {
            //     // 该处的openId，accessToken就是后台需要的参数了，后台可以通过这些参数获取临时登录凭证，然后就是自己的逻辑了
            //
            //     console.log("QC.Login.check()")
            //     // eslint-disable-next-line no-undef
            //     QC.Login.getMe(function (openId, accessToken) {
            //         if (openId !== undefined) {
            //             //openId 是用户的唯一标识，也是需要存到数据库的
            //             console.log(openId)
            //             console.log('opendId and accessToken-------------------------------')
            //             console.log(accessToken)
            //             // 用JS SDK调用OpenAPI
            //             console.log('accessToken-and  qqParam-------------------')
            //             console.log(this.qqParam)
            //             // eslint-disable-next-line no-undef
            //             QC.api('get_user_info', this.qqParam)
            //                 // 指定接口访问成功的接收函数，s为成功返回Response对象
            //                 .success(function (s) {
            //                     // 成功回调，通过s.data获取OpenAPI的返回数据
            //                     console.log('---------------------------------------------')
            //                     console.log(s.data)
            //                     //我把调用成功的返回数据打印到控制台，可以把这些参数发请求到后台，存入数据库
            //                     // this.$api.post('api/qqLogin', this.qqParam).then(res => {
            //                     //     if (res.code === 'success') {
            //                     //         console.log(res)
            //                     //     }
            //                     // })
            //                 })
            //                 // 指定接口访问失败的接收函数，f为失败返回Response对象
            //                 // eslint-disable-next-line no-unused-vars
            //                 .error(function (f) {
            //                     // 失败回调
            //                     alert('获取用户信息失败！')
            //                 })
            //             // this.$router.push({path: '/home'})//登录成功我处理完后跳转到首页了
            //         }
            //     })
            //     console.log('已登录!')
            //     this.$message.info('qq成功登录')
            // } else {
            //     console.log('未登录')


        //     }
        },
        mounted() {
            // eslint-disable-next-line no-undef
            // if (QC.Login.check()) {
            //     // this.$message.info("qq成功登录");
            //     console.log(this.$route.params.access_token);
            //     // var accessToken = this.$utils.getUrlKey("access_token");
            //     // console.log(accessToken);
            // }}

        }


    }
</script>
<!--<script type="text/javascript" src="http://qzonestyle.gtimg.cn/qzone/openapi/qc_loader.js" data-callback="true"-->
<!--        data-appid="101881248" data-redirecturi="http://www.sodse.com/shop" charset="utf-8">-->
<!--</script>-->



<style scoped>
    .mpage{
        margin: 0 auto;
        text-align: center;
    }
</style>