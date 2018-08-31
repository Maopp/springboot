package com.catpp.springboot.interceptor;

import com.catpp.springboot.common.WebCommonUtil;
import com.catpp.springboot.pojo.JsonResult;
import com.catpp.springboot.utils.JsonUtil;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * com.catpp.springboot.interceptor
 *
 * @Author cat_pp
 * @Date 2018/8/31
 * @Description
 */
public class ErrorInterceptor implements HandlerInterceptor {

    private long maxUploadSize = 10485760;

    public ErrorInterceptor(long maxUploadSize) {
        this.maxUploadSize = maxUploadSize;
    }

    public ErrorInterceptor() {
    }

    public void setMaxUploadSize(long maxUploadSize) {
        this.maxUploadSize = maxUploadSize;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request != null && ServletFileUpload.isMultipartContent(request)) {
            ServletRequestContext ctx = new ServletRequestContext(request);
            long requestSize = ctx.contentLength();
            if (requestSize > maxUploadSize) {
                WebCommonUtil.returnMessage(response, JsonUtil.toJsonString(new JsonResult("文件过大(文件限制大小为10M)")));
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
