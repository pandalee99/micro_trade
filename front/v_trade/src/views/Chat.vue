<template>
    <div>
        <NavMenu></NavMenu>
        <div style="width: 800px; height: 600px">
            <div v-for="(m,index) in messages" :key="index" >

                <div :class = "{leftCss:m.isSend=='0',rightCss:m.isSend=='1'}">

                    <el-card shadow="hover">
                        {{m.content}}
                    </el-card>
                </div><br><br><br><br>
<!--                <div>{{m.content}}</div>-->
            </div>

        </div>
        <el-row>
            <el-col :span="20"><div class="grid-content bg-purple">
                <el-input v-model="send.content" ></el-input>
            </div></el-col>
            <el-col :span="4"><div class="grid-content bg-purple-light">

                <el-button type="primary" @click="send_message()">发送</el-button>

            </div></el-col>
        </el-row>

    </div>
</template>

<script>
    import io from 'socket.io-client'
    import NavMenu from "@/components/NavMenu";
    export default {
        name: "Chat",
        components: {NavMenu},
        data(){
            return{
             messages:[{
                id:"",
                isSend:"",
                createTime:"",
                content:"",
                userId:"",
                talkerId:"",

            }],
                send:{
                    id:"",
                    isSend:"",
                    createTime:"",
                    content:"",
                    userId:"",
                    talkerId:"",

                }
            }
        },
        created(){
            this.get_user_and_friend_messages()

        },
        mounted () {
            let _this = this
            // console.log('loginUser='+this.$store.getters.getUser.id)
            //本地地址
            // const url='http://localhost:9001'
            //服务器地址
            const url='http://sodse.com:9001'
            let opts = {
                // query: 'loginUser=1'
              query: 'loginUser='+this.$store.getters.getUser.id
            //     query: 'loginUser=1'
            }
            // socketIo连接的服务器信息，就是我们后端配置的信息
            let socket = io.connect(url, opts)
            socket.on('connect', function () {
                console.log('连接成功')
            })
            // 接收后端发送过来的消息
            socket.on('push_event', function (res) {
                console.log(res.content)
                // _this.messages.push({isSend: "0", content: "res.content"})
                // console.log(_this.messages)
                _this.add_friend_message(res.content)
                // _this.get_user_and_friend_messages()


            })
            socket.on('disconnect', function () {
                console.log('已经下线')
            })
        },
        methods:{
            send_message(){
                this.send.userId=this.$store.getters.getUser.id
                this.send.talkerId=this.$route.params.FriendId
                this.send.isSend="1"
                console.log(this.send)
                this.$axios.post('/socket/send_message_to_friend',this.send).then(

                    res => {
                        console.log(res.data.data)
                        // this.get_user_and_friend_messages()
                        this.messages.push({isSend: "1", content: res.data.data.content})
                        this.send.content=""

                    }
                )
            },
            get_user_and_friend_messages(){
                const friendId=this.$route.params.FriendId
                this.$axios.get('/get_user_and_friend_messages/'+this.$store.getters.getUser.id+"/"+friendId).then(res=>
                {
                    this.messages=res.data.data

                })
            },
            add_friend_message(message){
                // console.log(message)
                this.messages.push({isSend: "0", content: message})
                // console.log("测试")
            }
        }


    }

</script>

<style scoped>
    .leftCss{
        float: left;
    }
    .rightCss{
        float: right;
    }

</style>