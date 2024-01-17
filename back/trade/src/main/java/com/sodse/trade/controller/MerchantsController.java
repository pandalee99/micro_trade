package com.sodse.trade.controller;

import com.sodse.trade.common.lang.Result;
import com.sodse.trade.domain.*;
import com.sodse.trade.tools.snow.RandomId;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MerchantsController extends BaseController {

    @GetMapping("/get_one_merchant_by_product_id/{id}")
    public Result get_one_merchant_by_product_id(@PathVariable(name = "id") Long id) {
        MerchantProduct merchantProduct = merchantProductService.selectOneByProductId(id);
//        System.out.println("获取商家信息");
        return Result.succ(merchantsService.selectByPrimaryKey(merchantProduct.getMerchantId()));
    }

    @GetMapping("/get_one_merchant/{id}")
    public Result get_one_merchant(@PathVariable(name = "id") Long id) {
        Merchants merchants = merchantsService.selectByPrimaryKey(id);

        return Result.succ(merchants);
    }

    @GetMapping("/if_focus/{mid}/{uid}")
    public Result if_focus(@PathVariable(name = "mid") Long mid, @PathVariable(name = "uid") Long uid) {
        String flag = "未关注";
        List<UserCareMerchants> userCareMerchants = userCareMerchantsService.selectByUserId(uid);
        for (UserCareMerchants i : userCareMerchants) {
            if (mid.equals(i.getMerchantId())) {
                flag = "已关注";
                break;
            }
        }

        return Result.succ(flag);
    }

    @GetMapping("/add_focus/{mid}/{uid}")
    public Result add_focus(@PathVariable(name = "mid") Long mid, @PathVariable(name = "uid") Long uid) {
        String flag = "已关注";
        UserCareMerchants care = new UserCareMerchants();
        care.setId(new RandomId().nextId());
        care.setUserId(uid);
        care.setMerchantId(mid);
        userCareMerchantsService.insert(care);
        return Result.succ(flag);
    }

    @GetMapping("/delete_focus/{mid}/{uid}")
    public Result delete_focus(@PathVariable(name = "mid") Long mid, @PathVariable(name = "uid") Long uid) {
        String flag = "取消关注";
        userCareMerchantsService.deleteByUserIdAndMerchantId(uid, mid);

        return Result.succ(flag);
    }


    @GetMapping("/get_merchant_product/{id}")
    public Result get_merchant_product(@PathVariable(name = "id") Long id) {
        List<Product> products = new ArrayList<>();
        List<MerchantProduct> merchantProducts = merchantProductService.selectByMerchantId(id);
        for (MerchantProduct mp : merchantProducts) {
            Product product = new Product();
            product = productService.selectByPrimaryKey(mp.getProductId());
            products.add(product);
        }

        return Result.succ(products);
    }


    @GetMapping("/get_one_merchant_by_user_id/{id}")
    public Result get_one_merchant_by_user_id(@PathVariable(name = "id") Long id) {
        Merchants merchants = merchantsService.selectOneByUserId(id);
        return Result.succ(merchants);
    }

    @GetMapping("/get_all_product_by_merchant_id/{id}")
    public Result get_all_product_by_merchant_id(@PathVariable(name = "id") Long id) {
        Merchants merchants = merchantsService.selectByPrimaryKey(id);
        List<Product> products = productService.find();
        List<Product> results = new ArrayList<>();
        for (Product p : products) {
            if (p.getMerchant().equals(merchants.getMerchantName())) {
                results.add(p);
            }
        }
        return Result.succ(results);
    }

    @PostMapping("/merchant_add_one_product")
    public Result merchant_add_one_product(@Validated @RequestBody Product product, HttpServletResponse response) {
        product.setId(new RandomId().nextId());
        Merchants merchant = merchantsService.selectOneByMerchantName(product.getMerchant());
        MerchantProduct merchantProduct = new MerchantProduct();
        merchantProduct.setId(new RandomId().nextId());
        merchantProduct.setProductId(product.getId());
        merchantProduct.setMerchantId(merchant.getMerchantId());
        merchantProductService.insert(merchantProduct);
        productService.insert(product);

        return Result.succ("增加成功");
    }


    @PostMapping("/merchant_add_one_message")
    public Result merchant_add_one_message(@Validated @RequestBody MerchantMoveNews news, HttpServletResponse response) {
        news.setId(new RandomId().nextId());
        news.setMoveNewCreatTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        merchantMoveNewsService.insert(news);
        return Result.succ("发布成功");
    }


    @GetMapping("/require_user_care_merchant_message/{id}")
    public Result require_user_care_merchant_message(@PathVariable(name = "id") Long id) {
        List<UserCareMerchants> userCareMerchants = userCareMerchantsService.selectByUserId(id);
        List<MerchantMoveNews> allNews = new ArrayList<>();
        for (UserCareMerchants userCareMerchant : userCareMerchants) {
            List<MerchantMoveNews> merchantMoveNews = merchantMoveNewsService.selectAllByMerchantId(userCareMerchant.getMerchantId());
            allNews.addAll(merchantMoveNews);
        }
        return Result.succ(allNews);
    }
}
