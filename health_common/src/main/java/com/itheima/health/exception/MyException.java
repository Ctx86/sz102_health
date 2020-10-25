package com.itheima.health.exception;

/**
 * 自定义异常
 * 1.区分系统和业务异常
 * 2.给用户有好的提示信息
 * 3.终止已知的不符合业务逻辑的代码继续执行
 *
 * @Author:Tianxiao
 * @Date: 2020/10/24 11:05
 */

public class MyException extends RuntimeException {

    public MyException(String message) {
        super(message);
    }

}
