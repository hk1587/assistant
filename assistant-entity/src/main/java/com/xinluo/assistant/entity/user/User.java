package com.xinluo.assistant.entity.user;

import com.xinluo.assistant.entity.base.BaseBean;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 患者实体类
 */

@ToString
@Data
public class User extends BaseBean implements Serializable{

    private static final long serialVersionUID = -6635270823327177045L;

    /**
     * desc: 用户ID
     */
    private Long userId;
    /**
     * desc: 用户名
     */
    private String loginName;
    /**
     * desc: 手机号
     */
    private String mobileNum; 
    
    /**
     * desc: 密码
     */
    private String password; 
    
    /**
     * desc: 旧密码
     */
    private String oldPassword;
    
    /**
     * desc: 账户启用状态
     */
    private Integer status;
    /**
     * desc: 家庭住址
     */
    private String address;   
    
    /**
     * desc: 头像文件id
     */
    private String headPortraitUrl;  
    
    /**
     * desc: 性别 1:男,2:女,3:其他
     */
    private Integer sex ;    
    
    /**
     * desc: 年龄
     */
    private String age;    
    
    /**
     * desc: 出生日期
     */
    private Date birthday;
    
    /**
     * desc: 电子邮件
     */
    private String email;   
    /**
     * desc: 身份证号
     */
    private String idCardNum;  
    
    /**
     * desc: 是否实名认证 0位没有认证, 1位已经认证
     */
    private Integer idCardNumVerified;
    
    /**
     * desc: 验证码
     */
    private String verificationCode;

    /**
     * desc: 姓名
     */
    private String name;

    /**
     * desc: 医院代码
     */
    private String hospitalCode;

    /**
     * desc: 随访状态
     */
    private String flupStatus;

    /**
     * desc: 家庭住址
     */
    private String province;

    private String city;

    /**
     * desc: 医院名
     */
    private String hospitalName;

    private String yhjKey;

    private String yhjId;

    private String title;

    private String professional;

    private String office;

    private Integer isZzys;

    private String zyks;
    
    /**
     * desc: 云呼叫中心实例
     */
    private String cccInstance;
}
