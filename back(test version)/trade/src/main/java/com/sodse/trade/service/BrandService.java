package com.sodse.trade.service;

import java.util.List;
import com.sodse.trade.domain.BrandExample;
import com.sodse.trade.domain.Brand;
public interface BrandService{


    long countByExample(BrandExample example);

    int deleteByExample(BrandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Brand record);

    int insertOrUpdate(Brand record);

    int insertOrUpdateSelective(Brand record);

    int insertSelective(Brand record);

    List<Brand> selectByExample(BrandExample example);

    Brand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(Brand record,BrandExample example);

    int updateByExample(Brand record,BrandExample example);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);

    int updateBatch(List<Brand> list);

    int updateBatchSelective(List<Brand> list);

    int batchInsert(List<Brand> list);



	int delete();


}
