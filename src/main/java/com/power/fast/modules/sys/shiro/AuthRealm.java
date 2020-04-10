package com.power.fast.modules.sys.shiro;

import com.power.fast.modules.sys.dto.UserTokenDTO;
import com.power.fast.modules.sys.entity.SysUser;
import com.power.fast.modules.sys.service.SysUserService;
import com.power.fast.util.RedisCache;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author fei
 * @title: OAuthRealm
 * @projectName power-fast
 * @description: 自定义认证授权器
 * @date 2020/4/9 11:10
 */
@Component
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private RedisCache redisCache;
    @Autowired
    private SysUserService sysUserService;

    /**
     * 用于检测是否支持此Token
     *
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof AuthToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证 -- 登录时调用
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String accessToken = (String) authenticationToken.getPrincipal();

        //根据accessToken，查询用户信息
        UserTokenDTO userTokenDTO = redisCache.getCacheObject(accessToken);

        //token校验
        if (userTokenDTO == null || userTokenDTO.getExpireTime().getTime() < System.currentTimeMillis()) {
            throw new IncorrectCredentialsException("token失效，请重新登录");
        }

        //查询用户信息
        SysUser user = sysUserService.getById(userTokenDTO.getUserId());
        //账号锁定
        if(user.getStatus() == 0){
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, accessToken, getName());
        return info;
    }
}
