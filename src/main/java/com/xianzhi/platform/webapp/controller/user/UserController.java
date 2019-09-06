package com.xianzhi.platform.webapp.controller.user;

import com.xianzhi.platform.webapp.common.rs.api.ServiceResponse;
import com.xianzhi.platform.webapp.controller.user.api.GetUserInfoResponse;
import com.xianzhi.platform.webapp.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/5 18:18
 */
@RestController
@RequestMapping("/services/rs/user")
public class UserController {

    @RequestMapping(value = "/info")
    public ServiceResponse getUserInfo() {

        User user = new User();
        user.setId(1);
        user.setName("张三");

        GetUserInfoResponse response = new GetUserInfoResponse();
        response.setUser(user);
        return response;
    }

}
