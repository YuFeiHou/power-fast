package com.power.fast.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.power.fast.modules.sys.dao.SysUserDao;
import com.power.fast.modules.sys.entity.SysUser;
import com.power.fast.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统用户(SysUser)表服务实现类
 *
 * @author makejava
 * @since 2020-04-08 16:49:55
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    /**
     * 根据用户名，查询系统用户信息
     *
     * @param username
     */
    @Override
    public SysUser queryByUserName(String username) {
        return sysUserDao.selectOne(new QueryWrapper<SysUser>().eq("user_name", username));
    }
}