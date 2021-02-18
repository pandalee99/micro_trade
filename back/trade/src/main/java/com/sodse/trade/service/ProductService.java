package com.sodse.trade.service;

import com.github.pagehelper.PageInfo;
import com.sodse.trade.domain.Product;
import java.util.List;
import com.sodse.trade.domain.ProductExample;

public interface ProductService {


    long countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    int insertOrUpdate(Product record);

    int insertOrUpdateSelective(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(Long id);

    int updateByExampleSelective(Product record, ProductExample example);

    int updateByExample(Product record, ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    int updateBatch(List<Product> list);

    int updateBatchSelective(List<Product> list);

    int batchInsert(List<Product> list);


    List<Product> find();


     PageInfo<Product> findByPagewithPage(int page, int pageSize);



	Product selectOneById(Long id);




}






