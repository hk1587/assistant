package com.xinluo.assistant.entity.base;

import lombok.Data;

import java.util.Date;

/**
 * 功能性基础对象
 */
@Data
public abstract class BaseBean {
    /**
     * desc: 创建日期
     */
    protected Date createDate; 
    
    /**
     * desc: 修改日期
     */
    protected Date updateDate; 
    
    /**
     * desc: 创建人
     */
    protected Long createBy; 
    
    /**
     * desc: 修改人
     */
    protected Long updateBy; 
    
    /**
     * desc: 用户认证token
     */
    protected String token;
    
    /**
     * desc: 避免重复标志
     */
    protected String avoidDuplicateToken;

    /**
     * desc: 每页显示多少条
     */
    protected Integer pageSize;

    /**
     * desc: 起始位置
     */
    protected Integer beginNo;

    /**
     * desc: 当前页数
     */
    protected Integer pageNo;

}
