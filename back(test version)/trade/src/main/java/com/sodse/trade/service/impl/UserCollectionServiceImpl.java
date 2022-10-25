package com.sodse.trade.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.sodse.trade.mapper.UserCollectionMapper;
import com.sodse.trade.domain.UserCollectionExample;
import com.sodse.trade.domain.UserCollection;
import com.sodse.trade.service.UserCollectionService;

@Service
public class UserCollectionServiceImpl implements UserCollectionService {

    @Resource
    private UserCollectionMapper userCollectionMapper;

    @Override
    public long countByExample(UserCollectionExample example) {
        return userCollectionMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(UserCollectionExample example) {
        return userCollectionMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return userCollectionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserCollection record) {
        return userCollectionMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(UserCollection record) {
        return userCollectionMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(UserCollection record) {
        return userCollectionMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(UserCollection record) {
        return userCollectionMapper.insertSelective(record);
    }

    @Override
    public List<UserCollection> selectByExample(UserCollectionExample example) {
        return userCollectionMapper.selectByExample(example);
    }

    @Override
    public UserCollection selectByPrimaryKey(Long id) {
        return userCollectionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(UserCollection record, UserCollectionExample example) {
        return userCollectionMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(UserCollection record, UserCollectionExample example) {
        return userCollectionMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(UserCollection record) {
        return userCollectionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserCollection record) {
        return userCollectionMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<UserCollection> list) {
        return userCollectionMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<UserCollection> list) {
        return userCollectionMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<UserCollection> list) {
        return userCollectionMapper.batchInsert(list);
    }

    @Override
    public int deleteByUserIdAndProductId(Long userId, Long productId) {
        return userCollectionMapper.deleteByUserIdAndProductId(userId, productId);
    }

    @Override
    public List<UserCollection> selectByUserId(Long userId) {
        return userCollectionMapper.selectByUserId(userId);
    }


}


