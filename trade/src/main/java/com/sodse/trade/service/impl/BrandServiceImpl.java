package com.sodse.trade.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.sodse.trade.domain.BrandExample;
import com.sodse.trade.mapper.BrandMapper;
import com.sodse.trade.domain.Brand;
import com.sodse.trade.service.BrandService;
@Service
public class BrandServiceImpl implements BrandService{

    @Resource
    private BrandMapper brandMapper;

    @Override
    public long countByExample(BrandExample example) {
        return brandMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(BrandExample example) {
        return brandMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Brand record) {
        return brandMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(Brand record) {
        return brandMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(Brand record) {
        return brandMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(Brand record) {
        return brandMapper.insertSelective(record);
    }

    @Override
    public List<Brand> selectByExample(BrandExample example) {
        return brandMapper.selectByExample(example);
    }

    @Override
    public Brand selectByPrimaryKey(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Brand record,BrandExample example) {
        return brandMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Brand record,BrandExample example) {
        return brandMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Brand record) {
        return brandMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Brand record) {
        return brandMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Brand> list) {
        return brandMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<Brand> list) {
        return brandMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<Brand> list) {
        return brandMapper.batchInsert(list);
    }

	@Override
	public int delete(){
		 return brandMapper.delete();
	}




}
