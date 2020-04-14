package com.power.fast.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.power.fast.modules.sys.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 菜单管理(SysMenu)
 *
 * @author makejava
 * @since 2020-04-06 14:50:48
 */
@Mapper
public interface SysMenuDao extends BaseMapper<SysMenu> {

    /**
     * 查询用户的所有菜单ID
     */
    List<String> queryAllMenuId(String userId);
}
