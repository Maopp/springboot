package com.catpp.springboot.exception;

/**
 * com.catpp.springboot.exception
 *
 * @Author cat_pp
 * @Date 2018/8/30
 * @Description
 */
public class AuthorizationUnSufficientException extends RuntimeException {

    private static final long serialVersionUID = 8687790965329874302L;

    public AuthorizationUnSufficientException() {
        super();
    }

    public AuthorizationUnSufficientException(String message) {
        super(message);
    }

    public AuthorizationUnSufficientException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthorizationUnSufficientException(Throwable cause) {
        super(cause);
    }

    protected AuthorizationUnSufficientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
