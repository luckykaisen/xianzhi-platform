package com.xianzhi.platform.webapp.Interceptor;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.xianzhi.platform.webapp.common.model.AccountCO;
import com.xianzhi.platform.webapp.common.session.HttpSessionContextUtility;
import com.xianzhi.platform.webapp.common.session.SessionContextAccessor;
import com.xianzhi.platform.webapp.common.session.SessionReplacedRequestHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/5 18:13
 */
@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        AccountCO currentAccount = SessionContextAccessor.getCurrentAccount();
        if (currentAccount == null || currentAccount.getId() == null) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = null;
            try {
                JSONObject res = new JSONObject();

                res.put("result_code", 90001);
                res.put("result_message", "用户未登录！");
                res.put("error_id", null);
                out = response.getWriter();
                out.append(res.toString());
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                response.sendError(500);
                return false;
            }
        }else {
            //放行
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}