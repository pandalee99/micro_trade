package com.sodse.trade.mapper;

import com.sodse.trade.domain.UserBrowsingHistory;
import com.sodse.trade.domain.UserBrowsingHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserBrowsingHistoryMapper {
    long countByExample(UserBrowsingHistoryExample example);

    int deleteByExample(UserBrowsingHistoryExample example);

    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(UserBrowsingHistory record);

    int insertOrUpdate(UserBrowsingHistory record);

    int insertOrUpdateSelective(UserBrowsingHistory record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(UserBrowsingHistory record);

    List<UserBrowsingHistory> selectByExample(UserBrowsingHistoryExample example);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    UserBrowsingHistory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserBrowsingHistory record, @Param("example") UserBrowsingHistoryExample example);

    int updateByExample(@Param("record") UserBrowsingHistory record, @Param("example") UserBrowsingHistoryExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(UserBrowsingHistory record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(UserBrowsingHistory record);

    int updateBatch(List<UserBrowsingHistory> list);

    int batchInsert(@Param("list") List<UserBrowsingHistory> list);

    int updateBatchSelective(List<UserBrowsingHistory> list);

    int deleteByUserIdAndProductId(@Param("userId")Long userId,@Param("productId")Long productId);

	UserBrowsingHistory selectOneByUserIdAndProductId(@Param("userId")Long userId,@Param("productId")Long productId);

    List<UserBrowsingHistory> selectByUserId(@Param("userId")Long userId);


}