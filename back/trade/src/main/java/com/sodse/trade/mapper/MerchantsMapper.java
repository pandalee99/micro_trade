package com.sodse.trade.mapper;

import com.sodse.trade.domain.Merchants;
import com.sodse.trade.domain.MerchantsExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MerchantsMapper {
    long countByExample(MerchantsExample example);

    int deleteByExample(MerchantsExample example);

    /**
     * delete by primary key
     * @param merchantId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long merchantId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Merchants record);

    int insertOrUpdate(Merchants record);

    int insertOrUpdateSelective(Merchants record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Merchants record);

    List<Merchants> selectByExample(MerchantsExample example);

    /**
     * select by primary key
     * @param merchantId primary key
     * @return object by primary key
     */
    Merchants selectByPrimaryKey(Long merchantId);

    int updateByExampleSelective(@Param("record") Merchants record, @Param("example") MerchantsExample example);

    int updateByExample(@Param("record") Merchants record, @Param("example") MerchantsExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Merchants record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Merchants record);

    int updateBatch(List<Merchants> list);

    int updateBatchSelective(List<Merchants> list);

    int batchInsert(@Param("list") List<Merchants> list);

    Merchants findOneByMerchantName(@Param("merchantName")String merchantName);

    List<Merchants> selectByMerchantName(@Param("merchantName")String merchantName);

    Merchants selectOneByMerchantName(@Param("merchantName")String merchantName);

    Merchants selectOneByShopName(@Param("shopName")String shopName);

    List<Merchants> findAll();

    int deleteByShopName(@Param("shopName")String shopName);

    int delete();

    Merchants selectOneByUserId(@Param("userId")Long userId);










}