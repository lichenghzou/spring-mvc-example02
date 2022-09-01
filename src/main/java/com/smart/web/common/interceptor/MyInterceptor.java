package com.smart.web.common.interceptor;

import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 写一个类实现HandlerInterceptor
 * 重写方法 preHandle postHandle afterCompletion
 * 在xml中注册
 */
public class MyInterceptor implements HandlerInterceptor {
    /**
     * 预处理回调方法
     *
     * @param request  请求对象
     * @param response 响应
     * @param handler  拦截的核心方法  HandlerMethod  通过HandlerMethod 得到Method对象 可以获取 Method的注解信息
     * @return 如果返回false   不执行控制层的方法   true 表示放行
     * @throws Exception 登录成功  返回 1
     *                   修改密码的方法
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("1 执行拦截");
        String isLogin = request.getHeader("isLogin");
        if (!StringUtils.isEmpty(isLogin)) {
            return true;
        } else {
            response.getWriter().println("未登录");
            return false;
        }
    }

    /**
     * 前后端不分离
     * 渲染完成之回调方法
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("3 核心代码执行完成");
    }
}
