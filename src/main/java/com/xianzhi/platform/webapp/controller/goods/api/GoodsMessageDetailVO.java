package com.xianzhi.platform.webapp.controller.goods.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

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

}
