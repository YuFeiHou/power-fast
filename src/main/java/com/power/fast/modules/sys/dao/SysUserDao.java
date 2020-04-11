package com.power.fast.modules.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.power.fast.modules.sys.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 系统用户(SysUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-08 16:49:54
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUser> {

    /**
     * 根据用户id获取用户权限列表
     *
     * @param userId 用户id
     * @return
     */
    List<String> queryAllPerms(String userId);
}