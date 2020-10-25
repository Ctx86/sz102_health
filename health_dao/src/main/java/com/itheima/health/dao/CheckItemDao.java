package com.itheima.health.dao;

import com.github.pagehelper.Page;
import com.itheima.health.pojo.CheckItem;

import java.util.List;

/**
 * @Author:Tianxiao
 * @Date: 2020/10/23 15:54
 */
public interface CheckItemDao {
    List<CheckItem> findAll();

    void add(CheckItem checkItem);

    Page<CheckItem> findPage(String queryPageBean);

    int findCountByCheckItemId(int id);

    void deleteById(int id);

    CheckItem findById(int id);

    void update();
}
