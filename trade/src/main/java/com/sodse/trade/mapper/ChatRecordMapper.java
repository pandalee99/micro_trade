package com.sodse.trade.mapper;

import com.sodse.trade.domain.ChatRecord;
import com.sodse.trade.domain.ChatRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ChatRecordMapper {
    long countByExample(ChatRecordExample example);

    int deleteByExample(ChatRecordExample example);

    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(ChatRecord record);

    int insertOrUpdate(ChatRecord record);

    int insertOrUpdateSelective(ChatRecord record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(ChatRecord record);

    List<ChatRecord> selectByExample(ChatRecordExample example);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    ChatRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ChatRecord record, @Param("example") ChatRecordExample example);

    int updateByExample(@Param("record") ChatRecord record, @Param("example") ChatRecordExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(ChatRecord record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(ChatRecord record);

    int updateBatch(List<ChatRecord> list);

    int batchInsert(@Param("list") List<ChatRecord> list);

    int updateBatchSelective(List<ChatRecord> list);

    List<ChatRecord> selectByUserIdAndTalkerId(@Param("userId")Long userId,@Param("talkerId")Long talkerId);


}