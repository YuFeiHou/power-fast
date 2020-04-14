package com.power.fast.exception;
import com.power.fast.util.AjaxResult;
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
    public AjaxResult handleRRException(RRException e){
        return AjaxResult.error();
    }
}
