package com.power.fast.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.power.fast.modules.sys.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
/**
 * 用户与角色对应关系(SysUserRole)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-09 14:44:46
 */
@Mapper
public interface SysUserRoleDao extends BaseMapper<SysUserRole> {

}