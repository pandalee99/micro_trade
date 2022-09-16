package com.sodse.trade.mapper;

import com.sodse.trade.domain.OrderSheet;
import com.sodse.trade.domain.OrderSheetExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderSheetMapper {
    long countByExample(OrderSheetExample example);

    int deleteByExample(OrderSheetExample example);

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
    int insert(OrderSheet record);

    int insertOrUpdate(OrderSheet record);

    int insertOrUpdateSelective(OrderSheet record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(OrderSheet record);

    List<OrderSheet> selectByExample(OrderSheetExample example);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    OrderSheet selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderSheet record, @Param("example") OrderSheetExample example);

    int updateByExample(@Param("record") OrderSheet record, @Param("example") OrderSheetExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(OrderSheet record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(OrderSheet record);

    int updateBatch(List<OrderSheet> list);

    int batchInsert(@Param("list") List<OrderSheet> list);



    int delete();

    OrderSheet selectOneById(@Param("id") Long id);

    List<OrderSheet> selectByUserId(@Param("userId") Long userId);
}