package com.itheima.health.service;

import com.itheima.health.entity.PageResult;
import com.itheima.health.entity.QueryPageBean;
import com.itheima.health.exception.MyException;
import com.itheima.health.pojo.CheckItem;

import java.util.List;

/**
 * @Author:Tianxiao
 * @Date: 2020/10/23 15:47
 */
public interface CheckItemService {


    List<CheckItem> findAll();

    void add(CheckItem checkItem);

    PageResult<CheckItem> findPage(QueryPageBean queryPageBean);

    void deleteById(int id) throws MyException;

    CheckItem findById(int id);

    void update(CheckItem checkItem);
}
