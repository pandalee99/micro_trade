package com.sodse.trade.mapper;

import com.sodse.trade.domain.User;
import com.sodse.trade.domain.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

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
    int insert(User record);

    int insertOrUpdate(User record);

    int insertOrUpdateSelective(User record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    User selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(User record);

    int updateBatch(List<User> list);

    int batchInsert(@Param("list") List<User> list);



    List<User> findByUsername(@Param("username") String username);

    User selectById(@Param("id") Long id);

    List<User> selectByUsername(@Param("username") String username);

    User selectOneByUsername(@Param("username") String username);

    int delete();

    List<User> find();

    User selectOneByUsernameAndPassword(@Param("username")String username,@Param("password")String password);




}