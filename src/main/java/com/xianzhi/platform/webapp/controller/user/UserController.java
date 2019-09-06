package com.xianzhi.platform.webapp.controller.user;

import com.xianzhi.platform.webapp.common.model.AccountCO;
import com.xianzhi.platform.webapp.common.rs.api.ServiceResponse;
import com.xianzhi.platform.webapp.common.session.SessionContextAccessor;
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

    @RequestMapping(value = "/mock/login")
    public ServiceResponse getUserInfo() {

        AccountCO account = new AccountCO();
        account.setId(1);
        account.setMobile("18210003887");

        SessionContextAccessor.setCurrentAccount(account);

        return new ServiceResponse();
    }

}
