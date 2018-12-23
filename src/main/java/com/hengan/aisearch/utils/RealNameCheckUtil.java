package com.hengan.aisearch.utils;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 王晓涛
 * @Dcscription:
 * @Date: Created in 17:02 2018/8/25
 * @Modified By:
 */
public class RealNameCheckUtil{

    private static final String host = "https://idcardcert.market.alicloudapi.com";
    private static final String path = "/idCardCert";
    private static final String method = "GET";
    private static final String appcode = "5e1f3d531d654f67b76915443f5c7f58";

    public static String RealNameCheck(String realName,String idCard){
        String result = "";
        try {
            Map<String, String> headers = new HashMap<String, String>();
            headers.put("Authorization", "APPCODE " + appcode);
            Map<String, String> querys = new HashMap<String, String>();
            querys.put("name", realName);
            querys.put("idCard", idCard);
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            result = EntityUtils.toString(response.getEntity());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args){
        String result = RealNameCheck("王晓川","142402198903111216");
        System.out.println(result);
    }
}