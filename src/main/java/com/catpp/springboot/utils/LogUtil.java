package com.catpp.springboot.utils;

import org.slf4j.Logger;

import java.awt.geom.Area;

/**
 * com.catpp.springboot.utils
 *
 * @Author cat_pp
 * @Date 2018/8/27
 * @Description 日志工具类
 */
public class LogUtil {
    public static void trace(Logger logger, String msg) {
        if (logger.isTraceEnabled()) {
            logger.trace(msg);
        }
    }

    public static void trace(Logger logger, String format, Object arg) {
        if (logger.isTraceEnabled()) {
            logger.trace(format, arg);
        }
    }

    public static void trace(Logger logger, String format, Object arg1, Object arg2) {
        if (logger.isTraceEnabled()) {
            logger.trace(format, arg1, arg2);
        }
    }

    public static void trace(Logger logger, String format, Object... arguments) {
        if (logger.isTraceEnabled()) {
            logger.trace(format, arguments);
        }
    }

    public static void debug(Logger logger, String msg) {
        if (logger.isDebugEnabled()) {
            logger.debug(msg);
        }
    }

    public static void debug(Logger logger, String format, Object arg) {
        if (logger.isDebugEnabled()) {
            logger.debug(format, arg);
        }
    }

    public static void debug(Logger logger, String format, Object arg1, Object arg2) {
        if (logger.isDebugEnabled()) {
            logger.debug(format, arg1, arg2);
        }
    }

    public static void debug(Logger logger, String format, Object... argumemnts) {
        if (logger.isDebugEnabled()) {
            logger.debug(format, argumemnts);
        }
    }

    public static void debug(Logger logger, String msg, Throwable throwable) {
        if (logger.isDebugEnabled()) {
            logger.debug(msg, throwable);
        }
    }

    public static void info(Logger logger, String msg) {
        if (logger.isInfoEnabled()) {
            logger.info(msg);
        }
    }

    public static void info(Logger logger, String format, Object arg) {
        if (logger.isInfoEnabled()) {
            logger.info(format, arg);
        }
    }

    public static void info(Logger logger, String format, Object arg1, Object arg2) {
        if (logger.isInfoEnabled()) {
            logger.info(format, arg1, arg2);
        }
    }

    public static void info(Logger logger, String format, Object... arguments) {
        if (logger.isInfoEnabled()) {
            logger.info(format, arguments);
        }
    }

    public static void info(Logger logger, String msg, Throwable throwable) {
        if (logger.isInfoEnabled()) {
            logger.info(msg, throwable);
        }
    }

    public static void warn(Logger logger, String msg) {
        if (logger.isWarnEnabled()) {
            logger.warn(msg);
        }
    }

    public static void warn(Logger logger, String format, Object arg) {
        if (logger.isWarnEnabled()) {
            logger.warn(format, arg);
        }
    }

    public static void warn(Logger logger, String format, Object arg1, Object arg2) {
        if (logger.isWarnEnabled()) {
            logger.warn(format, arg1, arg2);
        }
    }

    public static void warn(Logger logger, String format, Object... arguments) {
        if (logger.isWarnEnabled()) {
            logger.warn(format, arguments);
        }
    }

    public static void warn(Logger logger, String msg, Throwable throwable) {
        if (logger.isWarnEnabled()) {
            logger.warn(msg, throwable);
        }
    }

    public static void error(Logger logger, String msg) {
        if (logger.isErrorEnabled()) {
            logger.error(msg);
        }
    }

    public static void error(Logger logger, String format, Object arg) {
        if (logger.isErrorEnabled()) {
            logger.error(format, arg);
        }
    }

    public static void error(Logger logger, String format, Object arg1, Object arg2) {
        if (logger.isErrorEnabled()) {
            logger.error(format, arg1, arg2);
        }
    }

    public static void error(Logger logger, String format, Object... arguments) {
        if (logger.isErrorEnabled()) {
            logger.error(format, arguments);
        }
    }

    public static void error(Logger logger, String msg, Throwable throwable) {
        if (logger.isErrorEnabled()) {
            logger.error(msg, throwable);
        }
    }
}
