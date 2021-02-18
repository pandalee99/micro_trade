package com.sodse.trade.mapper;

import com.sodse.trade.domain.Images;
import com.sodse.trade.domain.ImagesExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ImagesMapper {
    long countByExample(ImagesExample example);

    int deleteByExample(ImagesExample example);

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
    int insert(Images record);

    int insertOrUpdate(Images record);

    int insertOrUpdateSelective(Images record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Images record);

    List<Images> selectByExample(ImagesExample example);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Images selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Images record, @Param("example") ImagesExample example);

    int updateByExample(@Param("record") Images record, @Param("example") ImagesExample example);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Images record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Images record);

    int updateBatch(List<Images> list);

    int updateBatchSelective(List<Images> list);

    int batchInsert(@Param("list") List<Images> list);
}