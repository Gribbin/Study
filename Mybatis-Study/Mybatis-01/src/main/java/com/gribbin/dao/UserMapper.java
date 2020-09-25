package com.gribbin.dao;

import com.gribbin.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();

    List<User> getUserLike(String value);

    User getUserById(int id);

    int addUser(User u);

    int addUser2(Map<String, Object> map);

    int updateUser(User u);

    int deleteUser(int id);
}
