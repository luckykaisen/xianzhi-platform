package com.xianzhi.platform.webapp.model;

import com.xianzhi.platform.webapp.common.model.Bool;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/4 17:09
 */
@Data
public class Goods implements Serializable {

    private Integer id;
    private String name;
    private String address;
    private String coverImage;
    private Integer price;
    private String description;
    private String images;
    private Bool delete;
    private Integer viewCount;
    private Integer likeCount;
    private Date createTime;
    private Date updateTime;
    private Integer userId;
    private Integer categoryId;
    private Integer districtId;
    private Integer statusId;

    private District district;
    private User user;
    public GoodsCategory category;
    private GoodsStatus status;
}
