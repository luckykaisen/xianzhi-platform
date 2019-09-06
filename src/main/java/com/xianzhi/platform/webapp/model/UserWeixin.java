package com.xianzhi.platform.webapp.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/4 17:23
 */
@Data
public class UserWeixin implements Serializable {

    private Integer id;
    private String nickName;
    private String avatarUrl;
    private String openId;
    private String sessionKey;
    private String token;
    private Date createTime;
    private Date updateTime;
    private Date lastLoginTime;
    private Integer userId;

    private User user;
}
