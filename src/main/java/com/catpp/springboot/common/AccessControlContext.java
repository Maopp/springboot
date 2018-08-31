package com.catpp.springboot.common;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

/**
 * com.catpp.springboot.common
 *
 * @Author cat_pp
 * @Date 2018/8/31
 * @Description 当前请求对应用户的上下文信息
 */
@Slf4j
public class AccessControlContext {

    private static final ThreadLocal<HashMap<String, Object>> cache = new ThreadLocal<>();
    // 业务系统session Cookie缓存
    private static final ThreadLocal<String> SESSION_COOKIE_CACHE = new ThreadLocal<>();
    // cas-st 缓存
    private static final ThreadLocal<String> ST_CACHE = new ThreadLocal<>();
    private static final ThreadLocal<Boolean> IS_URL_FREE_OF_AUTHENTICATION = new ThreadLocal<>();
    private static final ThreadLocal<String> LOGIN_NAME_CACHE = new ThreadLocal<>();

    public AccessControlContext() {
    }

    public static void init() {
        clear();
        cache.set(new HashMap<>());
    }

    public static void clear() {
        cache.remove();
    }

    public static String getSessionCookie() {
        return SESSION_COOKIE_CACHE.get();
    }

    public static void setSessionCookie(String sessionCookie) {
        SESSION_COOKIE_CACHE.set(sessionCookie);
    }

    public static void clearSeessionCookie() {
        SESSION_COOKIE_CACHE.remove();
    }

    public static String getST() {
        return ST_CACHE.get();
    }

    public static void setST(String st) {
        ST_CACHE.set(st);
    }

    public static void clearST() {
        ST_CACHE.remove();
    }

    /**
     * 获取当前登陆账号的账号信息
     */
    public static AccountDto getLoginAccount() {
        return (AccountDto) cache.get().get("login_accountDto");
    }

    public static void setLoginAccount(AccountDto account) {
        cache.get().put("login_accountDto", account);
    }

    /**
     * 获取当前登陆用户的id
     */
    public static Long getLoginAccountId() {
        return getLoginAccount().getId();
    }

    /**
     * 当前请求是否能够找到登陆信息
     */
    public static boolean isLogined() {
        return null != cache.get();
    }

    /**
     * 判断当前url路径需要登陆
     */
    public static boolean mustRequestBeAuthenticated() {
        return !Boolean.TRUE.equals(IS_URL_FREE_OF_AUTHENTICATION.get());
    }

    /**
     * 标记当前请求不需要身份认证
     */
    public static void markUrlFreeOfAuthentication() {
        IS_URL_FREE_OF_AUTHENTICATION.set(true);
    }

    /**
     * 清理标记-当前请求不需要身份认证
     */
    public static void clearUrlFreeOfAuthentication() {
        IS_URL_FREE_OF_AUTHENTICATION.remove();
    }

    /**
     * 获取登陆账号的登陆名
     */
    public static String getLoginAccountName() {
        return LOGIN_NAME_CACHE.get();
    }

    /**
     * 设置当前登陆用户名
     */
    public static void setLoginAccountName(String accountName){
        LOGIN_NAME_CACHE.set(accountName);
    }

    /**
     * 清除登录名缓存
     */
    public static void clearLoginAccountName() {
        LOGIN_NAME_CACHE.remove();
    }
}
