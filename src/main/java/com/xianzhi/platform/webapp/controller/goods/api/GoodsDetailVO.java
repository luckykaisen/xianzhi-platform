package com.xianzhi.platform.webapp.controller.goods.api;

import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.xianzhi.platform.webapp.model.Goods;
import com.xianzhi.platform.webapp.model.GoodsComment;
import com.xianzhi.platform.webapp.service.goods.api.GoodsDetailResult;
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

    @JsonProperty("cover_image")
    private String coverImage;

    private List<String> images;

    private String description;

    @JsonProperty("view_count")
    private Integer viewCount;

    private GoodsUserDetailVO user;

    private List<GoodsMessageDetailVO> messages;

    public static GoodsDetailVO fromDetail(GoodsDetailResult result) {

        Goods goods = result.getGoods();

        GoodsDetailVO detail = new GoodsDetailVO();
        detail.setId(goods.getId());
        detail.setPrice(goods.getPrice());
        detail.setCoverImage(goods.getCoverImage());
        detail.setAddress(goods.getAddress());
        detail.setImages(JSONArray.parseArray(goods.getImages(), String.class));
        detail.setDescription(goods.getDescription());
        detail.setViewCount(goods.getViewCount());
        detail.setUser(GoodsUserDetailVO.fromUser(goods.getUser()));
        detail.setMessages(GoodsMessageDetailVO.fromMessages(result.getComments()));

        return detail;
    }
}
