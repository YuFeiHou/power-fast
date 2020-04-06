package com.power.fast.modules.sys.controller;
import com.power.fast.modules.sys.entity.SysMenu;
import com.power.fast.modules.sys.service.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * 菜单管理(SysMenu)表控制层
 *
 * @author makejava
 * @since 2020-04-06 14:50:51
 */
@Api(description = "菜单列表")
@RestController
@RequestMapping("/menu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;

    /**0
     * 菜单列表(测swagger)
     */
    @GetMapping("/list")
    @ApiOperation("获取菜单列表,测swagger")
    public Collection<SysMenu> list(){
        return sysMenuService.list();
    }
}