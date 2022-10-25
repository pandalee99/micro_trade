package com.sodse.trade.service;


import com.sodse.trade.domain.User;


public interface AuthService {

    Integer register(User userToAdd );
    String login( String username, String password );
}
