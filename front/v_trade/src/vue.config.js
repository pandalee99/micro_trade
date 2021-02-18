module.exports = {
    configureWebpack:{
        externals: {
            'vue': 'Vue',
            //包名 ： 全局变量
            'jquery' : '$',
            'QC': 'QC',
        }
    },
    devServer: {
        // 项目运行时候的端口号
        port: 4000
    }
};
