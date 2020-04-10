package com.power.fast.modules.sys.service;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author fei
 * @title: SysUserServiceTest
 * @projectName power-fast
 * @description: TODO
 * @date 2020/4/1010:08
 */
@SpringBootTest
class SysUserServiceTest {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SysUserService sysUserService;

    @Test
    void queryByUserName() {
        logger.info("根据用户id获取用户信息为：{}",sysUserService.getById("15741189618"));
    }
}