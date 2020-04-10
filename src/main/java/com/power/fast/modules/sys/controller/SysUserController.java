package com.power.fast.modules.sys.controller;
import com.power.fast.util.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
/**
 * 系统用户(SysUser)表控制层
 *
 * @author makejava
 * @since 2020-04-08 16:49:56
 */
@Api(description = "用户管理")
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends BaseController {
    Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * 获取用户列表
     */
    @GetMapping("/info")
    @ApiOperation("当前管理员信息")
    public AjaxResult info() {
        logger.info("【当前管理员信息为：{}】",getUser());
        return AjaxResult.success(getUser());
    }

}