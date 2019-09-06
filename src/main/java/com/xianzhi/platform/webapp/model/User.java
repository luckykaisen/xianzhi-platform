package com.xianzhi.platform.webapp.model;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/4 16:50
 */
@Data
public class User implements Serializable {

    private Integer id;

    private String name;

    private String avatarUrl;

    private Gender gender;

    private String mobile;

    private Date createTime;

    private Date lastLoginTime;

}
