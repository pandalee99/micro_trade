package com.sodse.trade.service;

import com.sodse.trade.domain.Merchants;
import com.sodse.trade.domain.MerchantsExample;
import java.util.List;
public interface MerchantsService{


    long countByExample(MerchantsExample example);

    int deleteByExample(MerchantsExample example);

    int deleteByPrimaryKey(Long merchantId);

    int insert(Merchants record);

    int insertOrUpdate(Merchants record);

    int insertOrUpdateSelective(Merchants record);

    int insertSelective(Merchants record);

    List<Merchants> selectByExample(MerchantsExample example);

    Merchants selectByPrimaryKey(Long merchantId);

    int updateByExampleSelective(Merchants record,MerchantsExample example);

    int updateByExample(Merchants record,MerchantsExample example);

    int updateByPrimaryKeySelective(Merchants record);

    int updateByPrimaryKey(Merchants record);

    int updateBatch(List<Merchants> list);

    int updateBatchSelective(List<Merchants> list);

    int batchInsert(List<Merchants> list);



	Merchants findOneByMerchantName(String merchantName);



	Merchants selectOneByMerchantName(String merchantName);



	List<Merchants> selectByMerchantName(String merchantName);



	Merchants selectOneByShopName(String shopName);



	List<Merchants> findAll();



	int deleteByShopName(String shopName);



	int delete();



	Merchants selectOneByUserId(Long userId);









}
