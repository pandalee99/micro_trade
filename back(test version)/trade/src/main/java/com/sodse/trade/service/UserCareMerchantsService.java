package com.sodse.trade.service;

import com.sodse.trade.domain.UserCareMerchantsExample;
import java.util.List;
import com.sodse.trade.domain.UserCareMerchants;
public interface UserCareMerchantsService{


    long countByExample(UserCareMerchantsExample example);

    int deleteByExample(UserCareMerchantsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserCareMerchants record);

    int insertOrUpdate(UserCareMerchants record);

    int insertOrUpdateSelective(UserCareMerchants record);

    int insertSelective(UserCareMerchants record);

    List<UserCareMerchants> selectByExample(UserCareMerchantsExample example);

    UserCareMerchants selectByPrimaryKey(Long id);

    int updateByExampleSelective(UserCareMerchants record,UserCareMerchantsExample example);

    int updateByExample(UserCareMerchants record,UserCareMerchantsExample example);

    int updateByPrimaryKeySelective(UserCareMerchants record);

    int updateByPrimaryKey(UserCareMerchants record);

    int updateBatch(List<UserCareMerchants> list);

    int updateBatchSelective(List<UserCareMerchants> list);

    int batchInsert(List<UserCareMerchants> list);



	List<UserCareMerchants> selectByUserId(Long userId);



	int deleteByUserIdAndMerchantId(Long userId,Long merchantId);



}
