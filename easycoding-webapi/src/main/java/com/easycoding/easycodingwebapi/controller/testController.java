package com.easycoding.easycodingwebapi.controller;


import com.easycoding.easycodingwebapi.common.RandomTool;
import com.easycoding.easycodingwebapi.entity.TbUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import java.io.BufferedReader;
import com.alibaba.fastjson.JSONObject;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

@Api(description = "EASY SYSTEM 1.0v")
@RestController
@RequestMapping("/easy")
@Slf4j
public class testController {


    @Autowired
    private ConfigurableEnvironment env;


    @ApiOperation(value = "测试接口:index",notes="测试接口:index")
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){


        return "easy run success";
    }


//    数据初始化操作

    @ApiOperation(value = "initData", notes = "index")
    @RequestMapping(value = "/initData", method = RequestMethod.GET)
    public String initData() {

        FileReader in = null;

        try {
//            in = getResourceAsStream("init-data/videojj_user.json");
            in = new FileReader(env.getProperty("init.data"));
        } catch (IOException e) {
            log.error("TestController.initData ==> read data from json file error!!", e);
            return "init data error!!";
        }

        BufferedReader bufferedReader = new BufferedReader(in);

        String data = null;

        TbUser tbUser = null;

        try {
            while ((data = bufferedReader.readLine()) != null) {
                try {
                    JSONObject jsonObject = JSONObject.parseObject(data);

                    if (StringUtils.isEmpty(jsonObject.get("hashedPassword").toString())) {
                        continue;
                    }


                    String userId = JSONObject.parseObject(jsonObject.get("_id").toString()).get("$oid").toString();

                    tbUser = new TbUser();

                    tbUser.setUserid(userId);

                    tbUser.setSystemId("video-os");

                    tbUser.setCreator("os");

                    tbUser.setModifier("os");

                    tbUser.setEmail(jsonObject.get("email").toString());

                    tbUser.setIsDeleted("N");

                    tbUser.setPassword(jsonObject.get("hashedPassword").toString());

                    tbUser.setSalt(jsonObject.get("salt").toString());

                    if (null != jsonObject.get("phone")) {
                        if (jsonObject.get("phone").toString().length() == 11) {
                            tbUser.setPhoneNo(jsonObject.getString("phone"));
                        } else {
                            log.info("非正常长度手机号：{},长度：{}", jsonObject.get("phone"), jsonObject.getString("phone").length());
                            if (jsonObject.getString("phone").length() > 11) {
                                tbUser.setPhoneNo(jsonObject.getString("phone")
                                        .substring(jsonObject.getString("phone").length() - 11));
                            } else {
                                tbUser.setPhoneNo(jsonObject.getString("phone"));
                            }

                        }
                    }

                    if (null != jsonObject.get("username")) {

                        tbUser.setUsername(jsonObject.get("username").toString());
                    } else {

                        RandomTool randomTool = new RandomTool();
                        String random = randomTool.getStringRandom(8);
                        tbUser.setUsername("username_" + random);
                    }

                    // 插入操作
//                    tbUserMapper.insertSelective(tbUser);
                } catch (Exception e) {

                    log.error("TestController.initData ==> insert data error!!!userId is {}", tbUser.getUserid(), e);

                    System.out.println("userId is {}" + tbUser.getUserid());
//                    return "init data error!!";
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                log.error("", e);
            }

            try {
                in.close();
            } catch (IOException e) {
                log.error("", e);
            }
        }

        return "init success";
    }

    private FileReader getResourceAsStream(String localUrl) throws IOException {
        URL url = this.getClass().getClassLoader().getResource(localUrl);
        log.info("TestController.getResourceAsStream() ----> File url : {}", url.getFile());

        return new FileReader(url.getFile());

    }



    public  static  void main(String [] ars){


        String verifyCode = String.valueOf(new Random().nextInt(8999) + 1000);//生成短信验证码

        System.out.println(verifyCode);
    }



}
