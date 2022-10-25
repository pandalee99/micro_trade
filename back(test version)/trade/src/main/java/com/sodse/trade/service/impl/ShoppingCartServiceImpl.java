package com.sodse.trade.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.sodse.trade.domain.ShoppingCart;
import java.util.List;
import com.sodse.trade.domain.ShoppingCartExample;
import com.sodse.trade.mapper.ShoppingCartMapper;
import com.sodse.trade.service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Resource
    private ShoppingCartMapper shoppingCartMapper;

    @Override
    public long countByExample(ShoppingCartExample example) {
        return shoppingCartMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ShoppingCartExample example) {
        return shoppingCartMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return shoppingCartMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ShoppingCart record) {
        return shoppingCartMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(ShoppingCart record) {
        return shoppingCartMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(ShoppingCart record) {
        return shoppingCartMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(ShoppingCart record) {
        return shoppingCartMapper.insertSelective(record);
    }

    @Override
    public List<ShoppingCart> selectByExample(ShoppingCartExample example) {
        return shoppingCartMapper.selectByExample(example);
    }

    @Override
    public ShoppingCart selectByPrimaryKey(Long id) {
        return shoppingCartMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(ShoppingCart record, ShoppingCartExample example) {
        return shoppingCartMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(ShoppingCart record, ShoppingCartExample example) {
        return shoppingCartMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ShoppingCart record) {
        return shoppingCartMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ShoppingCart record) {
        return shoppingCartMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<ShoppingCart> list) {
        return shoppingCartMapper.updateBatch(list);
    }



    @Override
    public int batchInsert(List<ShoppingCart> list) {
        return shoppingCartMapper.batchInsert(list);
    }

    @Override
    public List<ShoppingCart> selectByUserId(Long userId) {
        return shoppingCartMapper.selectByUserId(userId);
    }


}



