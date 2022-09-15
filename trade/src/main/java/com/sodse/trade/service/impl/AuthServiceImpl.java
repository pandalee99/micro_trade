package com.sodse.trade.service.impl;


import com.sodse.trade.Util.JwtTokenUtil;
import com.sodse.trade.domain.ChatRecord;
import com.sodse.trade.domain.User;
import com.sodse.trade.domain.UserFriend;
import com.sodse.trade.service.AuthService;
import com.sodse.trade.service.ChatRecordService;
import com.sodse.trade.service.UserFriendService;
import com.sodse.trade.service.UserService;
import com.sodse.trade.tools.snow.RandomId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    @Qualifier("myUserDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    // 登录
    @Override
    public String login( String username, String password ) {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken( username, password );
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final UserDetails userDetails = userDetailsService.loadUserByUsername( username );
        final String token = jwtTokenUtil.generateToken(userDetails);
        return token;
    }

    // 注册
    @Override
    public Integer register( User userToAdd ) {

        final String username = userToAdd.getUsername();
        if( !userService.findByUsername(username).isEmpty() ) {
            return null;
        }
        //当用户不存在时
        userToAdd=qq_register(userToAdd);
        //qq注册的处理
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = userToAdd.getPassword();
        userToAdd.setPassword( encoder.encode(rawPassword) );
        return userService.insert(userToAdd);
    }

    @Autowired
    UserFriendService userFriendService;

    @Autowired
    ChatRecordService chatRecordService;

    public User qq_register(User user){
        user.setId(new RandomId().nextId());
        user.setPassword("123456");
        user.setFlag(1);
        user.setLevel(1);
        user.setIdImg(user.getUserImg());
        user.setRoles("ROLE_USER");
        user.setMoney(new BigDecimal(10000));
        user.setDescription("当前您使用QQ注册，系统初次赠送10000。此处可随意更改个人介绍");


        //注册时给一个朋友
        UserFriend f1=new UserFriend();
        f1.setId(new RandomId().nextId());
        f1.setUserId(user.getId());
        f1.setFriendId(1L);
        f1.setNoteName("test");
        userFriendService.insert(f1);

        UserFriend f2=new UserFriend();
        f2.setId(new RandomId().nextId());
        f2.setUserId(1L);
        f2.setFriendId(user.getId());
        f2.setNoteName(user.getUsername());
        userFriendService.insert(f2);

        //注册时给一个聊天信息
        ChatRecord chatRecord=new ChatRecord();
        Long userId = user.getId();
        Long talkerId = 1L;
        chatRecord.setUserId(userId);
        chatRecord.setTalkerId(talkerId);
        chatRecord.setIsSend(0);
        chatRecord.setContent("您好，我是test，编号为1");
        chatRecord.setId(new RandomId().nextId());
        chatRecord.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        chatRecordService.insert(chatRecord);

        return user;
    }
}
