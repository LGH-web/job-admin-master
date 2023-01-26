package com.gsupl.framework.mvc;

import com.gsupl.framework.exception.TokenException;
import com.gsupl.framework.redis.RedisUtil;
import com.gsupl.utils.Status;
import com.gsupl.utils.UserThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author LGH
 * @Date 2022/11/14 15:01
 * @Version 1.0
 */
public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        boolean flag = redisUtil.hasKey(token);
        if (flag) {
            UserThreadLocal.set(token);
            redisUtil.expire(token, RedisUtil.EXPR);
        } else {
            throw new TokenException(Status.TOKEN_ERROR.getMsg());
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //清除ThreadLocal
        UserThreadLocal.remove();
    }
}
