package org.example.demo_spring_book.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.example.demo_spring_book.constants.Constant;
import org.example.demo_spring_book.model.Result;
import org.example.demo_spring_book.model.UserInfo;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    // true 表示放行；false 表示拦截
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle: 目标方法执行前");
        HttpSession session = request.getSession(false);
        if (!checkUser(session)) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(401);
            String msg = "用户未登录";
            response.getOutputStream().write(msg.getBytes("UTF-8"));
            return false;
        }
        return true;
    }
    private Boolean checkUser(HttpSession session) {
        // 检验用户是否已登陆
        if (session == null || session.getAttribute(Constant.SESSION_USER_KEY) == null) {
            log.warn("用户未登录");
            return false;
        }
        UserInfo userInfo = (UserInfo) session.getAttribute(Constant.SESSION_USER_KEY);
        if (userInfo == null || userInfo.getId() <= 0) {
            log.warn("用户未登录");
            return false;
        }
        log.info("用户已登录");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        log.info("postHandle: 目标方法执行后");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        log.info("afterCompletion: 视图渲染完成后");
    }
}
