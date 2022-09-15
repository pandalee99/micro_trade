package com.sodse.trade.service;

import java.util.List;
import com.sodse.trade.domain.UserBrowsingHistory;
import com.sodse.trade.domain.UserBrowsingHistoryExample;

public interface UserBrowsingHistoryService {


    long countByExample(UserBrowsingHistoryExample example);

    int deleteByExample(UserBrowsingHistoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserBrowsingHistory record);

    int insertOrUpdate(UserBrowsingHistory record);

    int insertOrUpdateSelective(UserBrowsingHistory record);

    int insertSelective(UserBrowsingHistory record);

    List<UserBrowsingHistory> selectByExample(UserBrowsingHistoryExample example);

    UserBrowsingHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(UserBrowsingHistory record, UserBrowsingHistoryExample example);

    int updateByExample(UserBrowsingHistory record, UserBrowsingHistoryExample example);

    int updateByPrimaryKeySelective(UserBrowsingHistory record);

    int updateByPrimaryKey(UserBrowsingHistory record);

    int updateBatch(List<UserBrowsingHistory> list);

    int updateBatchSelective(List<UserBrowsingHistory> list);

    int batchInsert(List<UserBrowsingHistory> list);



	int deleteByUserIdAndProductId(Long userId,Long productId);



	UserBrowsingHistory selectOneByUserIdAndProductId(Long userId,Long productId);



	List<UserBrowsingHistory> selectByUserId(Long userId);




}

