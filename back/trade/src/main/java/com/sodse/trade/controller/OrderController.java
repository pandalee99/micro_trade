package com.sodse.trade.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sodse.trade.common.dot.LoginDto;
import com.sodse.trade.common.lang.Result;
import com.sodse.trade.domain.OrderSheet;
import com.sodse.trade.domain.Product;
import com.sodse.trade.domain.User;
import com.sodse.trade.tools.snow.IdWorker;
import com.sodse.trade.tools.snow.RandomId;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@RestController
public class OrderController extends BaseController {

    @PostMapping("/add_all_cart_order")
    public Result add_all_cart_order(@Validated @RequestBody List<OrderSheet> orderSheets , HttpServletResponse response){
        BigDecimal sum=new BigDecimal(0);
        for (OrderSheet o:orderSheets) {//List<OrderSheet> orderSheets
            sum.add(o.getSumMoney());
        }
        String state="余额不足";
        User user=userService.selectById(orderSheets.get(0).getUserId());
        BigDecimal money=user
                .getMoney()
                .subtract(sum);
        if (money.compareTo(new BigDecimal(0))==1){
        for (OrderSheet o:orderSheets) {//List<OrderSheet> orderSheets
            o.setState("未收货");
            orderSheetService.insert(o);
            shoppingCartService.deleteByPrimaryKey(o.getId());
            user.setMoney(user.getMoney().subtract(sum));
            userService.updateByPrimaryKey(user);
            state="支付成功";
        }}


        return Result.succ(state);

    }


    @PostMapping("/add_one_cart_order")
    public Result add_one_cart_order(@Validated @RequestBody OrderSheet orderSheet, HttpServletResponse response) {
        User user=new User();
        String state="余额不足";
        user=userService.selectById(orderSheet.getUserId());
        BigDecimal money=user
                .getMoney()
                .subtract(orderSheet.getSumMoney());
        if (money.compareTo(new BigDecimal(0))==1){
            orderSheet.setState("未收货");
            orderSheetService.insert(orderSheet);
            user.setMoney(user.getMoney().subtract(orderSheet.getSumMoney()));
            userService.updateByPrimaryKey(user);
            shoppingCartService.deleteByPrimaryKey(orderSheet.getId());
            state="支付成功";
        }

        return Result.succ(state);

    }

    @GetMapping("/get_all_order/{id}")
    public Result get_all_order(@PathVariable(name = "id") Long id) {

        return Result.succ(orderSheetService.selectByUserId(id));

    }

    @GetMapping("/prepared_to_pay/{id}")
    public Result prepared_to_pay (@PathVariable(name = "id") Long id){
        OrderSheet orderSheet=new OrderSheet();
//        System.out.println(id);
        orderSheet=orderSheetService.selectOneById(id);
//        System.out.println(JSON.toJSONString(orderSheet));
//        System.out.println("zx");

        return Result.succ(orderSheet);
    }


    @PostMapping("/pay_product")
    public Result pay_product(@Validated @RequestBody OrderSheet orderSheet, HttpServletResponse response) {

//        System.out.println(orderSheet.getId());

        User user=new User();
        String state="余额不足";
        user=userService.selectById(orderSheet.getUserId());
        BigDecimal money=user
                .getMoney()
                .subtract(orderSheet.getSumMoney());
//        System.out.println(money);
//        System.out.println(money.compareTo(new BigDecimal(0)));
        if (money.compareTo(new BigDecimal(0))==1){
//            System.out.println("执行");
            orderSheet.setState("未收货");
            orderSheetService.updateByPrimaryKey(orderSheet);
//            System.out.println(orderSheetService.selectOneById(orderSheet.getId()).getState());
            user.setMoney(user.getMoney().subtract(orderSheet.getSumMoney()));
            userService.updateByPrimaryKey(user);
            state="支付成功";
        }

        return Result.succ(state);
    }


    //原始方法
//    @PostMapping("/addorder")
//    public Result add_order(@Validated @RequestBody OrderSheet orderSheet, HttpServletResponse response) {
//
//
//        IdWorker id=
//                new IdWorker(
//                        1 + (((long) (new Random().nextDouble() * (10 - 1)))),
//                        1 + (((long) (new Random().nextDouble() * (10 - 1)))));
//
//
//
//        Product product=productService.selectOneById(orderSheet.getProductId());
//        orderSheet.setId(id.nextId());
//        orderSheet.setSumMoney(product.getPrice().multiply(new BigDecimal(orderSheet.getAmount())));
//
////        System.out.println(orderSheet.getProductId());
////        System.out.println(orderSheet.getUserId());
////        System.out.println(orderSheet.getAmount());
////        System.out.println(orderSheet.getAddress());
////        System.out.println(orderSheet.getState());
////        System.out.println(orderSheet.getProductProperties());
////        System.out.println(orderSheet.getSumMoney());
////        System.out.println(orderSheet.getId());
////        System.out.println(orderSheet.getName());
////        System.out.println(orderSheet.getPhone());
////        System.out.println(orderSheet.getTime());
//        orderSheet.setTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//
//
//
//        orderSheetService.insert(orderSheet);
//
//        return Result.succ(JSONObject.toJSONString(orderSheet.getId(),true));
//
//    }
//原始方法

    @PostMapping("/addorder")
    public Result add_order(@Validated @RequestBody OrderSheet orderSheet, HttpServletResponse response) {
        orderSheet.setId(new RandomId().nextId());
        orderSheet.setTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        Product product=productService.selectOneById(orderSheet.getProductId());
        orderSheet.setSumMoney(product.getPrice().multiply(new BigDecimal(orderSheet.getAmount())));
//        redis缓存放入
        Boolean success=orderRedis.addOrderByRedis(orderSheet);
        String message = success ? "抢购成功" : "抢购失败";
        if (Objects.equals(message, "抢购失败")){
            return Result.succ(message);
        }
//        redis缓存放入
        orderSheetService.insert(orderSheet);
        return Result.succ(JSONObject.toJSONString(orderSheet.getId(),true));

    }

}
