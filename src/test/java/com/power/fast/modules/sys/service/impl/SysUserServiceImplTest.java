package com.power.fast.modules.sys.service.impl;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author fei
 * @title: SysUserServiceImplTest
 * @projectName power-fast
 * @description:
 * @date 2020/4/9 19:28
 */
@SpringBootTest
class SysUserServiceImplTest {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SysUserServiceImpl sysUserService;

    @Test
    void queryByUserName() {
        logger.info("根据用户名名称获取用户信息为：{}",sysUserService.queryByUserName("admin"));
    }
}