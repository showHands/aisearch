package com.hengan.aisearch.utils;

public class Constants {

    /**设置界面重新获得验证码时间,60秒*/
    public static final Integer getNextCodeSecond = 60;
    /**验证码有效时间300000毫秒*/
    public static final Integer CodeSecond = 300000;

    /**
     * 一天
     */
    public static final Integer RestrictSecond = 24 * 60 * 60;

    /**
     * 一天内允许实名认证次数
     */
    public static final Integer realUserNum = 10;

    public static final Long REDIS_TIMEOUT = 3600L; //Redis时间



    public static final Integer REGISTER_TYPE_REG = 1; //注册
    public static final Integer REGISTER_TYPE_ZHMM = 2; //找回密码
    public static final Integer REGISTER_TYPE_XGDLMM = 3; //修改登录密码
    public static final Integer REGISTER_TYPE_SZZFMM = 4; //设置支付密码
    public static final Integer REGISTER_TYPE_XGZFMM = 5; //修改支付密码
    public static final Integer REGISTER_TYPE_ZHZFMM = 6; //找回支付密码
    public static final Integer REGISTER_TYPE_GHSB = 7; //更换设备
    public static final Integer REGISTER_TYPE_BGYHK = 8; //变更银行卡
    public static final Integer REGISTER_TYPE_LOGIN = 9; //登陆
    public static final Integer REGISTER_TYPE_WX_LOGIN = 10; //微信登陆
    public static final Integer WITHDRAW_TYPE_BINDING_ACCOUNT = 11; //绑定收款账号


    public static String CLIENT_CODE_APP = "APP";  //登录的客户端编码，默认是APP 20181207
    public static String CLIENT_CODE_H5 = "H5";
    public static String CLIENT_CODE_DAFYAUTH = "DAFYAUTH";

    /**
     * 用户状态
     */
    public static Integer USER_LOCKED = 1; //锁定
    public static Integer USER_UNLOCK = 0; //开启


    public static class Response {
        public static final Integer RESPONSE_CODE_OK = 0;
        public static final Integer RESPONSE_CODE_ERROR = -1;
    }

}
