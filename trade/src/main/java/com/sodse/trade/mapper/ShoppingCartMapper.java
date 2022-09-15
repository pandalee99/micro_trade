package com.sodse.trade.mapper;

import com.sodse.trade.domain.ShoppingCart;
import com.sodse.trade.domain.ShoppingCartExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingCartMapper {
    long countByExample(ShoppingCartExample example);

    int deleteByExample(ShoppingCartExample example);

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
    int insert(ShoppingCart record);

    int insertOrUpdate(ShoppingCart record);

    int insertOrUpdateSelective(ShoppingCart record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(ShoppingCart record);

    List<ShoppingCart> selectByExample(ShoppingCartExample example);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    ShoppingCart selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingCart record, @Param("example") ShoppingCartExample example);

    int updateByExample(@Param("record") ShoppingCart record, @Param("example") ShoppingCartExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(ShoppingCart record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(ShoppingCart record);

    int updateBatch(List<ShoppingCart> list);

    int batchInsert(@Param("list") List<ShoppingCart> list);

    int updateBatchSelective(List<ShoppingCart> list);

    List<ShoppingCart> selectByUserId(@Param("userId") Long userId);
}