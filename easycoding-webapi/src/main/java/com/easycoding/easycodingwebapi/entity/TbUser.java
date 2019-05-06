package com.easycoding.easycodingwebapi.entity;

import lombok.Data;

import java.util.Date;

@Data
public class TbUser {

    protected Integer id;

    protected String userid;

    protected String username;

    protected String password;

    protected String extraInfo;

    protected String creator;

    protected Date gmtCreated;

    protected String modifier;

    protected Date gmtModified;

    protected String isDeleted;

    protected String email;

    protected String phoneNo;

    protected String salt;

    protected String systemId;
}