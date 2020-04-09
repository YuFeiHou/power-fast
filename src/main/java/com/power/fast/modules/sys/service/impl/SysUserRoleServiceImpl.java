package com.power.fast.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.power.fast.modules.sys.entity.SysUserRole;
import com.power.fast.modules.sys.dao.SysUserRoleDao;
import com.power.fast.modules.sys.service.SysUserRoleService;
import org.springframework.stereotype.Service;
/**
 * 用户与角色对应关系(SysUserRole)表服务实现类
 *
 * @author makejava
 * @since 2020-04-09 14:44:46
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleDao,SysUserRole> implements SysUserRoleService {
}