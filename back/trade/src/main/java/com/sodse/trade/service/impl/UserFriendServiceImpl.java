package com.sodse.trade.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.sodse.trade.mapper.UserFriendMapper;
import com.sodse.trade.domain.UserFriendExample;
import com.sodse.trade.domain.UserFriend;
import java.util.List;
import com.sodse.trade.service.UserFriendService;
@Service
public class UserFriendServiceImpl implements UserFriendService{

    @Resource
    private UserFriendMapper userFriendMapper;

    @Override
    public long countByExample(UserFriendExample example) {
        return userFriendMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(UserFriendExample example) {
        return userFriendMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userFriendMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserFriend record) {
        return userFriendMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(UserFriend record) {
        return userFriendMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(UserFriend record) {
        return userFriendMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(UserFriend record) {
        return userFriendMapper.insertSelective(record);
    }

    @Override
    public List<UserFriend> selectByExample(UserFriendExample example) {
        return userFriendMapper.selectByExample(example);
    }

    @Override
    public UserFriend selectByPrimaryKey(Long id) {
        return userFriendMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(UserFriend record,UserFriendExample example) {
        return userFriendMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(UserFriend record,UserFriendExample example) {
        return userFriendMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(UserFriend record) {
        return userFriendMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserFriend record) {
        return userFriendMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<UserFriend> list) {
        return userFriendMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<UserFriend> list) {
        return userFriendMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<UserFriend> list) {
        return userFriendMapper.batchInsert(list);
    }

	@Override
	public List<UserFriend> selectByUserId(Long userId){
		 return userFriendMapper.selectByUserId(userId);
	}




}
