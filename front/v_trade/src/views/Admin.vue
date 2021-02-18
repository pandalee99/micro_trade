<template>
    <Header></Header>
</template>

<script>
    import Header from "../components/Header";
    export default {
        name: "Admin",
        components: {Header},

        created(){
            if (this.$store.getters.getUser.role!='ROLE_ADMIN'){
                const  _this=this
                alert("没有admin权限")
                _this.$router.push("/login")
            }

        }
    }
</script>

<style scoped>

</style>