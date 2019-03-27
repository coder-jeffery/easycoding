package com.easycoding.easycodingcommon.contract;

import lombok.Data;

@Data
public class HttpPostResponse {

    /**
     * 状态码
     */
    private  Integer code;
    /**
     * true-成功 、 false-失败
     */
    private  boolean success;
    /**
     * 成功、失败
     */
    private  String msg;
    /**
     * 业务数据对象
     */
    private  Object data;
}
