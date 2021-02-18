package com.sodse.trade.service;

import java.util.List;
import com.sodse.trade.domain.BankCardExample;
import com.sodse.trade.domain.BankCard;
public interface BankCardService{


    long countByExample(BankCardExample example);

    int deleteByExample(BankCardExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BankCard record);

    int insertOrUpdate(BankCard record);

    int insertOrUpdateSelective(BankCard record);

    int insertSelective(BankCard record);

    List<BankCard> selectByExample(BankCardExample example);

    BankCard selectByPrimaryKey(Long id);

    int updateByExampleSelective(BankCard record,BankCardExample example);

    int updateByExample(BankCard record,BankCardExample example);

    int updateByPrimaryKeySelective(BankCard record);

    int updateByPrimaryKey(BankCard record);

    int updateBatch(List<BankCard> list);

    int updateBatchSelective(List<BankCard> list);

    int batchInsert(List<BankCard> list);



	int delete();


}
