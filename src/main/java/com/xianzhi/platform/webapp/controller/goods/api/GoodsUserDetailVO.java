package com.xianzhi.platform.webapp.controller.goods.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/5 17:51
 */
@Data
public class GoodsUserDetailVO {

    private Integer id;

    private String mobile;

    @JsonProperty("last_login_time")
    private String lastLoginTime;

}
