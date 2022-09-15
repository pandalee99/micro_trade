package com.sodse.trade.mapper;

import com.sodse.trade.domain.MerchantMoveNews;
import com.sodse.trade.domain.MerchantMoveNewsExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MerchantMoveNewsMapper {
    long countByExample(MerchantMoveNewsExample example);

    int deleteByExample(MerchantMoveNewsExample example);

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
    int insert(MerchantMoveNews record);

    int insertOrUpdate(MerchantMoveNews record);

    int insertOrUpdateSelective(MerchantMoveNews record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(MerchantMoveNews record);

    List<MerchantMoveNews> selectByExample(MerchantMoveNewsExample example);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    MerchantMoveNews selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MerchantMoveNews record, @Param("example") MerchantMoveNewsExample example);

    int updateByExample(@Param("record") MerchantMoveNews record, @Param("example") MerchantMoveNewsExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(MerchantMoveNews record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(MerchantMoveNews record);

    int updateBatch(List<MerchantMoveNews> list);

    int batchInsert(@Param("list") List<MerchantMoveNews> list);


    List<MerchantMoveNews> selectAllByMerchantId(@Param("merchantId")Long merchantId);


}