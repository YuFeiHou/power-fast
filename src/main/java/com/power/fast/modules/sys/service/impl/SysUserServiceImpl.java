package com.power.fast.modules.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.power.fast.constant.UserConstant;
import com.power.fast.modules.sys.dao.SysMenuDao;
import com.power.fast.modules.sys.dao.SysUserDao;
import com.power.fast.modules.sys.entity.SysMenu;
import com.power.fast.modules.sys.entity.SysUser;
import com.power.fast.modules.sys.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    @Autowired
    private SysMenuDao sysMenuDao;

    /**
     * 获取用户权限列表
     *
     * @param userId 用户id
     * @return
     */
    @Override
    public Set<String> getUserPermissions(String userId) {
        List<String> permsList = new ArrayList<>();

        //系统管理员，拥有最高权限
        if (userId.equals(UserConstant.SUPER_ADMIN)) {
            List<SysMenu> menuList = sysMenuDao.selectList(null);
            for (SysMenu sysMenu : menuList) {
                permsList.add(sysMenu.getPerms());
            }
        } else {
            permsList = sysUserDao.queryAllPerms(userId);
        }

        //把权限列表放入Set集合中过滤
        Set<String> permsSet = new HashSet<>();
        for (String perms : permsList) {
            if (StringUtils.isBlank(perms)) {
                continue;
            }
            //去掉字符串两端的空格，并拆分权限字符串，最后转换为list
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        return permsSet;
    }

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