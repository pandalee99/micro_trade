package com.sodse.trade.service;

import com.sodse.trade.domain.MerchantMoveNewsExample;
import com.sodse.trade.domain.MerchantMoveNews;
import java.util.List;

public interface MerchantMoveNewsService {


    long countByExample(MerchantMoveNewsExample example);

    int deleteByExample(MerchantMoveNewsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MerchantMoveNews record);

    int insertOrUpdate(MerchantMoveNews record);

    int insertOrUpdateSelective(MerchantMoveNews record);

    int insertSelective(MerchantMoveNews record);

    List<MerchantMoveNews> selectByExample(MerchantMoveNewsExample example);

    MerchantMoveNews selectByPrimaryKey(Long id);

    int updateByExampleSelective(MerchantMoveNews record, MerchantMoveNewsExample example);

    int updateByExample(MerchantMoveNews record, MerchantMoveNewsExample example);

    int updateByPrimaryKeySelective(MerchantMoveNews record);

    int updateByPrimaryKey(MerchantMoveNews record);

    int updateBatch(List<MerchantMoveNews> list);


    int batchInsert(List<MerchantMoveNews> list);



	List<MerchantMoveNews> selectAllByMerchantId(Long merchantId);


}


