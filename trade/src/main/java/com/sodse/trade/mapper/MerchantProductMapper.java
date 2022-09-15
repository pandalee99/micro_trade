package com.sodse.trade.mapper;

import com.sodse.trade.domain.MerchantProduct;
import com.sodse.trade.domain.MerchantProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MerchantProductMapper {
    long countByExample(MerchantProductExample example);

    int deleteByExample(MerchantProductExample example);

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
    int insert(MerchantProduct record);

    int insertOrUpdate(MerchantProduct record);

    int insertOrUpdateSelective(MerchantProduct record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(MerchantProduct record);

    List<MerchantProduct> selectByExample(MerchantProductExample example);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    MerchantProduct selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MerchantProduct record, @Param("example") MerchantProductExample example);

    int updateByExample(@Param("record") MerchantProduct record, @Param("example") MerchantProductExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(MerchantProduct record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(MerchantProduct record);

    int updateBatch(List<MerchantProduct> list);

    int batchInsert(@Param("list") List<MerchantProduct> list);

    int updateBatchSelective(List<MerchantProduct> list);

    MerchantProduct selectOneByProductId(@Param("productId")Long productId);

    List<MerchantProduct> selectByMerchantId(@Param("merchantId")Long merchantId);


}