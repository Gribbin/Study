package com.gribbin.dao;

import com.gribbin.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> getUserList();

    Integer addUser(User user);

    Integer deleteUser(int id);
}
