package com.power.fast.modules.sys.shiro;


import org.apache.shiro.authc.AuthenticationToken;

/**
 * token对象,shiro 中的AuthenticationToken
 *
 * @author fei
 */
public class AuthToken implements AuthenticationToken {
    private String token;

    public AuthToken(String token) {
        this.token = token;
    }

    @Override
    public String getPrincipal() {
        return token;
    }

    /**
     * 获取token
     *
     * @return
     */
    @Override
    public Object getCredentials() {
        return token;
    }
}
