package com.itheima.health.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.health.dao.MemberDao;
import com.itheima.health.service.CheckItemService;
import com.itheima.health.service.MemberService;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Tianxiao
 * @Date: 2020/11/1 11:33
 */
@Service(interfaceClass = MemberService.class)
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public List<Integer> getMemberReport(List<String> months) {
        List<Integer> memberCount = new ArrayList<>();
        if (months != null) {
            for (String month : months) {
                Integer count = memberDao.findMemberCountBeforeDate(month + "-31");
                memberCount.add(count);
            }
        }
        return memberCount;
    }
}
