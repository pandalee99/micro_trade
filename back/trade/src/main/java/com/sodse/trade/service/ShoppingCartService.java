package com.sodse.trade.service;

import com.sodse.trade.domain.ShoppingCart;
import java.util.List;
import com.sodse.trade.domain.ShoppingCartExample;

public interface ShoppingCartService {


    long countByExample(ShoppingCartExample example);

    int deleteByExample(ShoppingCartExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingCart record);

    int insertOrUpdate(ShoppingCart record);

    int insertOrUpdateSelective(ShoppingCart record);

    int insertSelective(ShoppingCart record);

    List<ShoppingCart> selectByExample(ShoppingCartExample example);

    ShoppingCart selectByPrimaryKey(Long id);

    int updateByExampleSelective(ShoppingCart record, ShoppingCartExample example);

    int updateByExample(ShoppingCart record, ShoppingCartExample example);

    int updateByPrimaryKeySelective(ShoppingCart record);

    int updateByPrimaryKey(ShoppingCart record);

    int updateBatch(List<ShoppingCart> list);

    int updateBatchSelective(List<ShoppingCart> list);

    int batchInsert(List<ShoppingCart> list);


    List<ShoppingCart> selectByUserId(Long userId);


}



