package com.sodse.trade.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.sodse.trade.mapper.ImagesMapper;
import java.util.List;
import com.sodse.trade.domain.ImagesExample;
import com.sodse.trade.domain.Images;
import com.sodse.trade.service.ImagesService;
@Service
public class ImagesServiceImpl implements ImagesService{

    @Resource
    private ImagesMapper imagesMapper;

    @Override
    public long countByExample(ImagesExample example) {
        return imagesMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ImagesExample example) {
        return imagesMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return imagesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Images record) {
        return imagesMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(Images record) {
        return imagesMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(Images record) {
        return imagesMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(Images record) {
        return imagesMapper.insertSelective(record);
    }

    @Override
    public List<Images> selectByExample(ImagesExample example) {
        return imagesMapper.selectByExample(example);
    }

    @Override
    public Images selectByPrimaryKey(Long id) {
        return imagesMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(Images record,ImagesExample example) {
        return imagesMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Images record,ImagesExample example) {
        return imagesMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Images record) {
        return imagesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Images record) {
        return imagesMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Images> list) {
        return imagesMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<Images> list) {
        return imagesMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<Images> list) {
        return imagesMapper.batchInsert(list);
    }

}
