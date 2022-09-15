package com.sodse.trade.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.sodse.trade.domain.ProductRefund;
import com.sodse.trade.domain.ProductRefundExample;
import com.sodse.trade.mapper.ProductRefundMapper;
import com.sodse.trade.service.ProductRefundService;
@Service
public class ProductRefundServiceImpl implements ProductRefundService{

    @Resource
    private ProductRefundMapper productRefundMapper;

    @Override
    public long countByExample(ProductRefundExample example) {
        return productRefundMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ProductRefundExample example) {
        return productRefundMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return productRefundMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ProductRefund record) {
        return productRefundMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(ProductRefund record) {
        return productRefundMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(ProductRefund record) {
        return productRefundMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(ProductRefund record) {
        return productRefundMapper.insertSelective(record);
    }

    @Override
    public List<ProductRefund> selectByExample(ProductRefundExample example) {
        return productRefundMapper.selectByExample(example);
    }

    @Override
    public ProductRefund selectByPrimaryKey(Long id) {
        return productRefundMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(ProductRefund record,ProductRefundExample example) {
        return productRefundMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(ProductRefund record,ProductRefundExample example) {
        return productRefundMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(ProductRefund record) {
        return productRefundMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ProductRefund record) {
        return productRefundMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<ProductRefund> list) {
        return productRefundMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<ProductRefund> list) {
        return productRefundMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<ProductRefund> list) {
        return productRefundMapper.batchInsert(list);
    }

}
