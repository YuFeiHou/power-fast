package com.power.fast.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.power.fast.modules.sys.dao.SysUserDao;
import com.power.fast.modules.sys.entity.SysUser;
import com.power.fast.modules.sys.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * 系统用户(SysUser)表服务实现类
 *
 * @author makejava
 * @since 2020-04-08 16:49:55
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService  {

}