package com.sodse.trade.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.sodse.trade.domain.Product;
import java.util.List;
import com.sodse.trade.domain.ProductExample;
import com.sodse.trade.mapper.ProductMapper;
import com.sodse.trade.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public long countByExample(ProductExample example) {
        return productMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ProductExample example) {
        return productMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Product record) {
        return productMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(Product record) {
        return productMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(Product record) {
        return productMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(Product record) {
        return productMapper.insertSelective(record);
    }

    @Override
    public List<Product> selectByExample(ProductExample example) {
        return productMapper.selectByExample(example);
    }

    @Override
    public Product selectByPrimaryKey(Long id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Product record, ProductExample example) {
        return productMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Product record, ProductExample example) {
        return productMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Product record) {
        return productMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Product record) {
        return productMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Product> list) {
        return productMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<Product> list) {
        return productMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<Product> list) {
        return productMapper.batchInsert(list);
    }

    @Override
    public List<Product> find() {
        return productMapper.find();
    }


    public PageInfo<Product> findByPagewithPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        return new PageInfo<>(productMapper.findByPage(page,pageSize));
    }

	@Override
    @Cacheable(value = "products", key = "'get_product_'+#id")
	public Product selectOneById(Long id){

        return productMapper.selectOneById(id);
	}



}






