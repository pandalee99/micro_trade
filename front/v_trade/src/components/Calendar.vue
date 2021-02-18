<template>
    <el-calendar v-model="value">
    </el-calendar>


</template>

<script>
    export default {
        name: "Calendar",
        data() {
            return {
                value: new Date()
            }
        }
    }
</script>

<style scoped>

</style>