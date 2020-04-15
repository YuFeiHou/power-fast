package com.power.fast.exception;

import com.power.fast.constant.HttpStatus;
import com.power.fast.util.AjaxResult;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author fei
 * @title: RRExceptionHandler
 * @projectName power-fast
 * @description: 自定义异常处理器
 * @date 2020/4/13 12:06
 */
@RestControllerAdvice
public class RRExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(RRException.class)
    public AjaxResult handleRRException(RRException e) {
        logger.error("【系统异常错误! code={} ,错误信息为：{}】", e.getCode(), e.getMsg());

        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.put("code", e.getCode());
        ajaxResult.put("msg", e.getMsg());

        return ajaxResult;
    }

    /**
     * 捕获并处理 账号锁定
     *
     * @param e
     * @return
     */
    @ExceptionHandler(LockedAccountException.class)
    public AjaxResult lockedAccountException(LockedAccountException e) {
        logger.error("【系统异常错误! 错误信息为：{}】", e.getMessage());
        return AjaxResult.error(e.getMessage(), HttpStatus.USERNAME_LOCK);
    }

    /**
     * 捕获并处理 token失效
     *
     * @param e
     * @return
     */
    @ExceptionHandler(IncorrectCredentialsException.class)
    public AjaxResult incorrectCredentialsException(IncorrectCredentialsException e) {
        logger.error("【系统异常错误! 错误信息为：{}】", e.getMessage());
        return AjaxResult.error(e.getMessage(), HttpStatus.FORBIDDEN);
    }

    /**
     * 同意捕获并处理授权信息
     *
     * @param e
     * @return
     */
    @ExceptionHandler(AuthorizationException.class)
    public AjaxResult handleAuthorizationException(AuthorizationException e) {
        logger.error("【系统异常错误! 错误信息为：{}】", e.getMessage());
        return AjaxResult.error("没有权限，请联系管理员授权", HttpStatus.UNAUTHORIZED);
    }
}
