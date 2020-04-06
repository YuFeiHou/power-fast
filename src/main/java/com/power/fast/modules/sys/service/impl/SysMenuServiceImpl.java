package com.power.fast.modules.sys.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.power.fast.modules.sys.dao.SysMenuDao;
import com.power.fast.modules.sys.entity.SysMenu;
import com.power.fast.modules.sys.service.SysMenuService;
import org.springframework.stereotype.Service;

/**
 * 菜单管理(SysMenu)表服务实现类
 *
 * @author makejava
 * @since 2020-04-06 14:50:51
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenu> implements SysMenuService {

}