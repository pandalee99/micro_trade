package com.sodse.trade.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.sodse.trade.mapper.BankCardMapper;
import java.util.List;
import com.sodse.trade.domain.BankCardExample;
import com.sodse.trade.domain.BankCard;
import com.sodse.trade.service.BankCardService;
@Service
public class BankCardServiceImpl implements BankCardService{

    @Resource
    private BankCardMapper bankCardMapper;

    @Override
    public long countByExample(BankCardExample example) {
        return bankCardMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(BankCardExample example) {
        return bankCardMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return bankCardMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BankCard record) {
        return bankCardMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(BankCard record) {
        return bankCardMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(BankCard record) {
        return bankCardMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(BankCard record) {
        return bankCardMapper.insertSelective(record);
    }

    @Override
    public List<BankCard> selectByExample(BankCardExample example) {
        return bankCardMapper.selectByExample(example);
    }

    @Override
    public BankCard selectByPrimaryKey(Long id) {
        return bankCardMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(BankCard record,BankCardExample example) {
        return bankCardMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(BankCard record,BankCardExample example) {
        return bankCardMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(BankCard record) {
        return bankCardMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(BankCard record) {
        return bankCardMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<BankCard> list) {
        return bankCardMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<BankCard> list) {
        return bankCardMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<BankCard> list) {
        return bankCardMapper.batchInsert(list);
    }

	@Override
	public int delete(){
		 return bankCardMapper.delete();
	}




}
