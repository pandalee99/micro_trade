package com.sodse.trade.service;

import java.util.List;
import com.sodse.trade.domain.MerchantProductExample;
import com.sodse.trade.domain.MerchantProduct;

public interface MerchantProductService {


    long countByExample(MerchantProductExample example);

    int deleteByExample(MerchantProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MerchantProduct record);

    int insertOrUpdate(MerchantProduct record);

    int insertOrUpdateSelective(MerchantProduct record);

    int insertSelective(MerchantProduct record);

    List<MerchantProduct> selectByExample(MerchantProductExample example);

    MerchantProduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(MerchantProduct record, MerchantProductExample example);

    int updateByExample(MerchantProduct record, MerchantProductExample example);

    int updateByPrimaryKeySelective(MerchantProduct record);

    int updateByPrimaryKey(MerchantProduct record);

    int updateBatch(List<MerchantProduct> list);

    int updateBatchSelective(List<MerchantProduct> list);

    int batchInsert(List<MerchantProduct> list);



	MerchantProduct selectOneByProductId(Long productId);



	List<MerchantProduct> selectByMerchantId(Long merchantId);



}

