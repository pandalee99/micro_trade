package com.sodse.trade;

import com.sodse.trade.common.dot.ForDto;
import com.sodse.trade.domain.*;
import com.sodse.trade.elasticsearch.product.ProductRepository;
import com.sodse.trade.redis.service.OrderRedis;
import com.sodse.trade.redis.utils.SerializeUtil;
import com.sodse.trade.service.*;
import com.sodse.trade.tools.snow.IdWorker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.redis.connection.jedis.JedisUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
class TradeApplicationTests  {


    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @Autowired
    UserFriendService userFriendService;

    @Autowired
    MerchantsService merchantsService;

    @Autowired
    BankCardService bankCardService;

    @Autowired
    UserInfoService userInfoService;

    @Autowired
    MerchantProductService merchantProductService;

    @Autowired
    OrderSheetService orderSheetService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRedis orderRedis;

    @Autowired
    ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Test
    void find_user_test(){

        User user= userService.selectById(1L);
        System.out.println(user);
        User user2= userService.selectOneByUsername("test");
        System.out.println(user2);
        //找出问题了，只能传入大写。小写识别不了


    }

    @Test
    void add_user_friend_test(){


        List<User> users=userService.find();
        for (User user:users) {
            IdWorker id=
                    new IdWorker(
                            1 + (((long) (new Random().nextDouble() * (10 - 1)))),
                            1 + (((long) (new Random().nextDouble() * (10 - 1)))));
            UserFriend userFriend=new UserFriend();
            userFriend.setId(id.nextId());
            userFriend.setUserId(user.getId());
            userFriend.setFriendId(1L);
            userFriend.setNoteName("小伙伴");
            userFriendService.insert(userFriend);

        }
    }


    @Test
    void 雪花算法测试 (){
        System.out.println("测试，生成10个唯一ID ：");
        for (int i = 0; i <10 ; i++) {
            IdWorker id=
                    new IdWorker(
                            1 + (((long) (new Random().nextDouble() * (10 - 1)))),
                            1 + (((long) (new Random().nextDouble() * (10 - 1)))));

            System.out.println(id.nextId());
        }

    }

    @Test
    void jedisTest4(){
        Jedis jedis = null;
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
        jedis = pool.getResource();
        try {
            OrderSheet r=new OrderSheet();
            r.setUserId(124L);
            r.setProductId(885036L);

            orderRedis.addOrderByRedis(r);

            List<byte[]> bytes=jedis.lrange("order_product_885036".getBytes(), 0, -1);
            for (byte[] b:bytes) {
                OrderSheet o =(OrderSheet) SerializeUtil.unserialize(b);
                System.out.println(o.getUserId());
            }


        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
/// ... 当关闭应用程序时:
        pool.destroy();
    }


    @Test
    void jedisTest3(){
        Jedis jedis = null;
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
        jedis = pool.getResource();
        try {
            if (!jedis.exists("product_stock_885036")){
                byte[] bytes = jedis.get("get_product_885036".getBytes());
                Product p =(Product) unSerialize(bytes);
                jedis.set("product_stock_885036",p.getStock()+"");
            }else {
                if (jedis.get("product_stock_885036").equals("2999")){
                    System.out.println("null");
                }
                jedis.decrBy("product_stock_885036" , 1);
            }
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
/// ... 当关闭应用程序时:
        pool.destroy();
    }

    @Test
    void jedisTest2(){
        Jedis jedis = null;
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
        try {
            jedis = pool.getResource();
            /// ... 执行相关的Redis操作
            byte[] bytes = jedis.get("get_product_885036".getBytes());
            Product p =(Product) SerializeUtil.unserialize(bytes);
            System.out.println(p.getName());
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
/// ... 当关闭应用程序时:
        pool.destroy();
    }

    public static Object unSerialize(byte[] bytes){
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            //将字节数组读取入输入流中
            return objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    void jedisTest(){
        Jedis jedis = null;
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
        try {
            jedis = pool.getResource();
            /// ... 执行相关的Redis操作
            jedis.set("foo", "bar");
            String foobar = jedis.get("foo");
            jedis.zadd("sose", 0, "car");
            jedis.zadd("sose", 0, "bike");
            Set<String> sose = jedis.zrange("sose", 0, -1);
            System.out.println(sose);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
/// ... 当关闭应用程序时:
        pool.destroy();
    }

    @Test
    void product_es_test4(){
        productRepository.deleteAll();

    }

    @Test
    void product_es_test3(){

        List<Product> products = productRepository.findAllByNameLike("手机");
        for (Product p:products) {
            System.out.println(p.getName());
        }

    }
    @Test
    public void es_Create() {
        // 配置映射，会根据Item类中的id、Field等字段来自动完成映射
        elasticsearchRestTemplate.putMapping(Product.class);
        // 创建索引，会根据Item类的@Document注解信息来创建
//        elasticsearchRestTemplate.createIndex(Product.class);

    }

    @Test
    public void es_Delete() {
        productRepository.deleteAll();
        elasticsearchRestTemplate.deleteIndex(Product.class);
    }

    @Test
    void product_es_test2(){
    productRepository.saveAll(productService.find());
    }

    @Test
    void product_es_test(){
        Product p=new Product();
        p.setId(2L);
        p.setName("手机");
        p.setPrice(new BigDecimal(100));
        p.setContent("这是一件物品");
//        productRepository.index(p);
        productRepository.save(p);


    }

    @Test
    void insert_user_test(){
    User user=new User();
    user.setUsername("test2");
    user.setId(2L);
    user.setPassword(new BCryptPasswordEncoder().encode("123456"));
    userService.insert(user);
        System.out.println(user);
    User user2= userService.selectOneByUsername("test2");
        System.out.println(user2);


    }



    @Test
    void changeuserlevel(){

        List<User> users=userService.find();
        for (User user:users) {
            user.setLevel(2);
            userService.updateByPrimaryKey(user);
        }
    }

    @Test//删除所有订单信息
    void delete_order_sheet(){
        orderSheetService.delete();
    }

    @Test
    void changemerchantimages(){
        List<Merchants> merchants=merchantsService.findAll();
        for (Merchants m:merchants) {
            m.setMerchantImg("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=426603537,3178524016&fm=26&gp=0.jpg");
            merchantsService.updateByPrimaryKey(m);

        }
    }

    @Test
    void produce_date(){
        String time= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(time);
    }


    @Test
    void addmerchant_product(){
        List<Product> products=productService.find();
        IdWorker id=
                new IdWorker(
                        1 + (((long) (new Random().nextDouble() * (10 - 1)))),
                        1 + (((long) (new Random().nextDouble() * (10 - 1)))));

        for (Product p:products) {
            MerchantProduct merchantProduct=new MerchantProduct();
            merchantProduct.setId(id.nextId());
            merchantProduct.setProductId(p.getId());
            Merchants merchants=new Merchants();
//            List<Merchants> merchants=new ArrayList<>();
//            merchants=merchantsService.selectByMerchantName(p.getMerchant());
//            merchantProduct.setMerchantId(merchants.get(0).getMerchantId());
            merchants=merchantsService.selectOneByMerchantName(p.getMerchant());
            merchantProduct.setMerchantId(merchants.getMerchantId());
            merchantProductService.insert(merchantProduct);
        }
    }

    @Test
    void updataproduct(){
        List<Product> products=productService.find();
        for (Product p:products) {
            if (p.getMerchant().equals("")){
                p.setMerchant("个人商铺");
                productService.updateByPrimaryKey(p);
            }
        }
    }

    @Test
    void deletemer(){
        merchantsService.delete();
        bankCardService.delete();
        userInfoService.delete();
        userService.delete();
    }
    @Test
    void updatamer(){
        List<Merchants> merchants=merchantsService.findAll();
        for (Merchants m:merchants) {
            if (m.getShopName().equals("")){
                m.setMerchantName("个人商铺");
                m.setShopName("个人商铺");
                merchantsService.updateByPrimaryKey(m);

            }
        }
    }

    @Test
    void testmernull(){
        if (merchantsService.findOneByMerchantName("t")==null){
            System.out.println("1");
        }
        else {
            System.out.println("2");
        }
    }

    @Test
    void addAllDataSource(){

        List<Product> products=productService.find();
        for (Product p:products) {
            //首先是商家表
//            Merchants merchanttest=new Merchants();
            //ms.get(0).getMerchantName().equals("")
//            List<Merchants> ms=new ArrayList<>();

//            ms=merchantsService.selectByMerchantName(p.getMerchant());
            if (merchantsService.findOneByMerchantName(p.getMerchant())==null){
                Merchants merchants=new Merchants();
                IdWorker id1=
                        new IdWorker(
                                1 + (((long) (new Random().nextDouble() * (10 - 1)))),
                                1 + (((long) (new Random().nextDouble() * (10 - 1)))));
                IdWorker id2=
                        new IdWorker(
                                1 + (((long) (new Random().nextDouble() * (10 - 1)))),
                                1 + (((long) (new Random().nextDouble() * (10 - 1)))));

                merchants.setMerchantId(id1.nextId());
                merchants.setMerchantDescription("");
                merchants.setUserId(id2.nextId());
                merchants.setMerchantName(p.getMerchant());
                merchants.setShopName(p.getMerchant());
                merchants.setMerchantImg(p.getMainImg());
                merchants.setMerchantDescription("商家的描述"+p.getMerchant()
                +p.getBrand()+p.getCategory());
                merchantsService.insert(merchants);
                //用户信息表

                User user=new User();
                user.setId(merchants.getUserId());
                Random rand = new Random();
                String username= getRandomJianHan(rand.nextInt(6)+1);
                user.setUsername(username);
                user.setPassword(new BCryptPasswordEncoder().encode("123456"));
                int randNum = new Random().nextInt(2) + 1;
                String sex=randNum==1? "男" : "女";
                user.setSex(sex);
                IdWorker id3=
                        new IdWorker(1,1 );
                user.setIdCard(id3.nextId());
                user.setIdImg("https://dss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3868409008,2344935399&fm=26&gp=0.jpg");
                user.setFlag(1);
                user.setLevel(1);
                user.setUserNickname(getRandomJianHan(3));
                user.setUserImg("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3563879038,322783869&fm=26&gp=0.jpg");
                user.setRoles("ROLE_USER");
                user.setMoney(new BigDecimal(100));
                IdWorker id4= new IdWorker(2,2 );
                user.setBankCard(id4.nextId());
                user.setDescription("这是个人介绍");
                userService.insert(user);
                //银行卡
                BankCard bankCard=new BankCard();
                IdWorker id5=
                        new IdWorker(
                                1 + (((long) (new Random().nextDouble() * (10 - 1)))),
                                1 + (((long) (new Random().nextDouble() * (10 - 1)))));
                bankCard.setId(id5.nextId());
                bankCard.setName(user.getUsername());
                int r2 = new Random().nextInt(888888) + 100000;
                bankCard.setPassword(r2);
                bankCardService.insert(bankCard);
                //用户地址
                for (int i = 0; i <3 ; i++) {


                UserInfo userInfo=new UserInfo();
                IdWorker id6=
                        new IdWorker(
                                1 + (((long) (new Random().nextDouble() * (10 - 1)))),
                                1 + (((long) (new Random().nextDouble() * (10 - 1)))));
                userInfo.setId(id6.nextId());
                userInfo.setAddress(getRandomJianHan(rand.nextInt(13)+1));
                userInfo.setName(user.getUserNickname());
                userInfo.setPhone((int) (rand.nextInt(888888888)+100000000));
                userInfo.setUserid(user.getId());
                userInfoService.insert(userInfo);

                }



            }

        }
    }

    @Test
    void idworker(){

        Merchants merchants=new Merchants();
        IdWorker id=
                new IdWorker(
                        1 + (((long) (new Random().nextDouble() * (10 - 1)))),
                        1 + (((long) (new Random().nextDouble() * (10 - 1)))));
        for (int i = 0; i <30 ; i++) {
            merchants.setMerchantId(id.nextId());
            System.out.println(merchants.getMerchantId());
        }
    }

    @Test
    void Datawatch(){
        Product product=productService.selectByPrimaryKey(971430l);
        String[] c=product.getContent().split("\n");
        List<ForDto> contents=new ArrayList<ForDto>();
        for (int i = 0; i <c.length ; i++) {
            ForDto content =new ForDto();
            content.setId(i+1);
            content.setName(c[i]);
            contents.add(content);
//            System.out.println(c[i]);
        }

    }

    @Test
    void dateconvetor(){
        List<Product> products= productService.find();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        int i=1;
        for (Product p:products) {
            Date date = randomDate("2017-01-01 ","2021-12-31");
//            p.setCreated(new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(date));
            p.setCreated(date);
            productService.updateByPrimaryKey(p);
            System.out.println("第 "+i+" 条成功");
            i++;



        }


    }

    Date randomDate(String beginDate,String endDate){
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date start = format.parse(beginDate);
            Date end = format.parse(endDate);

            if(start.getTime() >= end.getTime()){
                return null;
            }
            long date = random(start.getTime(),end.getTime());
            return new Date(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    long random(long begin,long end){
        long rtn = begin + (long)(Math.random() * (end - begin));
        if(rtn == begin || rtn == end){
            return random(begin,end);
        }
        return rtn;
    }


    @Test
    void adddatasource() {

        Product product=new Product();
        String category="食品";
        Random r = new Random();
        String url = "";
        int f=43;
        int p=56;
        for (int i = 0; i <50 ; i++,f=f+2,p=p+60) {


        url="https://search.jd.com/Search?keyword=食品&qrst=1&wq=食品&stock=1&page="+f+"&s="+p+"&click=0";
        Document doc = null;
        try {
            doc = Jsoup.connect(url).userAgent("Mozilla").get();//模拟火狐浏览器
        } catch (IOException e) {
            e.printStackTrace();
        }
        //这里根据在网页中分析的类选择器来获取列表所在的节点

        Elements lis= doc.getElementsByAttributeValue("class","gl-item");
                for (Element li:lis) {
//            System.out.println(li);
//            System.out.println("========================================");


//产品名称
                    Elements panme = li.select("em");
                    String name = panme.text();
                    System.out.println("产品名称：" + name.substring(2));
                    product.setName(name.substring(2));
//价格
                    Elements pprice = li.select("i");
                    String price = pprice.text();
//                    System.out.println("价格："+ price.substring(0, price.indexOf( ' ' ) ));
                    product.setPrice(new BigDecimal(price.substring(0, price.indexOf(' '))));
//            图片===============================
                    Elements img = li.select("div.p-img");
//            System.out.println(img);
                    Element imgUrl = img.select("img").first();
//            System.out.println(imgUrl);
                    String data_img = imgUrl.attr("data-lazy-img");

//            System.out.println("图片url："+ data_img);
                    product.setMainImg(data_img);
////            内容
//                    String sku =li.select("li").attr("data-sku");
////                    System.out.println(sku);
//                    System.out.println( addproductcontent(sku));
//                    try {
//                        Thread.sleep(3000);
//
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                    //品牌和商家暂时一样
                    String brand = li.select("span.J_im_icon").text();
//                    System.out.println("品牌："+ brand);
                    product.setMerchant(brand);
                    product.setBrand(brand);

                    //库存都为3000
                    Integer stock = (r.nextInt(1000) + 1) * 10;
                    Integer flag = 1;
                    new Date();
//                     快递费默认0
                    product.setStock(stock);
                    product.setFlag(flag);
                    product.setCreated(new Date());
                    product.setCourierFees(new BigDecimal(0));
                    //种类和开头搜索的一致
                    product.setCategory(category);

//            内容和 属性1和2
                    String sku = li.select("li").attr("data-sku");
//                    System.out.println(sku);
                    List<String> p3 = addproductcontent(sku);
//                    System.out.println( "内容："+ p3.get(0));
//                    System.out.println("属性一："+ p3.get(1));
//                    System.out.println("属性二："+ p3.get(2));
                    product.setContent(p3.get(0));
                    product.setProperties1(p3.get(1));
                    product.setProperties2(p3.get(2));
                    product.setId(Long.valueOf(sku));
                    try {
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //最后保存
                    if(productService.selectByPrimaryKey(product.getId())!=null){
                        System.out.println("商品已存在");
                        continue;
                    }

                    productService.insert(product);
                }


        }

//        Elements ul = div.select("ul.list-ul");
//        System.out.println(ul);
//        Elements lis = ul.select("li");//查找标签
//        for (Element li : lis) {
//            try {
//                Thread.sleep(200);//让线程操作不要太快 1秒一次 时间自己设置，主要是模拟人在点击
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            //获取所有详情的链接所在的节点
//            Elements img = li.select("img");
//            String imgUrl = img.get(0).attr("abs:src");
//            System.out.println(imgUrl);
//        }
    }


    List<String> addproductcontent(String sku){
//        String sku="100014348492";
        List<String> res=new ArrayList<String>();
        String result="";
        String url = "https://item.jd.com/"+sku+".html";
        Document doc = null;
        try {
            doc = Jsoup.connect(url).userAgent("Mozilla").get();//模拟火狐浏览器
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements lis= doc.getElementsByAttributeValue("class","parameter2 p-parameter-list").select("li");
        for (Element li:lis) {
//            System.out.println(li);
//            System.out.println("========================================");
            result=result+"\n"+li.text();
//            String text=li.text();
//            System.out.println(text);
            }
//        System.out.println(result);
        res.add(result);
        result=doc.getElementsByAttributeValue("id","choose-attr-1").select("i").text();
        res.add(result);
        result=doc.getElementsByAttributeValue("id","choose-attr-2").select("a").text();
        res.add(result);

        return res;




    }

//    String addproductproperties1(String sku) {
////        String sku="100014348492";
//        String result = "";
//        String url = "https://item.jd.com/" + sku + ".html";
//        Document doc = null;
//        try {
//            doc = Jsoup.connect(url).userAgent("Mozilla").get();//模拟火狐浏览器
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Elements lis = doc.getElementsByAttributeValue("class", "parameter2 p-parameter-list").select("li");
//        for (Element li : lis) {
////            System.out.println(li);
////            System.out.println("========================================");
//            result = result + "\n" + li.text();
////            String text=li.text();
////            System.out.println(text);
//        }
////        System.out.println(result);
//        return result;
//    }
    @Test
    void userandroles(){
        User user=userService.findByUsername("test").get(0);
        System.out.println(user.getRoles());
    }



    @Test
    void listisnull(){
        List<String> s=new ArrayList<>();
        if(s.isEmpty()){
            System.out.println("null");
            s.add("11");
            System.out.println(s.get(0));
        }
    }

    @Test
    void security() {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
//        $2a$10$yvtyrqSD5qOjyXuWnqMtkOWdy99BiM.CtTdmrTKW5GFRCdy1LgxIK
//        $2a$10$lWsdPcFApH8L31VMN2qx9.xJhSyJhARn.sC6j5BriIb8JcxpPGK7u
        BCryptPasswordEncoder code=new BCryptPasswordEncoder();

        //返回值是一个布尔型
        System.out.println(        code.matches(
                "123456",
                "$2a$10$yvtyrqSD5qOjyXuWnqMtkOWdy99BiM.CtTdmrTKW5GFRCdy1LgxIK"));
    }


    @Test
    void insert() {

        IdWorker idWorker=new IdWorker(1,1);
        Product product=new Product();
        product.setId(idWorker.nextId());
//        product.setBrandId(1);
//        product.setCategoryId(1);
        product.setContent("这是一件普通的物品");
        product.setCourierFees(new BigDecimal(8));
        product.setFlag(1);
        product.setMainImg("http://images.sodse.com/1001.png");
        product.setName("测试物品");
        product.setPrice(new BigDecimal(888.88));
        product.setStock(100);
        product.setProperties1("黑色,白色");
        product.setProperties2("m,l");
        product.setCreated(new Date());

        productService.insert(product);


    }

    @Test
    public void getName() {
        System.out.println(randomName(true, 3));//三位数
        System.out.println(getRandomJianHan(5));
    }

    public static String getRandomJianHan(int len) {
        String randomName = "";
        for (int i = 0; i < len; i++) {
            String str = null;
            int hightPos, lowPos; // 定义高低位
            Random random = new Random();
            hightPos = (176 + Math.abs(random.nextInt(39))); // 获取高位值
            lowPos = (161 + Math.abs(random.nextInt(93))); // 获取低位值
            byte[] b = new byte[2];
            b[0] = (new Integer(hightPos).byteValue());
            b[1] = (new Integer(lowPos).byteValue());
            try {
                str = new String(b, "GBK"); // 转成中文
            } catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
            randomName += str;
        }
        return randomName;
    }
    public static String randomName(boolean simple, int len) {
        String surName[] = {
                "赵","钱","孙","李","周","吴","郑","王","冯","陈","楮","卫","蒋","沈","韩","杨",
                "朱","秦","尤","许","何","吕","施","张","孔","曹","严","华","金","魏","陶","姜",
                "戚","谢","邹","喻","柏","水","窦","章","云","苏","潘","葛","奚","范","彭","郎",
                "鲁","韦","昌","马","苗","凤","花","方","俞","任","袁","柳","酆","鲍","史","唐",
                "费","廉","岑","薛","雷","贺","倪","汤","滕","殷","罗","毕","郝","邬","安","常",
                "乐","于","时","傅","皮","卞","齐","康","伍","余","元","卜","顾","孟","平","黄",
                "和","穆","萧","尹","姚","邵","湛","汪","祁","毛","禹","狄","米","贝","明","臧",
                "计","伏","成","戴","谈","宋","茅","庞","熊","纪","舒","屈","项","祝","董","梁",
                "杜","阮","蓝","闽","席","季","麻","强","贾","路","娄","危","江","童","颜","郭",
                "梅","盛","林","刁","锺","徐","丘","骆","高","夏","蔡","田","樊","胡","凌","霍",
                "虞","万","支","柯","昝","管","卢","莫","经","房","裘","缪","干","解","应","宗",
                "丁","宣","贲","邓","郁","单","杭","洪","包","诸","左","石","崔","吉","钮","龚",
                "程","嵇","邢","滑","裴","陆","荣","翁","荀","羊","於","惠","甄","麹","家","封",
                "芮","羿","储","靳","汲","邴","糜","松","井","段","富","巫","乌","焦","巴","弓",
                "牧","隗","山","谷","车","侯","宓","蓬","全","郗","班","仰","秋","仲","伊","宫",
                "宁","仇","栾","暴","甘","斜","厉","戎","祖","武","符","刘","景","詹","束","龙",
                "叶","幸","司","韶","郜","黎","蓟","薄","印","宿","白","怀","蒲","邰","从","鄂",
                "索","咸","籍","赖","卓","蔺","屠","蒙","池","乔","阴","郁","胥","能","苍","双",
                "闻","莘","党","翟","谭","贡","劳","逄","姬","申","扶","堵","冉","宰","郦","雍",
                "郤","璩","桑","桂","濮","牛","寿","通","边","扈","燕","冀","郏","浦","尚","农",
                "温","别","庄","晏","柴","瞿","阎","充","慕","连","茹","习","宦","艾","鱼","容",
                "向","古","易","慎","戈","廖","庾","终","暨","居","衡","步","都","耿","满","弘",
                "匡","国","文","寇","广","禄","阙","东","欧","殳","沃","利","蔚","越","夔","隆",
                "师","巩","厍","聂","晁","勾","敖","融","冷","訾","辛","阚","那","简","饶","空",
                "曾","毋","沙","乜","养","鞠","须","丰","巢","关","蒯","相","查","后","荆","红",
                "游","竺","权","逑","盖","益","桓","公","晋","楚","阎","法","汝","鄢","涂","钦",
                "岳","帅","缑","亢","况","后","有","琴","商","牟","佘","佴","伯","赏","墨","哈",
                "谯","笪","年","爱","阳","佟"};
        String doubleSurName[] = {"万俟","司马","上官","欧阳","夏侯","诸葛","闻人","东方",
                "赫连","皇甫","尉迟","公羊","澹台","公冶","宗政","濮阳","淳于","单于","太叔","申屠",
                "公孙","仲孙","轩辕","令狐","锺离","宇文","长孙","慕容","鲜于","闾丘","司徒","司空",
                "丌官","司寇","仉","督","子车","颛孙","端木","巫马","公西","漆雕","乐正","壤驷","公良",
                "拓拔","夹谷","宰父","谷梁","段干","百里","东郭","南门","呼延","归","海","羊舌","微生",
                "梁丘","左丘","东门","西门","南宫"};

        String[] word = {"一","乙","二","十","丁","厂","七","卜","人","入","八","九","几","儿","了","力","乃","刀","又",
                "三","于","干","亏","士","工","土","才","寸","下","大","丈","与","万","上","小","口","巾","山",
                "千","乞","川","亿","个","勺","久","凡","及","夕","丸","么","广","亡","门","义","之","尸","弓",
                "己","已","子","卫","也","女","飞","刃","习","叉","马","乡","丰","王","井","开","夫","天","无",
                "元","专","云","扎","艺","木","五","支","厅","不","太","犬","区","历","尤","友","匹","车","巨",
                "牙","屯","比","互","切","瓦","止","少","日","中","冈","贝","内","水","见","午","牛","手","毛",
                "气","升","长","仁","什","片","仆","化","仇","币","仍","仅","斤","爪","反","介","父","从","今",
                "凶","分","乏","公","仓","月","氏","勿","欠","风","丹","匀","乌","凤","勾","文","六","方","火",
                "为","斗","忆","订","计","户","认","心","尺","引","丑","巴","孔","队","办","以","允","予","劝",
                "双","书","幻","玉","刊","示","末","未","击","打","巧","正","扑","扒","功","扔","去","甘","世",
                "古","节","本","术","可","丙","左","厉","右","石","布","龙","平","灭","轧","东","卡","北","占",
                "业","旧","帅","归","且","旦","目","叶","甲","申","叮","电","号","田","由","史","只","央","兄",
                "叼","叫","另","叨","叹","四","生","失","禾","丘","付","仗","代","仙","们","仪","白","仔","他",
                "斥","瓜","乎","丛","令","用","甩","印","乐","句","匆","册","犯","外","处","冬","鸟","务","包",
                "饥","主","市","立","闪","兰","半","汁","汇","头","汉","宁","穴","它","讨","写","让","礼","训",
                "必","议","讯","记","永","司","尼","民","出","辽","奶","奴","加","召","皮","边","发","孕","圣",
                "对","台","矛","纠","母","幼","丝","式","刑","动","扛","寺","吉","扣","考","托","老","执","巩",
                "圾","扩","扫","地","扬","场","耳","共","芒","亚","芝","朽","朴","机","权","过","臣","再","协",
                "西","压","厌","在","有","百","存","而","页","匠","夸","夺","灰","达","列","死","成","夹","轨",
                "邪","划","迈","毕","至","此","贞","师","尘","尖","劣","光","当","早","吐","吓","虫","曲","团",
                "同","吊","吃","因","吸","吗","屿","帆","岁","回","岂","刚","则","肉","网","年","朱","先","丢",
                "舌","竹","迁","乔","伟","传","乒","乓","休","伍","伏","优","伐","延","件","任","伤","价","份",
                "华","仰","仿","伙","伪","自","血","向","似","后","行","舟","全","会","杀","合","兆","企","众",
                "爷","伞","创","肌","朵","杂","危","旬","旨","负","各","名","多","争","色","壮","冲","冰","庄",
                "庆","亦","刘","齐","交","次","衣","产","决","充","妄","闭","问","闯","羊","并","关","米","灯",
                "州","汗","污","江","池","汤","忙","兴","宇","守","宅","字","安","讲","军","许","论","农","讽",
                "设","访","寻","那","迅","尽","导","异","孙","阵","阳","收","阶","阴","防","奸","如","妇","好",
                "她","妈","戏","羽","观","欢","买","红","纤","级","约","纪","驰","巡","寿","弄","麦","形","进",
                "戒","吞","远","违","运","扶","抚","坛","技","坏","扰","拒","找","批","扯","址","走","抄","坝",
                "贡","攻","赤","折","抓","扮","抢","孝","均","抛","投","坟","抗","坑","坊","抖","护","壳","志",
                "扭","块","声","把","报","却","劫","芽","花","芹","芬","苍","芳","严","芦","劳","克","苏","杆",
                "杠","杜","材","村","杏","极","李","杨","求","更","束","豆","两","丽","医","辰","励","否","还",
                "歼","来","连","步","坚","旱","盯","呈","时","吴","助","县","里","呆","园","旷","围","呀","吨",
                "足","邮","男","困","吵","串","员","听","吩","吹","呜","吧","吼","别","岗","帐","财","针","钉",
                "告","我","乱","利","秃","秀","私","每","兵","估","体","何","但","伸","作","伯","伶","佣","低",
                "你","住","位","伴","身","皂","佛","近","彻","役","返","余","希","坐","谷","妥","含","邻","岔",
                "肝","肚","肠","龟","免","狂","犹","角","删","条","卵","岛","迎","饭","饮","系","言","冻","状",
                "亩","况","床","库","疗","应","冷","这","序","辛","弃","冶","忘","闲","间","闷","判","灶","灿",
                "弟","汪","沙","汽","沃","泛","沟","没","沈","沉","怀","忧","快","完","宋","宏","牢","究","穷",
                "灾","良","证","启","评","补","初","社","识","诉","诊","词","译","君","灵","即","层","尿","尾",
                "迟","局","改","张","忌","际","陆","阿","陈","阻","附","妙","妖","妨","努","忍","劲","鸡","驱",
                "纯","纱","纳","纲","驳","纵","纷","纸","纹","纺","驴","纽","奉","玩","环","武","青","责","现",
                "表","规","抹","拢","拔","拣","担","坦","押","抽","拐","拖","拍","者","顶","拆","拥","抵","拘",
                "势","抱","垃","拉","拦","拌","幸","招","坡","披","拨","择","抬","其","取","苦","若","茂","苹",
                "苗","英","范","直","茄","茎","茅","林","枝","杯","柜","析","板","松","枪","构","杰","述","枕",
                "丧","或","画","卧","事","刺","枣","雨","卖","矿","码","厕","奔","奇","奋","态","欧","垄","妻",
                "轰","顷","转","斩","轮","软","到","非","叔","肯","齿","些","虎","虏","肾","贤","尚","旺","具",
                "果","味","昆","国","昌","畅","明","易","昂","典","固","忠","咐","呼","鸣","咏","呢","岸","岩",
                "帖","罗","帜","岭","凯","败","贩","购","图","钓","制","知","垂","牧","物","乖","刮","秆","和",
                "季","委","佳","侍","供","使","例","版","侄","侦","侧","凭","侨","佩","货","依","的","迫","质",
                "欣","征","往","爬","彼","径","所","舍","金","命","斧","爸","采","受","乳","贪","念","贫","肤",
                "肺","肢","肿","胀","朋","股","肥","服","胁","周","昏","鱼","兔","狐","忽","狗","备","饰","饱",
                "饲","变","京","享","店","夜","庙","府","底","剂","郊","废","净","盲","放","刻","育","闸","闹",
                "郑","券","卷","单","炒","炊","炕","炎","炉","沫","浅","法","泄","河","沾","泪","油","泊","沿",
                "泡","注","泻","泳","泥","沸","波","泼","泽","治","怖","性","怕","怜","怪","学","宝","宗","定",
                "宜","审","宙","官","空","帘","实","试","郎","诗","肩","房","诚","衬","衫","视","话","诞","询",
                "该","详","建","肃","录","隶","居","届","刷","屈","弦","承","孟","孤","陕","降","限","妹","姑",
                "姐","姓","始","驾","参","艰","线","练","组","细","驶","织","终","驻","驼","绍","经","贯","奏",
                "春","帮","珍","玻","毒","型","挂","封","持","项","垮","挎","城","挠","政","赴","赵","挡","挺",
                "括","拴","拾","挑","指","垫","挣","挤","拼","挖","按","挥","挪","某","甚","革","荐","巷","带",
                "草","茧","茶","荒","茫","荡","荣","故","胡","南","药","标","枯","柄","栋","相","查","柏","柳",
                "柱","柿","栏","树","要","咸","威","歪","研","砖","厘","厚","砌","砍","面","耐","耍","牵","残",
                "殃","轻","鸦","皆","背","战","点","临","览","竖","省","削","尝","是","盼","眨","哄","显","哑",
                "冒","映","星","昨","畏","趴","胃","贵","界","虹","虾","蚁","思","蚂","虽","品","咽","骂","哗",
                "咱","响","哈","咬","咳","哪","炭","峡","罚","贱","贴","骨","钞","钟","钢","钥","钩","卸","缸",
                "拜","看","矩","怎","牲","选","适","秒","香","种","秋","科","重","复","竿","段","便","俩","贷",
                "顺","修","保","促","侮","俭","俗","俘","信","皇","泉","鬼","侵","追","俊","盾","待","律","很",
                "须","叙","剑","逃","食","盆","胆","胜","胞","胖","脉","勉","狭","狮","独","狡","狱","狠","贸",
                "怨","急","饶","蚀","饺","饼","弯","将","奖","哀","亭","亮","度","迹","庭","疮","疯","疫","疤",
                "姿","亲","音","帝","施","闻","阀","阁","差","养","美","姜","叛","送","类","迷","前","首","逆",
                "总","炼","炸","炮","烂","剃","洁","洪","洒","浇","浊","洞","测","洗","活","派","洽","染","济",
                "洋","洲","浑","浓","津","恒","恢","恰","恼","恨","举","觉","宣","室","宫","宪","突","穿","窃",
                "客","冠","语","扁","袄","祖","神","祝","误","诱","说","诵","垦","退","既","屋","昼","费","陡",
                "眉","孩","除","险","院","娃","姥","姨","姻","娇","怒","架","贺","盈","勇","怠","柔","垒","绑",
                "绒","结","绕","骄","绘","给","络","骆","绝","绞","统","耕","耗","艳","泰","珠","班","素","蚕",
                "顽","盏","匪","捞","栽","捕","振","载","赶","起","盐","捎","捏","埋","捉","捆","捐","损","都",
                "哲","逝","捡","换","挽","热","恐","壶","挨","耻","耽","恭","莲","莫","荷","获","晋","恶","真",
                "框","桂","档","桐","株","桥","桃","格","校","核","样","根","索","哥","速","逗","栗","配","翅",
                "辱","唇","夏","础","破","原","套","逐","烈","殊","顾","轿","较","顿","毙","致","柴","桌","虑",
                "监","紧","党","晒","眠","晓","鸭","晃","晌","晕","蚊","哨","哭","恩","唤","啊","唉","罢","峰",
                "圆","贼","贿","钱","钳","钻","铁","铃","铅","缺","氧","特","牺","造","乘","敌","秤","租","积",
                "秧","秩","称","秘","透","笔","笑","笋","债","借","值","倚","倾","倒","倘","俱","倡","候","俯",
                "倍","倦","健","臭","射","躬","息","徒","徐","舰","舱","般","航","途","拿","爹","爱","颂","翁",
                "脆","脂","胸","胳","脏","胶","脑","狸","狼","逢","留","皱","饿","恋","桨","浆","衰","高","席",
                "准","座","脊","症","病","疾","疼","疲","效","离","唐","资","凉","站","剖","竞","部","旁","旅",
                "畜","阅","羞","瓶","拳","粉","料","益","兼","烤","烘","烦","烧","烛","烟","递","涛","浙","涝",
                "酒","涉","消","浩","海","涂","浴","浮","流","润","浪","浸","涨","烫","涌","悟","悄","悔","悦",
                "害","宽","家","宵","宴","宾","窄","容","宰","案","请","朗","诸","读","扇","袜","袖","袍","被",
                "祥","课","谁","调","冤","谅","谈","谊","剥","恳","展","剧","屑","弱","陵","陶","陷","陪","娱",
                "娘","通","能","难","预","桑","绢","绣","验","继","球","理","捧","堵","描","域","掩","捷","排",
                "掉","堆","推","掀","授","教","掏","掠","培","接","控","探","据","掘","职","基","著","勒","黄",
                "萌","萝","菌","菜","萄","菊","萍","菠","营","械","梦","梢","梅","检","梳","梯","桶","救","副",
                "票","戚","爽","聋","袭","盛","雪","辅","辆","虚","雀","堂","常","匙","晨","睁","眯","眼","悬",
                "野","啦","晚","啄","距","跃","略","蛇","累","唱","患","唯","崖","崭","崇","圈","铜","铲","银",
                "甜","梨","犁","移","笨","笼","笛","符","第","敏","做","袋","悠","偿","偶","偷","您","售","停",
                "偏","假","得","衔","盘","船","斜","盒","鸽","悉","欲","彩","领","脚","脖","脸","脱","象","够",
                "猜","猪","猎","猫","猛","馅","馆","凑","减","毫","麻","痒","痕","廊","康","庸","鹿","盗","章",
                "竟","商","族","旋","望","率","着","盖","粘","粗","粒","断","剪","兽","清","添","淋","淹","渠",
                "渐","混","渔","淘","液","淡","深","婆","梁","渗","情","惜","惭","悼","惧","惕","惊","惨","惯",
                "寇","寄","宿","窑","密","谋","谎","祸","谜","逮","敢","屠","弹","随","蛋","隆","隐","婚","婶",
                "颈","绩","绪","续","骑","绳","维","绵","绸","绿","琴","斑","替","款","堪","搭","塔","越","趁",
                "趋","超","提","堤","博","揭","喜","插","揪","搜","煮","援","裁","搁","搂","搅","握","揉","斯",
                "期","欺","联","散","惹","葬","葛","董","葡","敬","葱","落","朝","辜","葵","棒","棋","植","森",
                "椅","椒","棵","棍","棉","棚","棕","惠","惑","逼","厨","厦","硬","确","雁","殖","裂","雄","暂",
                "雅","辈","悲","紫","辉","敞","赏","掌","晴","暑","最","量","喷","晶","喇","遇","喊","景","践",
                "跌","跑","遗","蛙","蛛","蜓","喝","喂","喘","喉","幅","帽","赌","赔","黑","铸","铺","链","销",
                "锁","锄","锅","锈","锋","锐","短","智","毯","鹅","剩","稍","程","稀","税","筐","等","筑","策",
                "筛","筒","答","筋","筝","傲","傅","牌","堡","集","焦","傍","储","奥","街","惩","御","循","艇",
                "舒","番","释","禽","腊","脾","腔","鲁","猾","猴","然","馋","装","蛮","就","痛","童","阔","善",
                "羡","普","粪","尊","道","曾","焰","港","湖","渣","湿","温","渴","滑","湾","渡","游","滋","溉",
                "愤","慌","惰","愧","愉","慨","割","寒","富","窜","窝","窗","遍","裕","裤","裙","谢","谣","谦",
                "属","屡","强","粥","疏","隔","隙","絮","嫂","登","缎","缓","编","骗","缘","瑞","魂","肆","摄",
                "摸","填","搏","塌","鼓","摆","携","搬","摇","搞","塘","摊","蒜","勤","鹊","蓝","墓","幕","蓬",
                "蓄","蒙","蒸","献","禁","楚","想","槐","榆","楼","概","赖","酬","感","碍","碑","碎","碰","碗",
                "碌","雷","零","雾","雹","输","督","龄","鉴","睛","睡","睬","鄙","愚","暖","盟","歇","暗","照",
                "跨","跳","跪","路","跟","遣","蛾","蜂","嗓","置","罪","罩","错","锡","锣","锤","锦","键","锯",
                "矮","辞","稠","愁","筹","签","简","毁","舅","鼠","催","傻","像","躲","微","愈","遥","腰","腥",
                "腹","腾","腿","触","解","酱","痰","廉","新","韵","意","粮","数","煎","塑","慈","煤","煌","满",
                "漠","源","滤","滥","滔","溪","溜","滚","滨","粱","滩","慎","誉","塞","谨","福","群","殿","辟",
                "障","嫌","嫁","叠","缝","缠","静","碧","璃","墙","撇","嘉","摧","截","誓","境","摘","摔","聚",
                "蔽","慕","暮","蔑","模","榴","榜","榨","歌","遭","酷","酿","酸","磁","愿","需","弊","裳","颗",
                "嗽","蜻","蜡","蝇","蜘","赚","锹","锻","舞","稳","算","箩","管","僚","鼻","魄","貌","膜","膊",
                "膀","鲜","疑","馒","裹","敲","豪","膏","遮","腐","瘦","辣","竭","端","旗","精","歉","熄","熔",
                "漆","漂","漫","滴","演","漏","慢","寨","赛","察","蜜","谱","嫩","翠","熊","凳","骡","缩","慧",
                "撕","撒","趣","趟","撑","播","撞","撤","增","聪","鞋","蕉","蔬","横","槽","樱","橡","飘","醋",
                "醉","震","霉","瞒","题","暴","瞎","影","踢","踏","踩","踪","蝶","蝴","嘱","墨","镇","靠","稻",
                "黎","稿","稼","箱","箭","篇","僵","躺","僻","德","艘","膝","膛","熟","摩","颜","毅","糊","遵",
                "潜","潮","懂","额","慰","劈","操","燕","薯","薪","薄","颠","橘","整","融","醒","餐","嘴","蹄",
                "器","赠","默","镜","赞","篮","邀","衡","膨","雕","磨","凝","辨","辩","糖","糕","燃","澡","激",
                "懒","壁","避","缴","戴","擦","鞠","藏","霜","霞","瞧","蹈","螺","穗","繁","辫","赢","糟","糠",
                "燥","臂","翼","骤","鞭","覆","蹦","镰","翻","鹰","警","攀","蹲","颤","瓣","爆","疆","壤","耀",
                "躁","嚼","嚷","籍","魔","灌","蠢","霸","露","囊","罐"};

        int surNameLen = surName.length;
        int doubleSurNameLen = doubleSurName.length;
        int wordLen = word.length;

        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        if(simple){
            sb.append(surName[random.nextInt(surNameLen)]);
            int surLen = sb.toString().length();
            for (int i = 0; i < len - surLen; i++) {
                if(sb.toString().length() <= len){
                    sb.append(word[random.nextInt(wordLen)]);
                }
            }
        }else{
            sb.append(doubleSurName[random.nextInt(doubleSurNameLen)]);
            int doubleSurLen = sb.toString().length();
            for (int i = 0; i < len - doubleSurLen; i++) {
                if(sb.toString().length() <= len){
                    sb.append(word[random.nextInt(wordLen)]);
                }
            }
        }
        return sb.toString();
    }

}
