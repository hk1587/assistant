package com.xinluo.assistant.common.constant;


/**
 * 常用常量
 */
public interface CommonConstant {

    /**
     * desc: 
     *      RESPONSE_MESSAGE_SUCCESS 返回成功
     *      RESPONSE_MESSAGE_FAIL 返回失败
     */
    String RESPONSE_MESSAGE_SUCCESS = "0";
    String RESPONSE_MESSAGE_FAIL = "1";

    String TOKEN_USER_PRE = "user_";

    String TOKEN_YUN_HUJIAO = "yunhu_";

    String PATIENT_INFO_PATH = "/peripheral/listPatientInfo";

    int NAME_RESERVE_LENGTH = 1;

    int PHONE_NUMBER_RESERVE_LENGTH = 3;

    int IDENTITY_NUMBER_RESERVE_LENGTH = 2;

    int ADDRESS_RESERVE_LENGTH = 2;

    /**
     * desc: 登录登出业务名
     */
    String USER_LOGIN = "login";
    String USER_LOGOUT = "logout";

    /**
     * desc: 字符串为空
     */
    String NULL_STRING = "null";
    String EMPTY_STRING = "";

    String CYCLE_ONE = "每月1次";

    String CYCLE_TWO = "第1、3、6、12个月";

    String CYCLE_THREE = "第1、12、24、36个月";
}
