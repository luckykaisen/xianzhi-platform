package com.xianzhi.platform.webapp.controller.user.api;

import com.xianzhi.platform.webapp.common.rs.api.ServiceResponse;
import com.xianzhi.platform.webapp.model.User;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/5 18:19
 */
@Getter
@Setter
public class GetUserInfoResponse extends ServiceResponse {

    private User user;
}
