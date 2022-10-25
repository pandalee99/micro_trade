package com.sodse.trade.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.sodse.trade.mapper.ChatRecordMapper;
import java.util.List;
import com.sodse.trade.domain.ChatRecordExample;
import com.sodse.trade.domain.ChatRecord;
import com.sodse.trade.service.ChatRecordService;

@Service
public class ChatRecordServiceImpl implements ChatRecordService {

    @Resource
    private ChatRecordMapper chatRecordMapper;

    @Override
    public long countByExample(ChatRecordExample example) {
        return chatRecordMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ChatRecordExample example) {
        return chatRecordMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return chatRecordMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ChatRecord record) {
        return chatRecordMapper.insert(record);
    }

    @Override
    public int insertOrUpdate(ChatRecord record) {
        return chatRecordMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(ChatRecord record) {
        return chatRecordMapper.insertOrUpdateSelective(record);
    }

    @Override
    public int insertSelective(ChatRecord record) {
        return chatRecordMapper.insertSelective(record);
    }

    @Override
    public List<ChatRecord> selectByExample(ChatRecordExample example) {
        return chatRecordMapper.selectByExample(example);
    }

    @Override
    public ChatRecord selectByPrimaryKey(Long id) {
        return chatRecordMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(ChatRecord record, ChatRecordExample example) {
        return chatRecordMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(ChatRecord record, ChatRecordExample example) {
        return chatRecordMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(ChatRecord record) {
        return chatRecordMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ChatRecord record) {
        return chatRecordMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<ChatRecord> list) {
        return chatRecordMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<ChatRecord> list) {
        return chatRecordMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<ChatRecord> list) {
        return chatRecordMapper.batchInsert(list);
    }

	@Override
	public List<ChatRecord> selectByUserIdAndTalkerId(Long userId,Long talkerId){
		 return chatRecordMapper.selectByUserIdAndTalkerId(userId,talkerId);
	}




}

