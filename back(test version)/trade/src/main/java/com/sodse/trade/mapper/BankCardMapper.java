package com.sodse.trade.mapper;

import com.sodse.trade.domain.BankCard;
import com.sodse.trade.domain.BankCardExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BankCardMapper {
    long countByExample(BankCardExample example);

    int deleteByExample(BankCardExample example);

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
    int insert(BankCard record);

    int insertOrUpdate(BankCard record);

    int insertOrUpdateSelective(BankCard record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(BankCard record);

    List<BankCard> selectByExample(BankCardExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    BankCard selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BankCard record, @Param("example") BankCardExample example);

    int updateByExample(@Param("record") BankCard record, @Param("example") BankCardExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(BankCard record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(BankCard record);

    int updateBatch(List<BankCard> list);

    int updateBatchSelective(List<BankCard> list);

    int batchInsert(@Param("list") List<BankCard> list);

    int delete();


}