package com.sodse.trade.service;

import java.util.List;
import com.sodse.trade.domain.OrderSheetExample;
import com.sodse.trade.domain.OrderSheet;

public interface OrderSheetService {


    long countByExample(OrderSheetExample example);

    int deleteByExample(OrderSheetExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderSheet record);

    int insertOrUpdate(OrderSheet record);

    int insertOrUpdateSelective(OrderSheet record);

    int insertSelective(OrderSheet record);

    List<OrderSheet> selectByExample(OrderSheetExample example);

    OrderSheet selectByPrimaryKey(Long id);

    int updateByExampleSelective(OrderSheet record, OrderSheetExample example);

    int updateByExample(OrderSheet record, OrderSheetExample example);

    int updateByPrimaryKeySelective(OrderSheet record);

    int updateByPrimaryKey(OrderSheet record);

    int updateBatch(List<OrderSheet> list);

    int updateBatchSelective(List<OrderSheet> list);

    int batchInsert(List<OrderSheet> list);


    int delete();


    OrderSheet selectOneById(Long id);


    List<OrderSheet> selectByUserId(Long userId);


}












