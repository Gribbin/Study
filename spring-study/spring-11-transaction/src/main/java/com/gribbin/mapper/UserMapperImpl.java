package com.gribbin.mapper;

import com.gribbin.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper {

    public List<User> getUserList() {
        User user = new User(6,"事务测试","564563");

        UserMapper mapper = getSqlSession().getMapper(UserMapper.class);
        mapper.addUser(user);
        mapper.deleteUser(6);
        return mapper.getUserList();
    }

    public Integer addUser(User user) {
        return getSqlSession().getMapper(UserMapper.class).addUser(user);
    }

    public Integer deleteUser(int id) {
        return getSqlSession().getMapper(UserMapper.class).deleteUser(id);
    }
}
