package com.sodse.trade.service;

import com.sodse.trade.domain.UserFriendExample;
import com.sodse.trade.domain.UserFriend;
import java.util.List;
public interface UserFriendService{


    long countByExample(UserFriendExample example);

    int deleteByExample(UserFriendExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserFriend record);

    int insertOrUpdate(UserFriend record);

    int insertOrUpdateSelective(UserFriend record);

    int insertSelective(UserFriend record);

    List<UserFriend> selectByExample(UserFriendExample example);

    UserFriend selectByPrimaryKey(Long id);

    int updateByExampleSelective(UserFriend record,UserFriendExample example);

    int updateByExample(UserFriend record,UserFriendExample example);

    int updateByPrimaryKeySelective(UserFriend record);

    int updateByPrimaryKey(UserFriend record);

    int updateBatch(List<UserFriend> list);

    int updateBatchSelective(List<UserFriend> list);

    int batchInsert(List<UserFriend> list);



	List<UserFriend> selectByUserId(Long userId);


}
