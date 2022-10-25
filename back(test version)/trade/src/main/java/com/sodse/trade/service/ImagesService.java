package com.sodse.trade.service;

import java.util.List;
import com.sodse.trade.domain.ImagesExample;
import com.sodse.trade.domain.Images;
public interface ImagesService{


    long countByExample(ImagesExample example);

    int deleteByExample(ImagesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Images record);

    int insertOrUpdate(Images record);

    int insertOrUpdateSelective(Images record);

    int insertSelective(Images record);

    List<Images> selectByExample(ImagesExample example);

    Images selectByPrimaryKey(Long id);

    int updateByExampleSelective(Images record,ImagesExample example);

    int updateByExample(Images record,ImagesExample example);

    int updateByPrimaryKeySelective(Images record);

    int updateByPrimaryKey(Images record);

    int updateBatch(List<Images> list);

    int updateBatchSelective(List<Images> list);

    int batchInsert(List<Images> list);

}
