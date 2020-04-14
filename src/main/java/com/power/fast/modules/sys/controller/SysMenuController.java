package com.power.fast.modules.sys.controller;
import com.power.fast.modules.sys.entity.SysMenu;
import com.power.fast.modules.sys.service.SysMenuService;
import com.power.fast.util.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
public class SysMenuController extends BaseController {

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 导航菜单
     *
     * @return
     */
    @ApiOperation("导航菜单")
    @GetMapping("/nav")
    @ResponseBody
    public AjaxResult nav() {
        AjaxResult ajaxResult = new AjaxResult();
        List<SysMenu> menuList = sysMenuService.getUserMenuList(getUserId());
        return ajaxResult.put("menuList",menuList);
    }

    /**
     * 菜单列表
     */
    @ApiOperation("获取菜单列表")
    @GetMapping("/list")
    @RequiresPermissions("sys:menu:list")
    @ResponseBody
    public AjaxResult list() {
        List<SysMenu> menuList = sysMenuService.list();
        for (SysMenu sysMenuEntity : menuList) {
            SysMenu parentMenuEntity = sysMenuService.getById(sysMenuEntity.getParentId());
            if (parentMenuEntity != null) {
                sysMenuEntity.setParentName(parentMenuEntity.getName());
            }
        }
        return AjaxResult.success(menuList);
    }
}