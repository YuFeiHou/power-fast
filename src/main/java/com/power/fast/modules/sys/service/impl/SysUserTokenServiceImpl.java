package com.power.fast.modules.sys.service.impl;

import com.power.fast.modules.sys.dto.UserTokenDTO;
import com.power.fast.modules.sys.jwt.TokenGenerator;
import com.power.fast.modules.sys.service.SysUserTokenService;
import com.power.fast.util.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service("sysUserTokenService")
public class SysUserTokenServiceImpl implements SysUserTokenService {

    //12小时后过期
    private final static int EXPIRE = 3600 * 12;

    @Autowired
    private RedisCache redisCache;

    /**
     * 生成token
     *
     * @param userId 用户ID
     */
    @Override
    public String createToken(String userId) {
        //生成一个token
        String token = TokenGenerator.generateValue();

        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

        UserTokenDTO userToken = new UserTokenDTO();
        userToken.setUserId(userId);
        userToken.setToken(token);
        userToken.setExpireTime(expireTime);
        userToken.setUpdateTime(now);
        redisCache.setCacheObject(token, userToken);
        return token;
    }

    /**
     * 退出，修改token值
     *
     * @param userId 用户ID
     */
    @Override
    public void logout(String userId) {
        //生成一个token
        String token = TokenGenerator.generateValue();
        //修改token
        UserTokenDTO userToken = new UserTokenDTO();
        userToken.setToken(token);
        userToken.setUserId(userId);
        redisCache.setCacheObject(userId, userToken);
    }
}
