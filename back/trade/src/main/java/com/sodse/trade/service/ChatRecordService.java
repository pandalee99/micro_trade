package com.sodse.trade.service;

import java.util.List;
import com.sodse.trade.domain.ChatRecordExample;
import com.sodse.trade.domain.ChatRecord;

public interface ChatRecordService {


    long countByExample(ChatRecordExample example);

    int deleteByExample(ChatRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ChatRecord record);

    int insertOrUpdate(ChatRecord record);

    int insertOrUpdateSelective(ChatRecord record);

    int insertSelective(ChatRecord record);

    List<ChatRecord> selectByExample(ChatRecordExample example);

    ChatRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(ChatRecord record, ChatRecordExample example);

    int updateByExample(ChatRecord record, ChatRecordExample example);

    int updateByPrimaryKeySelective(ChatRecord record);

    int updateByPrimaryKey(ChatRecord record);

    int updateBatch(List<ChatRecord> list);

    int updateBatchSelective(List<ChatRecord> list);

    int batchInsert(List<ChatRecord> list);



	List<ChatRecord> selectByUserIdAndTalkerId(Long userId,Long talkerId);


}

