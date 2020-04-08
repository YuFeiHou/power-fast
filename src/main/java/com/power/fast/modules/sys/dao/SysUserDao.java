package com.power.fast.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.power.fast.modules.sys.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
/**
 * 系统用户(SysUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-08 16:49:54
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUser> {

}