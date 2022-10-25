package com.sodse.trade.mapper;

import com.sodse.trade.domain.Category;
import com.sodse.trade.domain.CategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CategoryMapper {
    long countByExample(CategoryExample example);

    int deleteByExample(CategoryExample example);

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
    int insert(Category record);

    int insertOrUpdate(Category record);

    int insertOrUpdateSelective(Category record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Category record);

    List<Category> selectByExample(CategoryExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Category selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Category record, @Param("example") CategoryExample example);

    int updateByExample(@Param("record") Category record, @Param("example") CategoryExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Category record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Category record);

    int updateBatch(List<Category> list);

    int updateBatchSelective(List<Category> list);

    int batchInsert(@Param("list") List<Category> list);
}