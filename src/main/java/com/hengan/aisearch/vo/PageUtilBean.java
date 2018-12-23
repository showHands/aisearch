package com.hengan.aisearch.vo;

import lombok.Data;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 王晓涛
 * @Dcscription:
 * @Date: Created in 20:46 2018/2/26
 * @Modified By:
 */
@Data
public class PageUtilBean {

    // http 状态码
    private int code;
    // 返回信息
    private String msg;
    // 返回信息
    private long count;
    // 返回的数据
    private Object data;
    // 下一页数据起始下标
    private Long flag;
    //上一页数据其实下标
    private Long flagPre;

    public PageUtilBean(){
    }

    public static PageUtilBean success(long count, Object data){
        return getBean(HttpStatus.SC_OK, "success",count,data);
    }

    /**
     *
     * @param code
     * @param count
     * @param data
     * @param pageSize
     * @param pageStartIndex  其实查询下标 limit pageStartIndex, pageSize
     * @return
     */
    public static PageUtilBean success(Integer code,long count, Object data, long pageSize, long pageStartIndex, String msg){
        Long flag , flagPre;
        long nCurrentCount = pageStartIndex + pageSize ;
        if(count > nCurrentCount){
            flag = nCurrentCount ;
        }else{
            flag = null;
        }

        if(pageStartIndex > 0 && pageStartIndex - pageSize > 0){
            flagPre = pageStartIndex - pageSize;
        }else{
            flagPre = 0l;
        }
        return getBean(code, msg,count,data, flag, flagPre);
    }

    public static PageUtilBean success(Integer code,long count, Object data, String msg){
        return getBean(code, msg,count,data);
    }


    public static PageUtilBean getBean(int code, String msg, long count, Object data){
        PageUtilBean page = new PageUtilBean();
        page.setCode(code);
        page.setMsg(msg);
        page.setData(data);
        page.setCount(count);
        return page;
    }

    public static PageUtilBean getBean(int code, String msg, long count, Object data, Long flag, Long flagPre){
        PageUtilBean page = new PageUtilBean();
        page.setCode(code);
        page.setMsg(msg);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("count", count);
        resultMap.put("userEntityList",  data);
        page.setData(resultMap);
        page.setCount(count);
        page.setFlag(flag);
        page.setFlagPre(flagPre);
        return page;
    }

    public static PageUtilBean getBean(int code, String msg, long count, Object data, Long flag){
        PageUtilBean page = new PageUtilBean();
        page.setCode(code);
        page.setMsg(msg);
        page.setData(data);
        page.setCount(count);
        page.setFlag(flag);
        return page;
    }

    public static PageUtilBean error(Integer code, String message){
        return getBean(code, message,0,null);
    }

    public int getCode(){
        return code;
    }

    public void setCode(int code){
        this.code = code;
    }

    public String getMsg(){
        return msg;
    }

    public void setMsg(String msg){
        this.msg = msg;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Long getFlag() {
        return flag;
    }

    public void setFlag(Long flag) {
        this.flag = flag;
    }

    public Long getFlagPre() {
        return flagPre;
    }

    public void setFlagPre(Long flagPre) {
        this.flagPre = flagPre;
    }
}
