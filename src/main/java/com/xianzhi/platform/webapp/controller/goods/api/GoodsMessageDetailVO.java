package com.xianzhi.platform.webapp.controller.goods.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xianzhi.platform.webapp.model.GoodsComment;
import com.xianzhi.platform.webapp.model.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/5 17:53
 */
@Data
public class GoodsMessageDetailVO {

    @JsonProperty("from_user_id")
    private Integer fromUserId;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    private String name;

    private String content;

    public static List<GoodsMessageDetailVO> fromMessages(List<GoodsComment> comments) {

        List<GoodsMessageDetailVO> vos = new ArrayList<>();
        for (GoodsComment comment : comments) {
            vos.add(fromMessage(comment));
        }

        return vos;
    }

    public static GoodsMessageDetailVO fromMessage(GoodsComment comment) {

        User fromUser = comment.getFromUser();
        User toUser = comment.getToUser();

        GoodsMessageDetailVO vo = new GoodsMessageDetailVO();
        vo.setFromUserId(comment.getFromUserId());
        vo.setAvatarUrl(fromUser.getAvatarUrl());
        vo.setContent(comment.getContent());

        if (toUser != null) {
            vo.setName(fromUser.getName() + "@" + toUser.getName());
        } else {
            vo.setName(fromUser.getName());
        }

        return vo;
    }
}
