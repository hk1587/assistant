package com.xinluo.assistant.entity.base;

import lombok.Data;

/**
 * 封装返回数据实体类
 */
@Data
public class ResponseDTO {
    /**
     * desc: 状态码
     */
    private String stateCode;      
    /**
     * desc: 返回数据给前端
     */
    private Object responseData;  
    /**
     * desc: 后台返回前段的 0代表成功 1代表失败;
     */
    private String message ; 
    /**
     * desc: 后台响应给前端的信息
     */
    private String messageDetail;   
    
    /**
     * desc: 后台响应时间
     */
    private Long responseTime = System.currentTimeMillis();
    

}
