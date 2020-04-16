package com.power.fast.modules.sys.service;

import com.power.fast.util.AjaxResult;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户Token
 *
 * @author fei
 */
public interface SysUserTokenService{

	/**
	 * 生成token
	 * @param userId  用户ID
	 */
	String createToken(String userId);

	/**
	 * 退出，删除token值
	 * @param token  用户ID
	 */
	void logout(String token);

    /**
     * 根据请求头获取token
     * @param httpRequest
     * @return
     */
    String getRequestToken(HttpServletRequest httpRequest);
}
