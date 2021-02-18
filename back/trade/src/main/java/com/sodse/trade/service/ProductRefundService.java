package com.sodse.trade.service;

import java.util.List;
import com.sodse.trade.domain.ProductRefund;
import com.sodse.trade.domain.ProductRefundExample;
public interface ProductRefundService{


    long countByExample(ProductRefundExample example);

    int deleteByExample(ProductRefundExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProductRefund record);

    int insertOrUpdate(ProductRefund record);

    int insertOrUpdateSelective(ProductRefund record);

    int insertSelective(ProductRefund record);

    List<ProductRefund> selectByExample(ProductRefundExample example);

    ProductRefund selectByPrimaryKey(Long id);

    int updateByExampleSelective(ProductRefund record,ProductRefundExample example);

    int updateByExample(ProductRefund record,ProductRefundExample example);

    int updateByPrimaryKeySelective(ProductRefund record);

    int updateByPrimaryKey(ProductRefund record);

    int updateBatch(List<ProductRefund> list);

    int updateBatchSelective(List<ProductRefund> list);

    int batchInsert(List<ProductRefund> list);

}
