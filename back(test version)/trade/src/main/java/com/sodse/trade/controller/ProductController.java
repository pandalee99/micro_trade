package com.sodse.trade.controller;

import cn.hutool.core.map.MapUtil;
import com.sodse.trade.common.dot.ForDto;
import com.sodse.trade.common.lang.Result;
import com.sodse.trade.domain.Product;
import com.sodse.trade.domain.UserCareMerchants;
import com.sodse.trade.domain.UserCollection;
import com.sodse.trade.tools.snow.RandomId;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController  extends BaseController{

//    @GetMapping("/products")
//    public Result AllProducts(){
//        return Result.succ(productService.find());
//    }

    //        PageInfo<Product> productPageInfo=new PageInfo<Product>(products);
//        productService.findByPagewithPage(currentPage,pagSize)

    @GetMapping("/products")
    public Result list(@RequestParam(defaultValue = "1") Integer currentPage){

        List<Product> products=productService.find();
        List<Product> res=new ArrayList<Product>();

        int pageSize=10;
        int index=currentPage*pageSize;
        for (int i = 1; i <products.size() ; i++) {
            if(i==index){
                res.add(products.get(i));
                index++;
                if (res.size()>9){
                    break;
                }
            }
        }

        return Result.succ(MapUtil.builder()
                .put("lists", res)
                .put("currentPage", currentPage)
                .put("total",products.size())
                .put("pageSize",pageSize)
                .map());
    }


    @GetMapping("/product/{id}")
    public Result detail(@PathVariable(name = "id") Long id){
//        Product product=productService.selectByPrimaryKey(id);
        Product product=productService.selectOneById(id);
//        属性单选框

        if(product.getProperties1()==null){
            product.setProperties1("");
        }
        String[] r1=product.getProperties1().split(" ");
        List<ForDto> radioDtos1 =new ArrayList<ForDto>();
        for (int i = 0; i <r1.length ; i++) {
            ForDto radioDto1 =new ForDto();
            radioDto1.setId(i+1);
            radioDto1.setName(r1[i]);
            radioDtos1.add(radioDto1);
        }

        if(product.getProperties2()==null){
            product.setProperties2("");
        }
        String[] r2=product.getProperties2().split(" ");
        List<ForDto> radioDtos2 =new ArrayList<ForDto>();
        for (int i = 0; i <r2.length ; i++) {
            ForDto radioDto2 =new ForDto();
            radioDto2.setId(i+1);
            radioDto2.setName(r2[i]);
            radioDtos2.add(radioDto2);
        }

        //内容
        String[] c=product.getContent().split("\n");
        List<ForDto> contents=new ArrayList<ForDto>();
        for (int i = 0; i <c.length ; i++) {
            ForDto content =new ForDto();
            content.setId(i+1);
            content.setName(c[i]);
            contents.add(content);
        }


//        return Result.succ(product);
        return Result.succ(MapUtil.builder()
                .put("product", product)
                .put("radio1", radioDtos1)
                .put("radio2", radioDtos2)
                .put("contents",contents)
                .map());
    }

    @GetMapping("/if_collection/{pid}/{uid}")
    public Result if_focus(@PathVariable(name = "pid") Long pid,@PathVariable(name = "uid") Long uid){
        String flag="未收藏";
        List<UserCollection> userCollections = userCollectionService.selectByUserId(uid);
        for (UserCollection c:userCollections) {
            if (pid.equals(c.getProductId())){
                flag="已收藏";
                break;
            }
        }

        return Result.succ(flag);
    }

    @GetMapping("/add_collection/{pid}/{uid}")
    public Result add_collection(@PathVariable(name = "pid") Long pid,@PathVariable(name = "uid") Long uid){
        String flag="已收藏";
        UserCollection userCollection=new UserCollection();
        userCollection.setId(new RandomId().nextId());
        userCollection.setUserId(uid);
        userCollection.setProductId(pid);
        userCollectionService.insert(userCollection);
        return Result.succ(flag);
    }
    @GetMapping("/delete_collection/{pid}/{uid}")
    public Result delete_collection(@PathVariable(name = "pid") Long pid,@PathVariable(name = "uid") Long uid){
        String flag="取消收藏";
        userCollectionService.deleteByUserIdAndProductId(uid,pid);

        return Result.succ(flag);
    }




}
