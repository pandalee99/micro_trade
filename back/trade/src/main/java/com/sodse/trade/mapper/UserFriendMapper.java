package com.sodse.trade.mapper;

import com.sodse.trade.domain.UserFriend;
import com.sodse.trade.domain.UserFriendExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserFriendMapper {
    long countByExample(UserFriendExample example);

    int deleteByExample(UserFriendExample example);

    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(UserFriend record);

    int insertOrUpdate(UserFriend record);

    int insertOrUpdateSelective(UserFriend record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(UserFriend record);

    List<UserFriend> selectByExample(UserFriendExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    UserFriend selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserFriend record, @Param("example") UserFriendExample example);

    int updateByExample(@Param("record") UserFriend record, @Param("example") UserFriendExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(UserFriend record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(UserFriend record);

    int updateBatch(List<UserFriend> list);

    int updateBatchSelective(List<UserFriend> list);

    int batchInsert(@Param("list") List<UserFriend> list);

    List<UserFriend> selectByUserId(@Param("userId")Long userId);


}