package com.power.fast.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.power.fast.modules.sys.entity.SysRoleMenu;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色与菜单对应关系(SysRoleMenu)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-09 14:38:31
 */
@Mapper
public interface SysRoleMenuDao extends BaseMapper<SysRoleMenu> {

}