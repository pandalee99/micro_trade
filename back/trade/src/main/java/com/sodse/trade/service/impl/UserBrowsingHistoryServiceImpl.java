package com.sodse.trade.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.sodse.trade.domain.UserBrowsingHistory;
import com.sodse.trade.mapper.UserBrowsingHistoryMapper;
import com.sodse.trade.domain.UserBrowsingHistoryExample;
import com.sodse.trade.service.UserBrowsingHistoryService;

@Service
public class UserBrowsingHistoryServiceImpl implements UserBrowsingHistoryService {

    @Resource
    private UserBrowsingHistoryMapper userBrowsingHistoryMapper;

    @Override
    public long countByExample(UserBrowsingHistoryExample example) {
        return userBrowsingHistoryMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(UserBrowsingHistoryExample example) {
        return userBrowsingHistoryMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userBrowsingHistoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserBrowsingHistory record) {
        return userBrowsingHistoryMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(UserBrowsingHistory record) {
        return userBrowsingHistoryMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(UserBrowsingHistory record) {
        return userBrowsingHistoryMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(UserBrowsingHistory record) {
        return userBrowsingHistoryMapper.insertSelective(record);
    }

    @Override
    public List<UserBrowsingHistory> selectByExample(UserBrowsingHistoryExample example) {
        return userBrowsingHistoryMapper.selectByExample(example);
    }

    @Override
    public UserBrowsingHistory selectByPrimaryKey(Long id) {
        return userBrowsingHistoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(UserBrowsingHistory record, UserBrowsingHistoryExample example) {
        return userBrowsingHistoryMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(UserBrowsingHistory record, UserBrowsingHistoryExample example) {
        return userBrowsingHistoryMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(UserBrowsingHistory record) {
        return userBrowsingHistoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserBrowsingHistory record) {
        return userBrowsingHistoryMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<UserBrowsingHistory> list) {
        return userBrowsingHistoryMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<UserBrowsingHistory> list) {
        return userBrowsingHistoryMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<UserBrowsingHistory> list) {
        return userBrowsingHistoryMapper.batchInsert(list);
    }

	@Override
	public int deleteByUserIdAndProductId(Long userId,Long productId){
		 return userBrowsingHistoryMapper.deleteByUserIdAndProductId(userId,productId);
	}

	@Override
	public UserBrowsingHistory selectOneByUserIdAndProductId(Long userId,Long productId){
		 return userBrowsingHistoryMapper.selectOneByUserIdAndProductId(userId,productId);
	}

	@Override
	public List<UserBrowsingHistory> selectByUserId(Long userId){
		 return userBrowsingHistoryMapper.selectByUserId(userId);
	}










}

