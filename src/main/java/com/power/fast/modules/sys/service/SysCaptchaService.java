/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.power.fast.modules.sys.service;

import java.awt.image.BufferedImage;

/**
 * 验证码
 *
 * @author fei
 */
public interface SysCaptchaService{

    /**
     * 获取图片验证码
     */
    BufferedImage getCaptcha(String uuid);

    /**
     * 验证码效验
     * @param code  验证码
     * @return  true：成功  false：失败
     */
    boolean validate(String code, String uuid);
}
