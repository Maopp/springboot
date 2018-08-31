package com.catpp.springboot.common;

import com.alibaba.fastjson.JSONObject;
import com.catpp.springboot.utils.JsonUtil;
import com.catpp.springboot.utils.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * com.catpp.springboot.common
 *
 * @Author cat_pp
 * @Date 2018/8/31
 * @Description
 */
@Slf4j
public class WebCommonUtil {

    public WebCommonUtil() {
    }

    public static void returnMessage(HttpServletResponse response, String content) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter writer = null;

        try {
            writer = response.getWriter();
            writer.write(content);
        } catch (IOException e) {
            LogUtil.error(log, "系统错误", e);
        } finally {
            if (null != writer) {
                writer.flush();
                writer.close();
            }
        }
    }

    public static void returnMessageForJSON(HttpServletResponse response, JSONObject data) {
        returnMessage(response, data.toString());
    }

    public static void returnMessageFroMapData(HttpServletResponse response, Map dataMap) {
        returnMessage(response, JsonUtil.toJsonString(dataMap).toString());
    }

    public static boolean isAjaxRequest(HttpServletRequest request) {
        String requestedWith = request.getHeader("x-requested-with");
        if (StringUtils.isEmpty(requestedWith)) {
            return false;
        } else {
            return StringUtils.isNotEmpty(requestedWith) && requestedWith.equals("XMLHttpRequest");
        }
    }

    public static String getRemoteIp(HttpServletRequest request) {
        String remoteIp = request.getHeader("x-forwarded-for");
        if (null == remoteIp || remoteIp.isEmpty() || "unknow".equalsIgnoreCase(remoteIp)) {
            remoteIp = request.getHeader("X-Real-IP");
        }

        if (null == remoteIp || remoteIp.isEmpty() || "unknow".equalsIgnoreCase(remoteIp)) {
            remoteIp = request.getHeader("Proxy-Client-IP");
        }

        if (null == remoteIp || remoteIp.isEmpty() || "unknow".equalsIgnoreCase(remoteIp)) {
            remoteIp = request.getHeader("WL-Proxy-Client-IP");
        }

        if (null == remoteIp || remoteIp.isEmpty() || "unknow".equalsIgnoreCase(remoteIp)) {
            remoteIp = request.getHeader("HTTP_CLIENT_IP");
        }

        if (null == remoteIp || remoteIp.isEmpty() || "unknow".equalsIgnoreCase(remoteIp)) {
            remoteIp = request.getHeader("HTTP_X_FORWARDED_FOR");
        }

        if (null == remoteIp || remoteIp.isEmpty() || "unknow".equalsIgnoreCase(remoteIp)) {
            remoteIp = request.getRemoteAddr();
        }

        if (null == remoteIp || remoteIp.isEmpty() || "unknow".equalsIgnoreCase(remoteIp)) {
            remoteIp = request.getRemoteHost();
        }

        if (null != remoteIp && remoteIp.indexOf(",") != -1) {
            remoteIp = remoteIp.substring(remoteIp.lastIndexOf(",") + 1, remoteIp.length()).trim();
        }

        return remoteIp;
    }
}
