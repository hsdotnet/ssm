package com.hs.interceptor;

import com.hs.constants.GlobalConstants;
import com.hs.util.CookieUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Resource
    private JedisPool jedisPool;

    private List<String> excludedUrls;

    public void setExcludedUrls(List<String> excludedUrls) {
        this.excludedUrls = excludedUrls;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getServletPath();

        System.out.println(url);
        for (String s : excludedUrls) {
            if (url.endsWith(s)) return true;
        }

        boolean isAjax = false;
        String xReq = request.getHeader("x-requested-with");
        if (!StringUtils.isNotEmpty(xReq) && "XMLHttpRequest".equals(xReq)) {
            isAjax = true;
        }

        String token = CookieUtil.getValue(request, GlobalConstants.LOGIN_USER_COOKIE_KEY);
        if (StringUtils.isEmpty(token)) {
            if (isAjax) {

            } else {
                response.sendRedirect(request.getContextPath() + "/login");
            }
            return false;
        }

        String json = jedisPool.getResource().get(GlobalConstants.LOGIN_USER_REDIS_PRE + token);
        if (StringUtils.isEmpty(json)) {
            if (isAjax) {

            } else {
                response.sendRedirect(request.getContextPath() + "/login");
            }
            return false;
        }

        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
