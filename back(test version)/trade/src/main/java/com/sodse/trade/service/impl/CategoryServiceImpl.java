package com.sodse.trade.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.sodse.trade.domain.Category;
import java.util.List;
import com.sodse.trade.domain.CategoryExample;
import com.sodse.trade.mapper.CategoryMapper;
import com.sodse.trade.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public long countByExample(CategoryExample example) {
        return categoryMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(CategoryExample example) {
        return categoryMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Category record) {
        return categoryMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(Category record) {
        return categoryMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(Category record) {
        return categoryMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(Category record) {
        return categoryMapper.insertSelective(record);
    }

    @Override
    public List<Category> selectByExample(CategoryExample example) {
        return categoryMapper.selectByExample(example);
    }

    @Override
    public Category selectByPrimaryKey(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Category record,CategoryExample example) {
        return categoryMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Category record,CategoryExample example) {
        return categoryMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Category record) {
        return categoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Category record) {
        return categoryMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Category> list) {
        return categoryMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<Category> list) {
        return categoryMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<Category> list) {
        return categoryMapper.batchInsert(list);
    }

}
