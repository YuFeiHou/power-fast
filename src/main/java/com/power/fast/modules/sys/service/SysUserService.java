package com.power.fast.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.power.fast.modules.sys.entity.SysUser;

import java.util.Set;

/**
 * 系统用户(SysUser)表服务接口
 *
 * @author makejava
 * @since 2020-04-08 16:49:55
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 获取用户权限列表
     * @param userId 用户id
     * @return
     */
    Set<String> getUserPermissions(String userId);

    /**
     * 根据用户名，查询系统用户信息
     * @param username 用户名称
     * @return
     */
    SysUser queryByUserName(String username);
}