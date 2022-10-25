package com.sodse.trade.mapper;

import com.sodse.trade.domain.Brand;
import com.sodse.trade.domain.BrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BrandMapper {
    long countByExample(BrandExample example);

    int deleteByExample(BrandExample example);

    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Brand record);

    int insertOrUpdate(Brand record);

    int insertOrUpdateSelective(Brand record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Brand record);

    List<Brand> selectByExample(BrandExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Brand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Brand record, @Param("example") BrandExample example);

    int updateByExample(@Param("record") Brand record, @Param("example") BrandExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Brand record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Brand record);

    int updateBatch(List<Brand> list);

    int updateBatchSelective(List<Brand> list);

    int batchInsert(@Param("list") List<Brand> list);

    int delete();


}