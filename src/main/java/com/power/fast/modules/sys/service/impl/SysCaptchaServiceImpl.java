package com.power.fast.modules.sys.service.impl;

import com.google.code.kaptcha.Producer;
import com.power.fast.exception.RRException;
import com.power.fast.modules.sys.service.SysCaptchaService;
import com.power.fast.util.RedisCache;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

/**
 * 验证码
 *
 * @author fei
 */
@Service("sysCaptchaService")
public class SysCaptchaServiceImpl implements SysCaptchaService {


    @Autowired
    private Producer producer;
    @Autowired
    private RedisCache redisCache;

    @Override
    public BufferedImage getCaptcha(String uuid) {
        if (StringUtils.isBlank(uuid)) {
            throw new RRException("uuid不允许为空！");
        }

        //生成文字验证码
        String code = producer.createText();
        //传入redis中, 5分钟后过期
        redisCache.setCacheObject(uuid, code, 5, TimeUnit.MINUTES);

        return producer.createImage(code);
    }

    /**
     * 验证码效验
     *
     * @param code 验证码
     * @return true：成功  false：失败
     */
    @Override
    public boolean validate(String code, String uuid) {
        //从缓冲中获取code码
        String captchaCode = redisCache.getCacheObject(uuid);
        if (StringUtils.isBlank(captchaCode)) {
            return false;
        }

        //删除验证码
        redisCache.deleteObject(uuid);

        if (captchaCode.equalsIgnoreCase(code)) {
            return true;
        }
        return false;
    }
}
