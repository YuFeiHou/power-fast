package com.power.fast.modules.sys.service;

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
	 * 退出，修改token值
	 * @param token  用户ID
	 */
	void logout(String token);

}
