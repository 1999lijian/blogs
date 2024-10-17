package com.li.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Author LIJIAN
 * @Date 2024/10/17 17:52
 * 日志
 */

//@Aspect :切面
//@Component ：组件扫描
@Aspect
@Component
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

//    Pointcut :标识切面
//    execution ： 拦截路径
    @Pointcut("execution(* com.li.web.*.*(..))")
    public void log(){

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
//        获取url + ip+拦截方法名
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();

String classMethod = joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName();
Object[] args = joinPoint.getArgs();
        RequestLog requestlog = new RequestLog(url,ip,classMethod,args);
logger.info("Request:{}"+requestlog);
    }

    @After("log()")
    public void doAfter(){
//        logger.info("=====doAfter=====");
    }

    @AfterReturning(returning = "result" , pointcut = "log()")
    public void doAfterRutrun(Object result){
        logger.info("Result:{}"+result);
    }


    private class RequestLog{
//        请求的路径
        private String url;
//        请求ip
        private String ip;
//        调用方法
        private String classMethod;
//        返回内容
        private Object[] args;

//全参构造
        public RequestLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }
//toString方法
        @Override
        public String toString() {
            return "RequestLog{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}
