package com.xinluo.assistant.common.constant;

/**
 * 后端响应前端状态码 接口
 */
public interface StateConstant {

    /**
     * desc: 200 响应成功
     */
    String SUCCESS = "200";

    /**
     * desc: 500 响应失败
     */
    String ERROR ="500";

    /**
     * desc: 402 授权失败
     */
    String AUTHENTICATION_FAILED = "402";
    
    /**
     * desc: 阿里云返回数据状态
     */
    String ID_CARD_NUM_AUTHENTICATION_SUCCESS="0";
    
    /**
     * desc: 阿里云返回数据正常
     */
    String ALIBABA_RESPONSE_DATA_SUCCESS = "ok";
}
