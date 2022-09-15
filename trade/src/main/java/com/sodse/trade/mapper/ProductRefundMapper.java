package com.sodse.trade.mapper;

import com.sodse.trade.domain.ProductRefund;
import com.sodse.trade.domain.ProductRefundExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductRefundMapper {
    long countByExample(ProductRefundExample example);

    int deleteByExample(ProductRefundExample example);

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
    int insert(ProductRefund record);

    int insertOrUpdate(ProductRefund record);

    int insertOrUpdateSelective(ProductRefund record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(ProductRefund record);

    List<ProductRefund> selectByExample(ProductRefundExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    ProductRefund selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProductRefund record, @Param("example") ProductRefundExample example);

    int updateByExample(@Param("record") ProductRefund record, @Param("example") ProductRefundExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(ProductRefund record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(ProductRefund record);

    int updateBatch(List<ProductRefund> list);

    int updateBatchSelective(List<ProductRefund> list);

    int batchInsert(@Param("list") List<ProductRefund> list);
}