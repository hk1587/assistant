package com.xinluo.assistant.web.filter;


import com.xinluo.assistant.common.utils.RSAEncryption;
import com.xinluo.assistant.common.utils.RedisUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 *
 *  @description : 处理数据AOP
 *  @auhtor : ChengJing
 *  @created : 2018/8/5 下午9:36
 *  
 */
@Aspect
@Configuration
public class TokenAspect {
    
    
    private Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private RedisUtil redisUtil;
    
    @Value("${assistant.rsa.privateKey}")
    private String privateKey;

    
    /**所有带有此注解的方法都必须要认证*/
    @Pointcut("@annotation(com.xinluo.assistant.common.annotation.Authentication)")
    public void authentication(){}

    @Pointcut("@annotation(com.xinluo.assistant.common.annotation.APPAuthentication)")
    public void APPAuthentication(){}

    @Pointcut("@annotation(com.xinluo.assistant.common.annotation.PaperAuthentication)")
    public void PaperAuthentication(){}
    
    /**
     * @desc 在进入controller方法之前 拦截所有需要 @Authentication 认证的
     * @param point
     * @throws Exception
     */
    @Before("authentication()")
    public void tokenAuthentication(JoinPoint point) throws Throwable {
        Logger logger = LogManager.getLogger(point.getTarget().getClass());
            // 获取操作类、方法、参数信息
        String javaClassName = point.getTarget().getClass().getName();
        String javaClassMethodName = point.getSignature().getName();

        logger.info("执行的类为---： " + javaClassName + "------执行的方法为：" + javaClassMethodName);

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        
        //判断header中是否存在对应参数
        String token = request.getHeader("token");

        /**
         *  如果token 不为空，对token 进行安全性校验
         */
        if(token != null){
            /**
             * 从redis中读取当前用户属性。
             */
            //解密 token
            token = RSAEncryption.RSADecode(RSAEncryption.getPrivateKey(privateKey), token);
            if(token == null){
                throw  new Exception("登陆授权失败");
            }
            logger.info("-----------token值为 "+token);
            if(redisUtil.get(token) == null){
                throw  new Exception("登陆授权失败");
            }
            Object user = redisUtil.get(token);
            if(user == null){
                throw  new Exception("登陆授权失败");
            }    
        }else{
            throw  new Exception("登陆授权失败");
        }
    }

    /**
     * @desc 在进入controller方法之前 拦截所有需要 @Authentication 认证的
     * @param point
     * @throws Exception
     */
    @Before("PaperAuthentication()")
    public void tokenPaperAuthentication(JoinPoint point) throws Throwable {
        Logger logger = LogManager.getLogger(point.getTarget().getClass());
        // 获取操作类、方法、参数信息
        String javaClassName = point.getTarget().getClass().getName();
        String javaClassMethodName = point.getSignature().getName();

        logger.info("执行的类为---： " + javaClassName + "------执行的方法为：" + javaClassMethodName);

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        //判断header中是否存在对应参数
        String token = request.getHeader("paperToken");

        /**
         *  如果token 不为空，对token 进行安全性校验
         */
        if(token != null){
            /**
             * 从redis中读取当前用户属性。
             */
            //解密 token
            token = RSAEncryption.RSADecode(RSAEncryption.getPrivateKey(privateKey), token);
            if(token == null){
                throw  new Exception("登陆授权失败");
            }
            logger.info("-----------token值为 "+token);
            if(!token.equals("akjo*7733*#@@%")){
                throw  new Exception("登陆授权失败");
            }
        }else{
            throw  new Exception("登陆授权失败");
        }
    }


    /**
     * @desc 在进入controller方法之前 拦截所有需要 @APPAuthentication 认证的
     * @param point
     * @throws Exception
     */
    @Before("APPAuthentication()")
    public void APPTokenAuthentication(JoinPoint point) throws Throwable {
        Logger logger = LogManager.getLogger(point.getTarget().getClass());
        // 获取操作类、方法、参数信息
        String javaClassName = point.getTarget().getClass().getName();
        String javaClassMethodName = point.getSignature().getName();

        logger.info("APP调用的类为---： " + javaClassName + "------APP调用的方法为：" + javaClassMethodName);

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        //判断header中是否存在对应参数
        String token = request.getHeader("token");

        /**
         *  如果token 不为空，对token 进行安全性校验
         */
        if(token != null){
            /**
             * 从redis中读取当前用户属性。
             */
            //解密 token
            token = RSAEncryption.RSADecode(RSAEncryption.getPrivateKey(privateKey), token);
            if(token == null){
                throw  new Exception("登陆授权失败");
            }
            logger.info("-----------token值为 "+token);
            if(!"appToFlupkey".equalsIgnoreCase(token)){
                throw  new Exception("登陆授权失败");
            }
        }else{
            throw  new Exception("登陆授权失败");
        }
    }
}

