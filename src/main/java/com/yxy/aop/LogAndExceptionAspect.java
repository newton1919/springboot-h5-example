package com.yxy.aop;

import com.alibaba.fastjson.JSON;
import com.yxy.base.BusinessException;
import com.yxy.base.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.RequestFacade;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAndExceptionAspect {
    @Value("${printRequest}")
    private String printRequest;//从配置文件中读取是否打印请求

    @Value("${printResponse}")//从配置文件中读取是否打印返回
    private String printResponse;

    //该切点定位到所有的处理http请求的controller方法
    @Pointcut("execution(public * com.yxy.controller.*.*(..))")
    public void webLog() {}

    @Around(value = "webLog()")
    public Object doAround(ProceedingJoinPoint joinPoint){
        if (null == printRequest || "true".equals(printRequest)) {
            this.printRequestInfo(joinPoint);
        }
        //执行主代码逻辑
        RestResponse errResponse = new RestResponse(500, "");
        Object response = null;
        try {
            response = joinPoint.proceed();
        } catch (BusinessException ex) {
            log.error("", ex);
            errResponse.setStatus(ex.getCode());
            errResponse.setMessage(ex.getMsg());
            return errResponse;
        } catch (RuntimeException ex) {
            log.error("", ex);
            errResponse.setMessage(ex.getMessage());
            return errResponse;
        } catch (Throwable ex) {
            log.error("", ex);
            errResponse.setMessage("服务器繁忙，请稍后再试");
            return errResponse;
        }
        if (printResponse != null && printResponse.equals("true")) {
            this.printResponseInfo(joinPoint, response);
        }
        return response;
    }

    /**
     * 前置日志，打印请求信息
     * @param joinPoint
     */
    private void printRequestInfo(JoinPoint joinPoint) {
        StringBuffer params = new StringBuffer();
        if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
            for (int i = 0; i < joinPoint.getArgs().length; i++) {
                if (joinPoint.getArgs()[i] != null && joinPoint.getArgs()[i].getClass() != RequestFacade.class) {
                    params.append(JSON.toJSONString(joinPoint.getArgs()[i]) + ";");
                }
            }
        }
        log.info("--请求id--：" + joinPoint.hashCode());
        log.info("--请求接口--：" + joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()");
        log.info("--请求参数--：" + params.toString());

    }

    /**
     * 打印接口返回结果
     * @param joinPoint
     * @param res
     */
    private void printResponseInfo(JoinPoint joinPoint, Object res) {
        log.info("{}请求的返回结果为{}", joinPoint.hashCode(), JSON.toJSONString(res));
    }
}
