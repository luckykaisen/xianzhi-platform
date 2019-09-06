package com.xianzhi.platform.webapp.controller.goods.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.xianzhi.platform.webapp.common.utility.DateTimeUtility;
import com.xianzhi.platform.webapp.model.User;
import lombok.Data;

import java.util.Date;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/5 17:51
 */
@Data
public class GoodsUserDetailVO {

    private Integer id;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    private String mobile;

    @JsonProperty("last_login_time")
    private String lastLoginTime;

    public static GoodsUserDetailVO fromUser(User user) {

        GoodsUserDetailVO userDetail = new GoodsUserDetailVO();
        userDetail.setId(user.getId());
        userDetail.setAvatarUrl(user.getAvatarUrl());
        userDetail.setMobile(user.getMobile());
        Date lastLoginTime = user.getLastLoginTime();
        int minute = DateTimeUtility.minuteBetween(lastLoginTime, new Date());

        String time = "";
        if (minute <= 60) {
            if (minute < 3) {
                time = "刚刚来过";
            } else {
                time = minute + "分钟前来过";
            }
        } else if (minute < 1440) {

            time = minute/60 + "小时前来过";

        } else if (minute < 525600) {

            time = minute / 1440 + "天前来过";

        } else {

            time = minute / 525600 + "年前来过";

        }
        userDetail.setLastLoginTime(time);

        return userDetail;
    }
}
