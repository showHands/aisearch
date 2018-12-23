package com.hengan.aisearch.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by thonny on 2015-6-3.
 */
public class StringUtil {



    /**
     * 将请求返回的key=value&形式的参数解析放到map中
     * @param param
     * @return
     */
    public static Map<String,String> parseParam(String param){
        String[] paramArr = param.split("&");
        Map<String,String> result = new HashMap<String,String>();
        for (String keyVal : paramArr) {
            String[] p = keyVal.split("=");
            if(p.length<2){
                result.put(p[0], "");
            }else {
                result.put(p[0], p[1]);
            }
        }
        return result;
    }

    /**
     * 判断给定的字符串是否为空,以及空字符串
     *
     * @param input
     *            输入字符串
     * @return 是否为空,空则返回true，反之亦反
     * @since 0.1
     */
    public static boolean blank(String input) {
        return input == null || "".equals(input) || input.length() == 0
                || input.trim().length() == 0;
    }

    /**
     * 判断给定的字符串不为空
     *
     * @param input
     *            输入字符串
     * @return 是否不为空，不为空返回true，反之亦反.
     * @since 0.1
     */
    public static boolean notBlank(String input) {
        return !blank(input);
    }

    public static String parseMapToString(Map<String, Object> paramsMap){
        StringBuffer sb = new StringBuffer();
        sb.append("map数据解析：");
        for(String key: paramsMap.keySet()){
            sb.append("["+key+":"+paramsMap.get(key)+"],");
        }
        return sb.toString();
    }

}
