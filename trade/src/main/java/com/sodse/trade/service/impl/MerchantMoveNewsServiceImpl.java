package com.sodse.trade.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.sodse.trade.domain.MerchantMoveNewsExample;
import com.sodse.trade.domain.MerchantMoveNews;
import java.util.List;
import com.sodse.trade.mapper.MerchantMoveNewsMapper;
import com.sodse.trade.service.MerchantMoveNewsService;

@Service
public class MerchantMoveNewsServiceImpl implements MerchantMoveNewsService {

    @Resource
    private MerchantMoveNewsMapper merchantMoveNewsMapper;

    @Override
    public long countByExample(MerchantMoveNewsExample example) {
        return merchantMoveNewsMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(MerchantMoveNewsExample example) {
        return merchantMoveNewsMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return merchantMoveNewsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(MerchantMoveNews record) {
        return merchantMoveNewsMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(MerchantMoveNews record) {
        return merchantMoveNewsMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(MerchantMoveNews record) {
        return merchantMoveNewsMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(MerchantMoveNews record) {
        return merchantMoveNewsMapper.insertSelective(record);
    }

    @Override
    public List<MerchantMoveNews> selectByExample(MerchantMoveNewsExample example) {
        return merchantMoveNewsMapper.selectByExample(example);
    }

    @Override
    public MerchantMoveNews selectByPrimaryKey(Long id) {
        return merchantMoveNewsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(MerchantMoveNews record, MerchantMoveNewsExample example) {
        return merchantMoveNewsMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(MerchantMoveNews record, MerchantMoveNewsExample example) {
        return merchantMoveNewsMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(MerchantMoveNews record) {
        return merchantMoveNewsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(MerchantMoveNews record) {
        return merchantMoveNewsMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<MerchantMoveNews> list) {
        return merchantMoveNewsMapper.updateBatch(list);
    }



    @Override
    public int batchInsert(List<MerchantMoveNews> list) {
        return merchantMoveNewsMapper.batchInsert(list);
    }

	@Override
	public List<MerchantMoveNews> selectAllByMerchantId(Long merchantId){
		 return merchantMoveNewsMapper.selectAllByMerchantId(merchantId);
	}




}


