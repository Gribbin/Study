package com.gribbin.service;

import com.gribbin.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookService {
    @Qualifier("bookDao")
    @Autowired(required = false)//新版Spring建议@Autowired加在构造函数或者setter方法上
    @Resource(name = "bookDao2")
    private BookDao bookDao;

    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDao +
                '}';
    }
}
