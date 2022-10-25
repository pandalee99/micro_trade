package com.sodse.trade.controller;

import com.sodse.trade.elasticsearch.product.ProductRepository;
import com.sodse.trade.qiniuyun.QiniuService;
import com.sodse.trade.redis.service.OrderRedis;
import com.sodse.trade.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @Autowired
    OrderRedis orderRedis;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    AuthService authService;

    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    UserFriendService userFriendService;
    @Autowired
    UserCollectionService userCollectionService;
    @Autowired
    UserCareMerchantsService userCareMerchantsService;
    @Autowired
    UserBrowsingHistoryService userBrowsingHistoryService;
    @Autowired
    ShoppingCartService shoppingCartService;
    @Autowired
    ProductRefundService productRefundService;
    @Autowired
    OrderSheetService orderSheetService;
    @Autowired
    MerchantsService merchantsService;
    @Autowired
    MerchantProductService merchantProductService;
    @Autowired
    MerchantMoveNewsService merchantMoveNewsService;
    @Autowired
    ImagesService imagesService;
    @Autowired
    CouponsService couponsService;
    @Autowired
   public   ChatRecordService chatRecordService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    BrandService brandService;
    @Autowired
    BankCardService bankCardService;
    @Autowired
    QiniuService qiniuService;


}
