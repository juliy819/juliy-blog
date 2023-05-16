package com.juliy.manager.factory;

import cn.hutool.extra.spring.SpringUtil;
import com.juliy.entity.ExceptionLog;
import com.juliy.entity.OperationLog;
import com.juliy.entity.VisitLog;
import com.juliy.service.ExceptionLogService;
import com.juliy.service.OperationLogService;
import com.juliy.service.VisitLogService;

import java.util.TimerTask;

/**
 * 异步工厂
 * @author juliy
 * @date 2023/5/16 17:48
 */
public class AsyncFactory {

    /**
     * 记录操作日志
     * @param operationLog 操作日志信息
     * @return 任务task
     */
    public static TimerTask recordOperation(OperationLog operationLog) {
        return new TimerTask() {
            @Override
            public void run() {
                SpringUtil.getBean(OperationLogService.class).saveOperationLog(operationLog);
            }
        };
    }

    /**
     * 记录异常日志
     * @param exceptionLog 异常日志信息
     * @return 任务task
     */
    public static TimerTask recordException(ExceptionLog exceptionLog) {
        return new TimerTask() {
            @Override
            public void run() {
                SpringUtil.getBean(ExceptionLogService.class).saveExceptionLog(exceptionLog);
            }
        };
    }

    /**
     * 记录访问日志
     * @param visitLog 访问日志信息
     * @return 任务task
     */
    public static TimerTask recordVisit(VisitLog visitLog) {
        return new TimerTask() {
            @Override
            public void run() {
                SpringUtil.getBean(VisitLogService.class).saveVisitLog(visitLog);
            }
        };
    }

}
