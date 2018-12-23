package com.hengan.aisearch.utils;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Classname ParamsValidUtils
 * @Description request域中参数校验工具
 * @Date 2018/11/16 16:33
 * @Created by 王晓涛
 */
@Slf4j
public class ParamsValidUtils {

    /**
     *  校验request请求域中必传的业务参数
     * @param strServiceName
     * @param strTransName
     * @param keys
     * @return
     */
    public static List<String> validParams(HttpServletRequest request,Map<String,Object> paramsMap, String strServiceName, String strTransName, String...keys){
        log.info("strServiceName = [" + strServiceName + "], strTransName = [" + strTransName + "]");
        List<String> paramValidResultList = new ArrayList<>();
        for(int i = 0; i < keys.length; i++){
            String key = keys[i];
            if(!request.getParameterMap().containsKey(key) && paramsMap!= null && !paramsMap.containsKey(key)){
                paramValidResultList.add(key+"不存在");
                return paramValidResultList;
            }
        }
        return null;
    }
}
