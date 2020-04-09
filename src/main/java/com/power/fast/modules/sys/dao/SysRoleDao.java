package com.power.fast.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.power.fast.modules.sys.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色(SysRole)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-09 14:32:41
 */
@Mapper
public interface SysRoleDao extends BaseMapper<SysRole> {

}