package com.power.fast.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.power.fast.constant.UserConstant;
import com.power.fast.modules.sys.dao.SysMenuDao;
import com.power.fast.modules.sys.entity.SysMenu;
import com.power.fast.modules.sys.enums.MenuTypeEnum;
import com.power.fast.modules.sys.service.SysMenuService;
import com.power.fast.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单管理(SysMenu)表服务实现类
 *
 * @author makejava
 * @since 2020-04-06 14:50:51
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenu> implements SysMenuService {

    @Autowired
    private SysMenuDao sysMenuDao;
    @Autowired
    private SysUserService sysUserService;

    /**
     * 根据父菜单，查询子菜单
     *
     * @param parentId   父菜单ID
     * @param menuIdList 用户菜单ID
     */
    @Override
    public List<SysMenu> queryListParentId(String parentId, List<String> menuIdList) {
        List<SysMenu> menuList = queryListParentId(parentId);
        if (menuIdList == null) {
            return menuList;
        }

        List<SysMenu> userMenuList = new ArrayList<>();
        for (SysMenu menu : menuList) {
            if (menuIdList.contains(menu.getMenuId())) {
                userMenuList.add(menu);
            }
        }
        return userMenuList;
    }

    /**
     * 根据父菜单，查询子菜单
     *
     * @param parentId 父菜单ID
     */
    @Override
    public List<SysMenu> queryListParentId(String parentId) {
        return sysMenuDao.selectList(new QueryWrapper<SysMenu>().eq("parent_id", parentId));
    }

    /**
     * 获取用户菜单列表
     *
     * @param userId
     * @return
     */
    @Override
    public List<SysMenu> getUserMenuList(String userId) {
        //系统管理员，拥有最高权限
        if (userId.equals(UserConstant.SUPER_ADMIN)) {
            return getAllMenuList(null);
        }

        //用户菜单列表
        List<String> menuIdList = sysUserService.queryAllMenuId(userId);
        return getAllMenuList(menuIdList);
    }

    /**
     * 获取所有菜单列表
     *
     * @param menuIdList
     * @return
     */
    private List<SysMenu> getAllMenuList(List<String> menuIdList) {
        //查询根菜单列表
        List<SysMenu> menuList = queryListParentId("0", menuIdList);
        //获取子菜单
        getMenuTreeList(menuList, menuIdList);

        return menuList;
    }

    /**
     * 递归
     */
    private List<SysMenu> getMenuTreeList(List<SysMenu> menuList, List<String> menuIdList) {
        List<SysMenu> subMenuList = new ArrayList<SysMenu>();

        for (SysMenu entity : menuList) {
            //目录
            if (entity.getType() == MenuTypeEnum.CATALOG.getValue()) {
                entity.setList(getMenuTreeList(queryListParentId(entity.getMenuId(), menuIdList), menuIdList));
            }
            subMenuList.add(entity);
        }
        return subMenuList;
    }
}