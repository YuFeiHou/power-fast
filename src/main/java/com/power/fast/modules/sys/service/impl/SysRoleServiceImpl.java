package com.power.fast.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.power.fast.modules.sys.entity.SysRole;
import com.power.fast.modules.sys.dao.SysRoleDao;
import com.power.fast.modules.sys.service.SysRoleService;
import org.springframework.stereotype.Service;

/**
 * 角色(SysRole)表服务实现类
 *
 * @author makejava
 * @since 2020-04-09 14:32:42
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao,SysRole> implements SysRoleService {

}