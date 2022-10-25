package com.sodse.trade.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.sodse.trade.domain.OrderSheetExample;
import com.sodse.trade.domain.OrderSheet;
import com.sodse.trade.mapper.OrderSheetMapper;
import com.sodse.trade.service.OrderSheetService;

@Service
public class OrderSheetServiceImpl implements OrderSheetService {

    @Resource
    private OrderSheetMapper orderSheetMapper;

    @Override
    public long countByExample(OrderSheetExample example) {
        return orderSheetMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(OrderSheetExample example) {
        return orderSheetMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return orderSheetMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OrderSheet record) {
        return orderSheetMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(OrderSheet record) {
        return orderSheetMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(OrderSheet record) {
        return orderSheetMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(OrderSheet record) {
        return orderSheetMapper.insertSelective(record);
    }

    @Override
    public List<OrderSheet> selectByExample(OrderSheetExample example) {
        return orderSheetMapper.selectByExample(example);
    }

    @Override
    public OrderSheet selectByPrimaryKey(Long id) {
        return orderSheetMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(OrderSheet record, OrderSheetExample example) {
        return orderSheetMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(OrderSheet record, OrderSheetExample example) {
        return orderSheetMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderSheet record) {
        return orderSheetMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderSheet record) {
        return orderSheetMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<OrderSheet> list) {
        return orderSheetMapper.updateBatch(list);
    }



    @Override
    public int batchInsert(List<OrderSheet> list) {
        return orderSheetMapper.batchInsert(list);
    }

    @Override
    public int delete() {
        return orderSheetMapper.delete();
    }

    @Override
    public OrderSheet selectOneById(Long id) {
        return orderSheetMapper.selectOneById(id);
    }

    @Override
    public List<OrderSheet> selectByUserId(Long userId) {
        return orderSheetMapper.selectByUserId(userId);
    }


}












