package com.power.fast.modules.sys.controller;

import com.power.fast.modules.sys.entity.SysUser;
import com.power.fast.modules.sys.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

/**
 * 系统用户(SysUser)表控制层
 *
 * @author makejava
 * @since 2020-04-08 16:49:56
 */
@Api(description = "用户管理")
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 获取用户列表
     */
    @GetMapping("/list")
    @ApiOperation("获取用户列表")
    public Collection<SysUser> list(){
        return sysUserService.list();
    }

}