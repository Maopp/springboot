package com.catpp.springboot.exception;

import com.catpp.springboot.pojo.JsonResult;
import com.catpp.springboot.utils.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * com.catpp.springboot.exception
 *
 * @Author cat_pp
 * @Date 2018/8/30
 * @Description web全局异常捕获
 */
@RestControllerAdvice
@Slf4j
public class ControllerAdvice {

    /**
     * 业务异常
     * @param e 业务异常
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handleParamValidate(BusinessException e) {
        LogUtil.error(log, "业务异常", e);
        return new JsonResult(e.getMessage());
    }

    /**
     * 参数错误
     * @param e 参数验证错误
     * @return
     */
    @ExceptionHandler(value = {IllegalArgumentException.class, HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public JsonResult handleParamValidate(Exception e) {
        LogUtil.error(log, "参数验证错误", e.getMessage());
        return new JsonResult(e.getMessage());
    }

    /**
     * 数据权限不足
     * @param exception 数据权限验证失败
     * @return
     */
    @ExceptionHandler(AuthorizationUnSufficientException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public JsonResult handleAuthorizationUnSufficient(AuthorizationUnSufficientException exception) {
        LogUtil.error(log, "数据权限不足", exception.getMessage());
        return new JsonResult(exception.getMessage());
    }

    /**
     * 其他所有异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public JsonResult handleOthers(Exception e) {
        LogUtil.error(log, "服务器错误", e);
        return new JsonResult("服务器错误");
    }
}
