package com.itheima.health.job;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.health.service.SetmealService;

import java.util.List;

import com.itheima.health.utils.QiNiuUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author:Tianxiao
 * @Date: 2020/10/30 14:26
 */
@Component
public class CleanImgJob {

    private static final Logger logger = LoggerFactory.getLogger(CleanImgJob.class);


    @Reference
    private SetmealService setmealService;

    @Scheduled(fixedDelay = 1800000, initialDelay = 3000)
    public void cleanImg() {
        logger.info("清理七牛上垃圾图片的任务开始执行。。。");
        //获取七牛上的图片
        List<String> imgIn7Niu = QiNiuUtils.listFile();
        logger.debug("imgIn7Niu,有{}张图片要清理", imgIn7Niu.size());
        //获取数据库套餐的图片
        List<String> imgInDb = setmealService.findImgs();
        logger.debug("imgInDb,有{}张图片要清理", imgInDb.size());

        imgIn7Niu.removeAll(imgInDb);
        logger.debug("有{}张图片要清理", imgIn7Niu.size());

        try {
            logger.info("开始清理图片{}。。。", imgIn7Niu.size());
            QiNiuUtils.removeFiles(imgIn7Niu.toArray(new String[]{}));
            logger.info("开始清理图片。。。", imgIn7Niu.size());
        } catch (Exception e) {
            //e.printStackTrace();
            logger.error("清理垃圾图片出错了");
        }
    }
}
