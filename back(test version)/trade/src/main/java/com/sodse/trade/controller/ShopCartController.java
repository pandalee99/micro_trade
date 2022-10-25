package com.sodse.trade.controller;

import com.alibaba.fastjson.JSON;
import com.sodse.trade.common.lang.Result;
import com.sodse.trade.domain.OrderSheet;
import com.sodse.trade.domain.Product;
import com.sodse.trade.domain.ShoppingCart;
import com.sodse.trade.domain.UserInfo;
import com.sodse.trade.tools.snow.RandomId;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ShopCartController extends BaseController{
    @PostMapping("/add_shopping_cart")
    public Result add_shopping_cart(@Validated @RequestBody ShoppingCart shoppingCart){
        shoppingCart.setId(new RandomId().nextId());
        shoppingCartService.insert(shoppingCart);
        return Result.succ("加入购物车成功");
    }

    @GetMapping("/get_all_cart/{id}")
    public Result get_all_order(@PathVariable(name = "id") Long id) {

        List<ShoppingCart> shoppingCarts=new ArrayList<>();
        shoppingCarts=shoppingCartService.selectByUserId(id);
        List<OrderSheet> orderSheets=new ArrayList<>();
        RandomId randomId=new RandomId();
        for (ShoppingCart sc:shoppingCarts) {
            Product product=new Product();
            product=productService.selectOneById(sc.getProductId());
            OrderSheet orderSheet=new OrderSheet();
            orderSheet.setId(sc.getId());
            orderSheet.setUserId(id);
            orderSheet.setProductImg(product.getMainImg());
            orderSheet.setProductPrice(product.getPrice());
            orderSheet.setAmount(sc.getQuantity());
            orderSheet.setCourier("0");
            orderSheet.setSumMoney(product.getPrice().multiply(new BigDecimal(sc.getQuantity())));
            orderSheet.setProductProperties(sc.getProperties());
            orderSheet.setState("未支付");
            orderSheet.setProductName(product.getName());
            orderSheet.setTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            orderSheets.add(orderSheet);

//            UserInfo userInfo= userInfoService.selectByUserid(id).get(0);
            orderSheet.setName(sc.getName());
            orderSheet.setPhone(sc.getPhone());
            orderSheet.setAddress(sc.getAddress());
        }

        return Result.succ(orderSheets);

    }




    @GetMapping("/delete_cart/{id}")
    public Result delete_order(@PathVariable(name = "id") Long id) {

        shoppingCartService.deleteByPrimaryKey(id);
        return Result.succ("删除成功");

    }
}
