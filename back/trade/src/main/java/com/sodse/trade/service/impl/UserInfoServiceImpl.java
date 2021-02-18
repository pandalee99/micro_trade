package com.sodse.trade.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.sodse.trade.domain.UserInfoExample;
import com.sodse.trade.mapper.UserInfoMapper;
import com.sodse.trade.domain.UserInfo;
import com.sodse.trade.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public long countByExample(UserInfoExample example) {
        return userInfoMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(UserInfoExample example) {
        return userInfoMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserInfo record) {
        return userInfoMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(UserInfo record) {
        return userInfoMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(UserInfo record) {
        return userInfoMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(UserInfo record) {
        return userInfoMapper.insertSelective(record);
    }

    @Override
    public List<UserInfo> selectByExample(UserInfoExample example) {
        return userInfoMapper.selectByExample(example);
    }

    @Override
    public UserInfo selectByPrimaryKey(Long id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(UserInfo record, UserInfoExample example) {
        return userInfoMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(UserInfo record, UserInfoExample example) {
        return userInfoMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(UserInfo record) {
        return userInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserInfo record) {
        return userInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<UserInfo> list) {
        return userInfoMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<UserInfo> list) {
        return userInfoMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<UserInfo> list) {
        return userInfoMapper.batchInsert(list);
    }

    @Override
    public List<UserInfo> selectByUserid(Long userid) {
        return userInfoMapper.selectByUserid(userid);
    }

    @Override
    public int delete() {
        return userInfoMapper.delete();
    }

	@Override
	public UserInfo selectOneByUserid(Long userid){
		 return userInfoMapper.selectOneByUserid(userid);
	}









}


