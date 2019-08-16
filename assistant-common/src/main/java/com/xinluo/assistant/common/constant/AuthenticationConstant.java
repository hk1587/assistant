package com.xinluo.assistant.common.constant;

/**
 *
 *  @Description : 认证常量接口
 *  @Auhtor : ChengJing
 *  @Created : 2018/8/16 上午12:32
 *  
 */
public interface AuthenticationConstant {

    /**
     * desc: 调用认证接口前缀
     */
    String AUTHENTICATION_IDCARDNUM ="authentication_idCardNum";

    /**
     * desc: 认证接口每日可认证最大次数
     */
    int AUTHENTICATION_IDCARDNUM_MAXTIMES=3;
    
    /**
     * desc: 连续请求发送短信或者调用接口间隔 , 单位毫秒
     */
    int CONTINUOUS_MS = 30000;
    
    /**
     * desc: 用户存储token前缀
     */
    String USER_TOKEN_PRE = "token_";

    /**
     * desc: 调用银行卡认证接口前缀
     */
    String AUTHENTICATION_BANKCARDNUM ="authentication_bankCardNum";
}
