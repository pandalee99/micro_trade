<template>
    <div>
        <NavMenu></NavMenu>
        <el-timeline :reverse="reverse">
            <el-timeline-item
                    v-for="(m, index) in message"
                    :key="index"
                    :timestamp="m.moveNewCreatTime"
            ><div>
                <h4>商家：</h4>
                <h4>推送消息：{{m.moveNewName}}</h4>
                <div class="text item">{{m.moveNewContent}}</div>
                <el-image class="omage" :src="m.moveNewImg"></el-image>
            </div>

            </el-timeline-item>
        </el-timeline>
    </div>
</template>

<script>
    import NavMenu from "@/components/NavMenu";
    export default {
        name: "MyCare",
        components: {NavMenu},
        data(){
            return{
                reverse:true,
                message:[{
                    id:"0",
                    merchantId:"0",
                    moveNewName:"str",
                    moveNewCreatTime:"1611920322936",
                    moveNewContent:"str",
                    moveNewImg:"str",
                    merchantName:"",

                }],
            }
        },
        created(){
            this.require_user_care_merchant_message()

        },
        methods:{
            require_user_care_merchant_message(){
                this.$axios.get('/require_user_care_merchant_message/'+this.$store.getters.getUser.id).then(
                    res=> {
                        this.message=res.data.data
                    })
            }
        }
    }
</script>

<style scoped>
    .omage{
        height: 150px;
        width: 150px;
        /*margin: 10px 5px 15px 20px;*/
    }
</style>