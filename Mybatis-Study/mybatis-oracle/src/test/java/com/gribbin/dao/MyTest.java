package com.gribbin.dao;

import com.gribbin.pojo.Broker;
import com.gribbin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BrokerMapper mapper = sqlSession.getMapper(BrokerMapper.class);
        List<Broker> brokers = mapper.queryBroker();
        for (Broker broker : brokers) {
            System.out.println(broker);
        }

        sqlSession.close();
    }
}
