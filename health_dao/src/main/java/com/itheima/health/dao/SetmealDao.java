package com.itheima.health.dao;

import com.github.pagehelper.Page;
import com.itheima.health.pojo.Setmeal;

import java.util.List;
import java.util.Map;

/**
 * @Author:Tianxiao
 * @Date: 2020/10/25 19:59
 */
public interface SetmealDao {
    public void add(Setmeal setmeal) ;

    public void addSetmealCheckGroup(Integer setmealId, Integer checkgroupId) ;

    Page<Setmeal> findByCondition(String queryString);

    int findOrderCountBySetmealId(int id);

    void deleteSetmealCheckGroup(int id);

    void deleteById(int id);

    Setmeal findById(int id);

    List<Integer> findCheckgroupIdsBySetmealId(int id);

    void update(Setmeal setmeal);

    List<String> findImgs();

    List<Map<String, Object>> getSetmealReport();
}
