package com.itheima.health.service;

import com.itheima.health.entity.PageResult;
import com.itheima.health.entity.QueryPageBean;
import com.itheima.health.pojo.Setmeal;

import java.util.List;
import java.util.Map;

/**
 * @Author:Tianxiao
 * @Date: 2020/10/25 19:51
 */
public interface SetmealService {
    public void add(Setmeal setmeal,Integer[] checkgroupIds);

    PageResult<Setmeal> findPage(QueryPageBean queryPageBean);

    void deleteById(int id);

    Setmeal findById(int id);

    List<Integer> findCheckgroupIdsBySetmealId(int id);

    void update(Setmeal setmeal, Integer[] checkgroupIds);

    List<String> findImgs();

    public List<Map<String, Object>> getSetmealReport();
}
