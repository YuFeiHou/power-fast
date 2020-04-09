package com.power.fast.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.power.fast.modules.sys.entity.SysUser;

/**
 * 系统用户(SysUser)表服务接口
 *
 * @author makejava
 * @since 2020-04-08 16:49:55
 */
public interface SysUserService extends IService<SysUser> {

    /**
     * 根据用户名，查询系统用户信息
     */
    SysUser queryByUserName(String username);
}