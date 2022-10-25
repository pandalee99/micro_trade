

## 测试版本移除了eureka依赖，添加了虚拟机配置，改了一些错误代码，更容易运行



yml改为了虚拟机地址，当然你也可以继续使用localhost

```
url: jdbc:mysql://192.168.17.129:3306/micro_trade?useSSL=false&serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf8
```



原版必须启动eureka之后才能继续启动主服务，这个版本不用启动eureka和admin，节省了测试时间



删除了一些错误的SQL语句



添加了数据源

