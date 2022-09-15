package com.sodse.trade.service;

import com.sodse.trade.domain.User;
import java.util.List;
import com.sodse.trade.domain.UserExample;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {


    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertOrUpdate(User record);

    int insertOrUpdateSelective(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByExampleSelective(User record, UserExample example);

    int updateByExample(User record, UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int updateBatch(List<User> list);

    int updateBatchSelective(List<User> list);

    int batchInsert(List<User> list);


    List<User> findByUsername(String username);


    User selectById(Long id);


    List<User> selectByUsername(String username);


    User selectOneByUsername(String username);


    int delete();



	List<User> find();



	User selectOneByUsernameAndPassword(String username,String password);




}


