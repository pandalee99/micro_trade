package com.sodse.trade.mapper;

import com.sodse.trade.domain.UserInfo;
import com.sodse.trade.domain.UserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserInfoMapper {
    long countByExample(UserInfoExample example);

    int deleteByExample(UserInfoExample example);

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
    int insert(UserInfo record);

    int insertOrUpdate(UserInfo record);

    int insertOrUpdateSelective(UserInfo record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(UserInfo record);

    List<UserInfo> selectByExample(UserInfoExample example);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    UserInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(UserInfo record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(UserInfo record);

    int updateBatch(List<UserInfo> list);

    int batchInsert(@Param("list") List<UserInfo> list);

    int updateBatchSelective(List<UserInfo> list);

    List<UserInfo> selectByUserid(@Param("userid") Long userid);

    int delete();

    UserInfo selectOneByUserid(@Param("userid")Long userid);





}