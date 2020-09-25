package com.gribbin.mapper;

import com.gribbin.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserMapperImpl implements UserMapper {
    private SqlSessionTemplate sessionTemplate;

    public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
        this.sessionTemplate = sessionTemplate;
    }

    public List<User> getUserList() {
        UserMapper mapper = sessionTemplate.getMapper(UserMapper.class);
        return mapper.getUserList();
    }
}
