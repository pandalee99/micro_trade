package com.sodse.trade.service;

import java.util.List;
import com.sodse.trade.domain.UserCollectionExample;
import com.sodse.trade.domain.UserCollection;

public interface UserCollectionService {


    long countByExample(UserCollectionExample example);

    int deleteByExample(UserCollectionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserCollection record);

    int insertOrUpdate(UserCollection record);

    int insertOrUpdateSelective(UserCollection record);

    int insertSelective(UserCollection record);

    List<UserCollection> selectByExample(UserCollectionExample example);

    UserCollection selectByPrimaryKey(Long id);

    int updateByExampleSelective(UserCollection record, UserCollectionExample example);

    int updateByExample(UserCollection record, UserCollectionExample example);

    int updateByPrimaryKeySelective(UserCollection record);

    int updateByPrimaryKey(UserCollection record);

    int updateBatch(List<UserCollection> list);

    int updateBatchSelective(List<UserCollection> list);

    int batchInsert(List<UserCollection> list);


    int deleteByUserIdAndProductId(Long userId, Long productId);


    List<UserCollection> selectByUserId(Long userId);


}


