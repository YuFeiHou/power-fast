package com.power.fast.modules.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.power.fast.modules.sys.entity.SysRoleMenu;
import com.power.fast.modules.sys.dao.SysRoleMenuDao;
import com.power.fast.modules.sys.service.SysRoleMenuService;
import org.springframework.stereotype.Service;

/**
 * 角色与菜单对应关系(SysRoleMenu)表服务实现类
 *
 * @author makejava
 * @since 2020-04-09 14:38:31
 */
@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuDao,SysRoleMenu> implements SysRoleMenuService {

}