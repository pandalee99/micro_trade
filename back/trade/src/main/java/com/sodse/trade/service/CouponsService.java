package com.sodse.trade.service;

import java.util.List;
import com.sodse.trade.domain.Coupons;
import com.sodse.trade.domain.CouponsExample;
public interface CouponsService{


    long countByExample(CouponsExample example);

    int deleteByExample(CouponsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Coupons record);

    int insertOrUpdate(Coupons record);

    int insertOrUpdateSelective(Coupons record);

    int insertSelective(Coupons record);

    List<Coupons> selectByExample(CouponsExample example);

    Coupons selectByPrimaryKey(Long id);

    int updateByExampleSelective(Coupons record,CouponsExample example);

    int updateByExample(Coupons record,CouponsExample example);

    int updateByPrimaryKeySelective(Coupons record);

    int updateByPrimaryKey(Coupons record);

    int updateBatch(List<Coupons> list);

    int updateBatchSelective(List<Coupons> list);

    int batchInsert(List<Coupons> list);

}
