package com.gribbin.dao;

import com.gribbin.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    @Select("select * from user")
    List<User> getUsers();

    //有多个参数的时候必须加@Param注解
    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    @Insert("insert into user (id,name,pwd) values (#{id},#{name},#{password})")
    int addUser(User u);

    @Update("update user set name = #{name},pwd = #{password} where id = #{id}")
    int updateUser(User u);

    @Delete("delete from user where id = #{id}")
    int deleteUser(int id);
}