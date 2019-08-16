package com.xinluo.assistant.web.base;


import com.xinluo.assistant.common.constant.CommonConstant;
import com.xinluo.assistant.common.constant.StateConstant;
import com.xinluo.assistant.common.utils.RedisUtil;
import com.xinluo.assistant.entity.base.ResponseDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;

public abstract class BaseController {

    public Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    protected RedisUtil redisUtil;
    
    /**
     * 自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseDTO handleException(Exception e) {
        logger.info("-----服务器出现异常-------");
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage(CommonConstant.RESPONSE_MESSAGE_FAIL);
        responseDTO.setMessageDetail("服务器繁忙，请稍后再试");
        responseDTO.setStateCode(StateConstant.ERROR);
        e.printStackTrace();
        logger.info("异常原因为 "+e.getCause().getMessage());
        if(("登陆授权失败").equals(e.getCause().getMessage())){
            responseDTO.setStateCode(StateConstant.AUTHENTICATION_FAILED);
            responseDTO.setMessageDetail("登陆授权失败");
        }

        return responseDTO;
    }
}
