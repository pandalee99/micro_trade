package com.sodse.trade.mapper;

import com.sodse.trade.domain.UserCollection;
import com.sodse.trade.domain.UserCollectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserCollectionMapper {
    long countByExample(UserCollectionExample example);

    int deleteByExample(UserCollectionExample example);

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
    int insert(UserCollection record);

    int insertOrUpdate(UserCollection record);

    int insertOrUpdateSelective(UserCollection record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(UserCollection record);

    List<UserCollection> selectByExample(UserCollectionExample example);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    UserCollection selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserCollection record, @Param("example") UserCollectionExample example);

    int updateByExample(@Param("record") UserCollection record, @Param("example") UserCollectionExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(UserCollection record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(UserCollection record);

    int updateBatch(List<UserCollection> list);

    int batchInsert(@Param("list") List<UserCollection> list);

    int updateBatchSelective(List<UserCollection> list);

    int deleteByUserIdAndProductId(@Param("userId") Long userId, @Param("productId") Long productId);

    List<UserCollection> selectByUserId(@Param("userId") Long userId);
}