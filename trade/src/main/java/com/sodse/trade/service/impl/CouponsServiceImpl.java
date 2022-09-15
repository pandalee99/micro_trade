package com.sodse.trade.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.sodse.trade.mapper.CouponsMapper;
import com.sodse.trade.domain.Coupons;
import com.sodse.trade.domain.CouponsExample;
import com.sodse.trade.service.CouponsService;
@Service
public class CouponsServiceImpl implements CouponsService{

    @Resource
    private CouponsMapper couponsMapper;

    @Override
    public long countByExample(CouponsExample example) {
        return couponsMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(CouponsExample example) {
        return couponsMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return couponsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Coupons record) {
        return couponsMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(Coupons record) {
        return couponsMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(Coupons record) {
        return couponsMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(Coupons record) {
        return couponsMapper.insertSelective(record);
    }

    @Override
    public List<Coupons> selectByExample(CouponsExample example) {
        return couponsMapper.selectByExample(example);
    }

    @Override
    public Coupons selectByPrimaryKey(Long id) {
        return couponsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Coupons record,CouponsExample example) {
        return couponsMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Coupons record,CouponsExample example) {
        return couponsMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Coupons record) {
        return couponsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Coupons record) {
        return couponsMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Coupons> list) {
        return couponsMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<Coupons> list) {
        return couponsMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<Coupons> list) {
        return couponsMapper.batchInsert(list);
    }

}
