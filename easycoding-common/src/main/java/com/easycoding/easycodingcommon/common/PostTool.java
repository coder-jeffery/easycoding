package com.easycoding.easycodingcommon.common;

import com.alibaba.fastjson.JSON;
import com.easycoding.easycodingcommon.contract.HttpPostResponse;
import com.easycoding.easycodingcommon.contract.Response;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * 调用接口工具
 * */

public class PostTool {

    public static Response PostData(String url, String postContent) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        StringEntity requestEntity = new StringEntity(postContent, "utf-8");
        requestEntity.setContentEncoding("utf-8");
        httpPost.setHeader("Content-type", "application/json;charset=utf-8");
        httpPost.setEntity(requestEntity);
        CloseableHttpResponse response = httpclient.execute(httpPost);

        HttpEntity httpentity = response.getEntity();
        String str = EntityUtils.toString(httpentity, "utf-8");
        Response result = JSON.parseObject(str, Response.class);
        return result;
    }



    public static Response PostData_XWFU(String url, String postContent) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        StringEntity requestEntity = new StringEntity(postContent, "utf-8");
        requestEntity.setContentEncoding("utf-8");
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
        httpPost.setEntity(requestEntity);
        CloseableHttpResponse response = httpclient.execute(httpPost);

        HttpEntity httpentity = response.getEntity();
        String str = EntityUtils.toString(httpentity, "utf-8");
        Response result = JSON.parseObject(str, Response.class);
        return result;
    }


    public static  CloseableHttpResponse PostDataPlus(String url, String postContent) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        StringEntity requestEntity = new StringEntity(postContent, "utf-8");
        requestEntity.setContentEncoding("utf-8");
        httpPost.setHeader("Content-type", "application/json;charset=utf-8");
        httpPost.setEntity(requestEntity);
        return httpclient.execute(httpPost);
    }


    public static HttpPostResponse GetData(String url, String postContent) throws IOException {
        HttpPostResponse result =new HttpPostResponse();
        result.setSuccess(false);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        StringEntity requestEntity = new StringEntity(postContent, "utf-8");
        requestEntity.setContentEncoding("utf-8");
        httpGet.setHeader("Content-type", "application/json;charset=utf-8");
        CloseableHttpResponse response=httpclient.execute(httpGet);
        HttpEntity httpentity = response.getEntity();
        String str = EntityUtils.toString(httpentity, "utf-8");
        Integer statusCode=response.getStatusLine().getStatusCode();
        result.setCode(statusCode);
        if(statusCode == 200){
            result.setSuccess(true);
        }
        else {
            result.setSuccess(false);
        }
        result.setMsg(response.getStatusLine().getReasonPhrase());
        result.setData(str);
        return result;
    }
}
