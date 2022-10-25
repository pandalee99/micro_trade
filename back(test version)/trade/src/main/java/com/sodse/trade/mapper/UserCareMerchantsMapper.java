package com.sodse.trade.mapper;

import com.sodse.trade.domain.UserCareMerchants;
import com.sodse.trade.domain.UserCareMerchantsExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserCareMerchantsMapper {
    long countByExample(UserCareMerchantsExample example);

    int deleteByExample(UserCareMerchantsExample example);

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
    int insert(UserCareMerchants record);

    int insertOrUpdate(UserCareMerchants record);

    int insertOrUpdateSelective(UserCareMerchants record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(UserCareMerchants record);

    List<UserCareMerchants> selectByExample(UserCareMerchantsExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    UserCareMerchants selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserCareMerchants record, @Param("example") UserCareMerchantsExample example);

    int updateByExample(@Param("record") UserCareMerchants record, @Param("example") UserCareMerchantsExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(UserCareMerchants record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(UserCareMerchants record);

    int updateBatch(List<UserCareMerchants> list);

    int updateBatchSelective(List<UserCareMerchants> list);

    int batchInsert(@Param("list") List<UserCareMerchants> list);

    List<UserCareMerchants> selectByUserId(@Param("userId")Long userId);

    int deleteByUserIdAndMerchantId(@Param("userId")Long userId,@Param("merchantId")Long merchantId);

}