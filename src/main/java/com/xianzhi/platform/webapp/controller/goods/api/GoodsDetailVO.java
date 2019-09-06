package com.xianzhi.platform.webapp.controller.goods.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xianzhi.platform.webapp.model.Goods;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/4 17:43
 */
@Data
public class GoodsDetailVO {

    private Integer id;

    private Integer price;

    private String address;

    private List<String> images;

    private String description;

    @JsonProperty("view_count")
    private Integer viewCount;

    private GoodsUserDetailVO user;

    private List<GoodsMessageDetailVO> messages;
}
