package com.sodse.trade.mapper;

import com.sodse.trade.domain.Product;
import com.sodse.trade.domain.ProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductMapper {
    long countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

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
    int insert(Product record);

    int insertOrUpdate(Product record);

    int insertOrUpdateSelective(Product record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    Product selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Product record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Product record);

    int updateBatch(List<Product> list);

    int batchInsert(@Param("list") List<Product> list);

    int updateBatchSelective(List<Product> list);

    //    返回全部的产品
    List<Product> find();

    List<Product> findByPage(int start,int end);

    Product selectOneById(@Param("id")Long id);




}