package com.learn.chapter3.mapper;

import com.learn.chapter3.po.User;

public interface UserMapper {
    public User getUser(Long id);
    public int insertUser(User user);
}
