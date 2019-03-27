package com.easycoding.easycodingcommon.contract;

import lombok.Data;

@Data
public class Response {

    //1=成功 -1=失败
    private String code = "200";

    private String appCode;

    private boolean success = true;

    //消息内容
    private String msg = "成功";

    private Object data;

}

