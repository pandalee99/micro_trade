<template>
    <el-carousel :interval="5000" arrow="always" class="size" style="width: 1000px; height: 450px">
        <el-carousel-item v-for="(item,index) in urls" :key="index" style="width: 950px; height: 450px">
<!--            <h3>{{ item }}</h3>-->

<!--            <img :src="item.img">-->
            <el-image
                    style="width: 1000px; height: 450px"
                    :src="item.img"
                    ></el-image>
        </el-carousel-item>
    </el-carousel>
</template>

<script>
    export default {
        name: "Carousel",
        data(){
            return{
                urls:[{
                    img:"https://img12.360buyimg.com/pop/s1180x940_jfs/t1/144204/24/14910/80404/5fb52f32E1431d33c/a6c82e4fc1ff8954.jpg.webp",
                },{
                    img:"https://imgcps.jd.com/ling4/819172/57K-6YCJ5aW954mp5o6o6I2Q/54iG5qy-55u06ZmN/p-5bd8253082acdd181d02f9f2/008e23bd/cr/s/q.jpg"

                },{
                    img:"https://img11.360buyimg.com/pop/s1180x940_jfs/t1/165383/22/4017/95648/600f774bE238287d5/3290fb6eae5fb988.jpg.webp"
                },
                    {
                        img:"https://img20.360buyimg.com/da/s1180x940_jfs/t1/130687/18/20052/58247/5fd97507Ef79f100a/5272a3089c9fa5a0.jpg.webp"
                    },
                    {
                        img:"https://img11.360buyimg.com/pop/s1180x940_jfs/t1/157123/21/2825/98877/5ffbe700E10513281/6f69556e2cc58b2c.jpg.webp"
                    }
                ],
                fits: ['fill', 'contain', 'cover', 'none', 'scale-down'],
            }
        }
    }
</script>

<style scoped>
    .size{
        margin-bottom: 5px;
    }
    .el-carousel__item h3 {
        color: #475669;
        font-size: 18px;
        opacity: 0.75;
        line-height: 300px;
        margin: 0;
    }

    .el-carousel__item:nth-child(2n) {
        background-color: #99a9bf;
    }

    .el-carousel__item:nth-child(2n+1) {
        background-color: #d3dce6;
    }
</style>