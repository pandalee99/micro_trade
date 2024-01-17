package com.sodse.trade.controller;


import cn.hutool.core.map.MapUtil;
import com.alibaba.fastjson.JSON;
import com.sodse.trade.common.lang.Result;
import com.sodse.trade.domain.*;
import com.sodse.trade.service.UserBrowsingHistoryService;
import com.sodse.trade.tools.snow.IdWorker;
import com.sodse.trade.tools.snow.RandomId;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class UserController extends BaseController {

    @GetMapping("/user")
    public Result AllUser() {
        return Result.succ(userService.selectById(1l));
    }

    @GetMapping("/user/{id}")
    public Result getUser(@PathVariable(name = "id") Long id) {
        return Result.succ(userService.selectById(id));
    }

    @PostMapping("/update_user")
    public Result updateUser(@Validated @RequestBody User user, HttpServletResponse response) {
//        System.out.println(user.getUserNickname());
//        User updateUser=userService.selectById(user.getId());
//        updateUser.setUserNickname(user.getUserNickname());
//        updateUser.setSex(user.getSex());
//        updateUser.setDescription(user.getDescription());
        userService.updateByPrimaryKey(user);
        return Result.succ("更新成功");
    }

    @GetMapping("/userinfo/{id}")
    public Result userinfo(@PathVariable(name = "id") Long id) {

        List<UserInfo> userInfos = userInfoService.selectByUserid(id);


        return Result.succ(MapUtil.builder()
                .put("lists", userInfos).map());
    }

    @PostMapping("/add_userInfo")
    public Result add_userInfo(@Validated @RequestBody UserInfo userInfo, HttpServletResponse response) {

        IdWorker id =
                new IdWorker(
                        1 + (((long) (new Random().nextDouble() * (10 - 1)))),
                        1 + (((long) (new Random().nextDouble() * (10 - 1)))));
        userInfo.setId(id.nextId());
        userInfoService.insert(userInfo);

        return Result.succ("增加成功");
    }

    @GetMapping("/get_one_userinfo/{id}")
    public Result get_one_userinfo(@PathVariable(name = "id") Long id) {
        UserInfo userInfo = new UserInfo();
        userInfo = userInfoService.selectByUserid(id).get(0);
//        System.out.println(JSON.toJSONString(userInfoService.selectOneByUserid(id)));
        return Result.succ(userInfo);

    }


    @GetMapping("/get_all_merchant_by_user_id/{id}")
    public Result get_all_merchant_by_user_id(@PathVariable(name = "id") Long id) {

        List<UserCareMerchants> userCareMerchants = userCareMerchantsService.selectByUserId(id);
        List<Merchants> merchants = new ArrayList<>();
        for (UserCareMerchants ucm : userCareMerchants) {
            Merchants merchant = merchantsService.selectByPrimaryKey(ucm.getMerchantId());
            merchants.add(merchant);
        }


        return Result.succ(merchants);
    }

    @GetMapping("/get_all_collection_by_user_id/{id}")
    public Result get_all_collection_by_user_id(@PathVariable(name = "id") Long id) {

        List<UserCollection> userCollections = userCollectionService.selectByUserId(id);
        List<Product> products = new ArrayList<>();
        for (UserCollection uc : userCollections) {
            Product product = productService.selectByPrimaryKey(uc.getProductId());
            products.add(product);
        }


        return Result.succ(products);
    }


    @GetMapping("/add_user_browsing_history/{pid}/{uid}")
    public Result add_user_browsing_history(@PathVariable(name = "pid") Long pid, @PathVariable(name = "uid") Long uid) {

        UserBrowsingHistory userBrowsingHistory = userBrowsingHistoryService.selectOneByUserIdAndProductId(uid, pid);
        if (userBrowsingHistory != null) {
            userBrowsingHistoryService.deleteByUserIdAndProductId(uid, pid);
        }
        UserBrowsingHistory history = new UserBrowsingHistory();
        history.setId(new RandomId().nextId());
        history.setUserId(uid);
        history.setProductId(pid);
        userBrowsingHistoryService.insert(history);


        return Result.succ("记录");
    }

    @GetMapping("/delete_user_browsing_history/{pid}/{uid}")
    public Result delete_user_browsing_history(@PathVariable(name = "pid") Long pid, @PathVariable(name = "uid") Long uid) {

        userBrowsingHistoryService.deleteByUserIdAndProductId(uid, pid);

        return Result.succ("删除");
    }

    @GetMapping("/get_user_browsing_history_by_user_id/{id}")
    public Result get_user_browsing_history_by_user_id(@PathVariable(name = "id") Long id) {

        List<UserBrowsingHistory> userBrowsingHistories = userBrowsingHistoryService.selectByUserId(id);
        List<Product> products = new ArrayList<>();
        for (UserBrowsingHistory h : userBrowsingHistories) {
            Product product = productService.selectByPrimaryKey(h.getProductId());
            products.add(product);
        }


        return Result.succ(products);
    }

    @GetMapping("/pay_one_order/{id}")
    public Result pay_one_order(@PathVariable(name = "id") Long id) {
        String state = "余额不足";
        OrderSheet orderSheet = orderSheetService.selectByPrimaryKey(id);
        User user = userService.selectById(orderSheet.getUserId());
        BigDecimal money = user
                .getMoney()
                .subtract(orderSheet.getSumMoney());
        if (money.compareTo(new BigDecimal(0)) == 1) {
            orderSheet.setState("未收货");
            orderSheetService.updateByPrimaryKey(orderSheet);
            user.setMoney(user.getMoney().subtract(orderSheet.getSumMoney()));
            userService.updateByPrimaryKey(user);
            state = "支付成功";
        }

        return Result.succ(state);
    }


    @GetMapping("/user_friend/{id}")
    public Result user_friend(@PathVariable(name = "id") Long id) {
        List<UserFriend> userFriends = userFriendService.selectByUserId(id);
        List<User> users = new ArrayList<>();
        for (UserFriend friend : userFriends) {
            User user = userService.selectById(friend.getFriendId());
            user.setUserNickname(friend.getNoteName());
            users.add(user);
        }
        return Result.succ(users);
    }

    @GetMapping("/get_user_and_friend_messages/{uid}/{fid}")
    public Result get_user_and_friend_messages(@PathVariable(name = "uid") Long uid, @PathVariable(name = "fid") Long fid) {
        List<ChatRecord> chatRecords = chatRecordService.selectByUserIdAndTalkerId(uid, fid);

        return Result.succ(chatRecords);
    }

    @GetMapping("/es_search_product_by_name/{name}")
    public Result es_search_product_by_name(@PathVariable(name = "name") String name) {
        List<Product> allByNameLike = productRepository.findAllByNameLike(name);

        return Result.succ(allByNameLike);
    }

}
