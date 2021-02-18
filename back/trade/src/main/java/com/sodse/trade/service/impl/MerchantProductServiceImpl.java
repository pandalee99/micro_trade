package com.sodse.trade.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.sodse.trade.mapper.MerchantProductMapper;
import com.sodse.trade.domain.MerchantProductExample;
import com.sodse.trade.domain.MerchantProduct;
import com.sodse.trade.service.MerchantProductService;

@Service
public class MerchantProductServiceImpl implements MerchantProductService {

    @Resource
    private MerchantProductMapper merchantProductMapper;

    @Override
    public long countByExample(MerchantProductExample example) {
        return merchantProductMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(MerchantProductExample example) {
        return merchantProductMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return merchantProductMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MerchantProduct record) {
        return merchantProductMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(MerchantProduct record) {
        return merchantProductMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(MerchantProduct record) {
        return merchantProductMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(MerchantProduct record) {
        return merchantProductMapper.insertSelective(record);
    }

    @Override
    public List<MerchantProduct> selectByExample(MerchantProductExample example) {
        return merchantProductMapper.selectByExample(example);
    }

    @Override
    public MerchantProduct selectByPrimaryKey(Long id) {
        return merchantProductMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(MerchantProduct record, MerchantProductExample example) {
        return merchantProductMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(MerchantProduct record, MerchantProductExample example) {
        return merchantProductMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(MerchantProduct record) {
        return merchantProductMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MerchantProduct record) {
        return merchantProductMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<MerchantProduct> list) {
        return merchantProductMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<MerchantProduct> list) {
        return merchantProductMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<MerchantProduct> list) {
        return merchantProductMapper.batchInsert(list);
    }

	@Override
	public MerchantProduct selectOneByProductId(Long productId){
		 return merchantProductMapper.selectOneByProductId(productId);
	}

	@Override
	public List<MerchantProduct> selectByMerchantId(Long merchantId){
		 return merchantProductMapper.selectByMerchantId(merchantId);
	}







}

