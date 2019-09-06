package com.xianzhi.platform.webapp.controller.goods.api;

import com.alibaba.fastjson.JSONArray;
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
public class GoodsVO {

    private Integer id;

    @JsonProperty("cover_image")
    private String coverImage;

    private String name;

    private String address;

    private Integer price;

    @JsonProperty("like_count")
    private Integer likeCount;

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("user_name")
    private String userName;

    public static List<GoodsVO> toVOs(List<Goods> result) {

        List<GoodsVO> goodses = new ArrayList<>();
        for (Goods goods : result) {
            goodses.add(toVO(goods));
        }

        return goodses;
    }

    public static GoodsVO toVO(Goods goods) {

        if (goods == null) {
            return null;
        }

        GoodsVO vo = new GoodsVO();
        vo.setId(goods.getId());
        vo.setCoverImage(goods.getCoverImage());
        vo.setName(goods.getName());
        vo.setAddress(goods.getAddress());
        vo.setPrice(goods.getPrice());
        vo.setLikeCount(goods.getLikeCount());
        vo.setUserId(goods.getUserId());
        vo.setUserName(goods.getUser().getName());

        return vo;
    }
}
