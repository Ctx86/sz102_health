package com.itheima.health.service;

import com.itheima.health.pojo.CheckItem;

import java.util.List;

/**
 * @Author:Tianxiao
 * @Date: 2020/10/23 15:47
 */
public interface CheckItemService {


    List<CheckItem> findAll();

    void add(CheckItem checkItem);
}
