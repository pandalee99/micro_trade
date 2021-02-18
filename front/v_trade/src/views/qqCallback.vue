<template>
    <div></div>
</template>

<script>
    export default {
        name: "qqCallback",
        mounted() {
            var accessToken = this.$utils.getUrlKey("access_token");
            var code = this.$utils.getUrlKey("code");
            console.log(accessToken)
            console.log(code)
            //client_side模式
            if (accessToken && typeof accessToken != "undefined") {
                console.log("client_side模式:" + accessToken);
                // eslint-disable-next-line no-undef
                if (QC.Login.check()) {
                    this.$message.info("qq成功登录");
                    // eslint-disable-next-line no-undef
                    console.log(QC)
                    // this.$store.dispatch("user/qqlogin", accessToken).then(() => {
                    //     // this.$router.push("/");
                    // });
                }
            }

            //server-side模式
            if (code && typeof code != "undefined") {
                console.log("server-side模式:" + code);
                //获取到token就是已经登录了
                var token = this.$store.getters.getmyToken;
                if (token && typeof token != "undefined") {
                    // this.$router.push("/");
                    console.log("token && typeof token != undefined")
                }
                //未登录则执行登录
                else {
                    // this.$store.dispatch("user/qqCodelogin", code).then(() => {
                    //     location.reload();
                    // });
                    console.log("未登录")
                }
            }
        },
    };
</script>

<style scoped>

</style>