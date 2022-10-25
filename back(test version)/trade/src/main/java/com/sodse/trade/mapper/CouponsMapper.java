package com.sodse.trade.mapper;

import com.sodse.trade.domain.Coupons;
import com.sodse.trade.domain.CouponsExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CouponsMapper {
    long countByExample(CouponsExample example);

    int deleteByExample(CouponsExample example);

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
    int insert(Coupons record);

    int insertOrUpdate(Coupons record);

    int insertOrUpdateSelective(Coupons record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Coupons record);

    List<Coupons> selectByExample(CouponsExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Coupons selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Coupons record, @Param("example") CouponsExample example);

    int updateByExample(@Param("record") Coupons record, @Param("example") CouponsExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Coupons record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Coupons record);

    int updateBatch(List<Coupons> list);

    int updateBatchSelective(List<Coupons> list);

    int batchInsert(@Param("list") List<Coupons> list);
}