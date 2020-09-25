package com.gribbin.dao;

import com.gribbin.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> getUserList();

    User getUserById(int id);

    int addUser(User u);

    int updateUser(User u);

    int deleteUser(int id);
}
