package com.power.fast.modules.sys.service.impl;

import com.power.fast.constant.HttpStatus;
import com.power.fast.exception.RRException;
import com.power.fast.modules.sys.dto.UserTokenDTO;
import com.power.fast.modules.sys.jwt.TokenGenerator;
import com.power.fast.modules.sys.service.SysUserTokenService;
import com.power.fast.util.AjaxResult;
import com.power.fast.util.RedisCache;
import com.power.fast.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
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
     * @param token token
     */
    @Override
    public void logout(String token) {
        redisCache.deleteObject(token);
    }

    /**
     * 根据请求头获取token
     *
     * @param httpRequest
     * @return
     */
    @Override
    public String getRequestToken(HttpServletRequest httpRequest) {
        //从header中获取token
        String token = httpRequest.getHeader("token");
        if (StringUtils.isBlank(token)) {
            throw new RRException("token 不允许为空！ ", HttpStatus.UNAUTHORIZED);
        }

        //重缓存中获取token
        UserTokenDTO userTokenDTO = redisCache.getCacheObject(token);
        if (userTokenDTO == null) {
            throw new RRException("token 信息错误！ ", HttpStatus.UNAUTHORIZED);
        }

        return token;
    }
}
