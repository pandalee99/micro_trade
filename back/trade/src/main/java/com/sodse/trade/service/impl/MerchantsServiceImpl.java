package com.sodse.trade.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.sodse.trade.domain.Merchants;
import com.sodse.trade.domain.MerchantsExample;
import java.util.List;
import com.sodse.trade.mapper.MerchantsMapper;
import com.sodse.trade.service.MerchantsService;
@Service
public class MerchantsServiceImpl implements MerchantsService{

    @Resource
    private MerchantsMapper merchantsMapper;

    @Override
    public long countByExample(MerchantsExample example) {
        return merchantsMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(MerchantsExample example) {
        return merchantsMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long merchantId) {
        return merchantsMapper.deleteByPrimaryKey(merchantId);
    }

    @Override
    public int insert(Merchants record) {
        return merchantsMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(Merchants record) {
        return merchantsMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(Merchants record) {
        return merchantsMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(Merchants record) {
        return merchantsMapper.insertSelective(record);
    }

    @Override
    public List<Merchants> selectByExample(MerchantsExample example) {
        return merchantsMapper.selectByExample(example);
    }

    @Override
    public Merchants selectByPrimaryKey(Long merchantId) {
        return merchantsMapper.selectByPrimaryKey(merchantId);
    }

    @Override
    public int updateByExampleSelective(Merchants record,MerchantsExample example) {
        return merchantsMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Merchants record,MerchantsExample example) {
        return merchantsMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Merchants record) {
        return merchantsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Merchants record) {
        return merchantsMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Merchants> list) {
        return merchantsMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<Merchants> list) {
        return merchantsMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<Merchants> list) {
        return merchantsMapper.batchInsert(list);
    }

	@Override
	public Merchants findOneByMerchantName(String merchantName){
		 return merchantsMapper.findOneByMerchantName(merchantName);
	}

	@Override
	public List<Merchants> selectByMerchantName(String merchantName){
		 return merchantsMapper.selectByMerchantName(merchantName);
	}

	@Override
	public Merchants selectOneByMerchantName(String merchantName){
		 return merchantsMapper.selectOneByMerchantName(merchantName);
	}

	@Override
	public Merchants selectOneByShopName(String shopName){
		 return merchantsMapper.selectOneByShopName(shopName);
	}

	@Override
	public List<Merchants> findAll(){
		 return merchantsMapper.findAll();
	}

	@Override
	public int deleteByShopName(String shopName){
		 return merchantsMapper.deleteByShopName(shopName);
	}

	@Override
	public int delete(){
		 return merchantsMapper.delete();
	}

	@Override
	public Merchants selectOneByUserId(Long userId){
		 return merchantsMapper.selectOneByUserId(userId);
	}






























}
