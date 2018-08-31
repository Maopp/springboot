package com.catpp.springboot.interceptor;

import com.alibaba.fastjson.JSON;
import com.catpp.springboot.common.AccessControlContext;
import com.catpp.springboot.common.IdAndNameDto;
import com.catpp.springboot.service.CacheClient;
import com.catpp.springboot.utils.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * com.catpp.springboot.interceptor
 *
 * @Author cat_pp
 * @Date 2018/8/30
 * @Description 登陆拦截
 */
@Slf4j
public class AccessInterceptor extends HandlerInterceptorAdapter {

    private static final String CUR_ROLE_KEY = "curRole";

    @Autowired
    private CacheClient defaultCache;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LogUtil.info(log, "request url is {}", request.getRequestURI());

        // 获取当前登陆人工号和角色
        String staffNo = AccessControlContext.getLoginAccount().getStaffNo();
        Object obj = defaultCache.get(CUR_ROLE_KEY + staffNo);
        Long roleId = null;
        if (null != obj) {
            IdAndNameDto curRole = JSON.parseObject(obj.toString()).toJavaObject(IdAndNameDto.class);
            roleId = curRole.getId();
        }

        // 获取当前登陆人权限
//        Map<Integer, Long>
//        return super.preHandle(request, response, handler);
        return true;
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
