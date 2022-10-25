package com.sodse.trade.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.sodse.trade.domain.UserCareMerchantsExample;
import java.util.List;
import com.sodse.trade.domain.UserCareMerchants;
import com.sodse.trade.mapper.UserCareMerchantsMapper;
import com.sodse.trade.service.UserCareMerchantsService;
@Service
public class UserCareMerchantsServiceImpl implements UserCareMerchantsService{

    @Resource
    private UserCareMerchantsMapper userCareMerchantsMapper;

    @Override
    public long countByExample(UserCareMerchantsExample example) {
        return userCareMerchantsMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(UserCareMerchantsExample example) {
        return userCareMerchantsMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userCareMerchantsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserCareMerchants record) {
        return userCareMerchantsMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(UserCareMerchants record) {
        return userCareMerchantsMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(UserCareMerchants record) {
        return userCareMerchantsMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(UserCareMerchants record) {
        return userCareMerchantsMapper.insertSelective(record);
    }

    @Override
    public List<UserCareMerchants> selectByExample(UserCareMerchantsExample example) {
        return userCareMerchantsMapper.selectByExample(example);
    }

    @Override
    public UserCareMerchants selectByPrimaryKey(Long id) {
        return userCareMerchantsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(UserCareMerchants record,UserCareMerchantsExample example) {
        return userCareMerchantsMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(UserCareMerchants record,UserCareMerchantsExample example) {
        return userCareMerchantsMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(UserCareMerchants record) {
        return userCareMerchantsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserCareMerchants record) {
        return userCareMerchantsMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<UserCareMerchants> list) {
        return userCareMerchantsMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<UserCareMerchants> list) {
        return userCareMerchantsMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<UserCareMerchants> list) {
        return userCareMerchantsMapper.batchInsert(list);
    }

	@Override
	public List<UserCareMerchants> selectByUserId(Long userId){
		 return userCareMerchantsMapper.selectByUserId(userId);
	}

	@Override
	public int deleteByUserIdAndMerchantId(Long userId,Long merchantId){
		 return userCareMerchantsMapper.deleteByUserIdAndMerchantId(userId,merchantId);
	}







}
