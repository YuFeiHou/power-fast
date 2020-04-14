package com.power.fast.modules.sys.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.power.fast.modules.sys.entity.SysMenu;

import java.util.List;

/**
 * 菜单管理(SysMenu)表服务接口
 *
 * @author makejava
 * @since 2020-04-06 14:50:50
 */

public interface SysMenuService extends IService<SysMenu> {
    /**
     * 根据父菜单，查询子菜单
     * @param parentId 父菜单ID
     * @param menuIdList  用户菜单ID
     */
    List<SysMenu> queryListParentId(String parentId, List<String> menuIdList);

    /**
     * 根据父菜单，查询子菜单
     * @param parentId 父菜单ID
     */
    List<SysMenu> queryListParentId(String parentId);

    /**
     * 获取用户菜单列表
     * @param userId
     * @return
     */
    List<SysMenu> getUserMenuList(String userId);
}