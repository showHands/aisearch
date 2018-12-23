package com.hengan.aisearch.utils;

/*import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.ListObjectsRequest;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;*/
import com.sun.javafx.binding.StringFormatter;

/**
 * 阿里云OSS对象存储服务
 */
public class OSSUtils {
    private static String baseurl = "http://hhross.oss-cn-beijing.aliyuncs.com/";
    private static String endpoint = "http://oss-cn-beijing.aliyuncs.com/";
    private static String accessKeyId = "LTAIZGStZlSmMPyC";
    private static String accessKeySecret = "82F8y5Nf3BAnwxaUjBoA7o2y4L17C9";
    private static String buckert = "hhross";

    public static String getSuffixWithSlash(String profile, String entity) {
        return StringFormatter.format("%s/%s/", profile, entity).get();
    }

    /**
     * 上传图片
     * @param file
     * @param keySuffixWithSlash
     * @return
     */
    /*public static Map<String, String> upload(MultipartFile file,String keySuffixWithSlash) {
        Map<String,String> outputmap = new HashMap<String,String>();
        outputmap.put("result","0");
        try {
            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            boolean found = ossClient.doesObjectExist(buckert, keySuffixWithSlash);
            if (!found) {
                ossClient.putObject(buckert, keySuffixWithSlash, new ByteArrayInputStream(new byte[0]));
            }
            String fileName = file.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            fileName = UUID.randomUUID() + suffixName;
            ossClient.putObject(buckert, keySuffixWithSlash+fileName, file.getInputStream());
            ossClient.shutdown();
            outputmap.put("url",baseurl+keySuffixWithSlash+fileName);
            outputmap.put("result","1");
            return outputmap;
        }
        catch (OSSException e) {
            e.printStackTrace();
        }
        catch (ClientException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return outputmap;
    }

    public static Map<String, String> upload(File file, String keySuffixWithSlash) {
        Map<String,String> outputmap = new HashMap<String,String>();
        outputmap.put("result","0");
        try {
            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            boolean found = ossClient.doesObjectExist(buckert, keySuffixWithSlash);
            if (!found) {
                ossClient.putObject(buckert, keySuffixWithSlash, new ByteArrayInputStream(new byte[0]));
            }
            String fileName = file.getName();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            fileName = UUID.randomUUID() + suffixName;
            ossClient.putObject(buckert, keySuffixWithSlash+fileName, new FileInputStream(file));
            ossClient.shutdown();
            outputmap.put("url",baseurl+keySuffixWithSlash+fileName);
            outputmap.put("result","1");
        }
        catch (OSSException e) {
            e.printStackTrace();
        }
        catch (ClientException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return outputmap;
    }

    *//**
     * 获取指定路径图片列表
     * @param keySuffixWithSlash
     * @return
     *//*
    public static List<String> getImages(String keySuffixWithSlash) {
        List<String> list = new ArrayList<String>();
        try {
            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            // 构造ListObjectsRequest请求
            ListObjectsRequest listObjectsRequest = new ListObjectsRequest(buckert);
            listObjectsRequest.setDelimiter("/");
            listObjectsRequest.setPrefix(keySuffixWithSlash);
            ObjectListing objectListing = ossClient.listObjects(listObjectsRequest);
            List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
            for (OSSObjectSummary s : sums) {
                if (s.getKey().indexOf(".")>1)
                    list.add(baseurl+s.getKey());
            }
        }
        catch (OSSException e) {
            e.printStackTrace();
        }
        catch (ClientException e) {
            e.printStackTrace();
        }
        return list;
    }*/
}

