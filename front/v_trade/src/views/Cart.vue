<template>
    <div>
        <NavMenu></NavMenu>
        <ShopCart></ShopCart>
    </div>
</template>

<script>
    import NavMenu from "@/components/NavMenu";
    import ShopCart from "@/components/ShopCart";
    export default {
        name: "Cart",
        components: {ShopCart, NavMenu}
    }
</script>

<style scoped>

</style>