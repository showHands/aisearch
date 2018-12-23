package com.hengan.aisearch.vo;

import com.hengan.aisearch.utils.Constants;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * API接口返回数据封装对象类
 */
@Data
public class ResponseBean {

    // http 状态码
    private int code;
    // 返回信息
    private String message;
    // 返回的数据
    private Object data;
    // 异常信息
    private String error;


    public ResponseBean(int code, String message, Object data, String error) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.error = error;
    }

    public ResponseBean() {

    }

    public static ResponseBean success(String msg) {
        return getBean(Constants.Response.RESPONSE_CODE_OK, msg, null, null);
    }

    public static ResponseBean success(Integer code, String msg) {
        return getBean(code, msg, null, null);
    }

    public static ResponseBean success(String msg, Object data) {
        return getBean(Constants.Response.RESPONSE_CODE_OK, msg, data, null);
    }

    public static ResponseBean successdata(Object data) {
        return getBean(Constants.Response.RESPONSE_CODE_OK, "", data, null);
    }

    public static ResponseBean successdata(Integer code, Object data) {
        return getBean(code, "", data, null);
    }

    public static ResponseBean successdata(Integer code, String message, Object data) {
        return getBean(code, message, data, null);
    }

    public static ResponseBean error() {
        return getBean(HttpStatus.INTERNAL_SERVER_ERROR.value(), "未知异常，请联系管理员", null, null);
    }

    public static ResponseBean error(int code, String msg) {
        return getBean(code, msg, null, null);
    }

    public static ResponseBean error(String msg, String error) {
        return getBean(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg, null, error);
    }

    public static ResponseBean error(String msg) {
        return getBean(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg, null, null);
    }

    public static ResponseBean getBean(int code, String message, Object data, String error) {
        ResponseBean r = new ResponseBean();
        r.setCode(code);
        r.setMessage(message);
        r.setData(data);
        r.setError(error);
        return r;
    }

    public static ResponseBean setPageInfo() {
        ResponseBean responseBean = new ResponseBean();
        return responseBean;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
