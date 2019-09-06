package com.xianzhi.platform.webapp.Interceptor;

import com.xianzhi.platform.webapp.common.session.SessionReplacedRequestHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: WeiKaiSen
 * @date: 2019/9/6 11:09
 */
@Component
public class SessionHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        SessionReplacedRequestHolder.initialize(request);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        SessionReplacedRequestHolder.clear();
    }
}
