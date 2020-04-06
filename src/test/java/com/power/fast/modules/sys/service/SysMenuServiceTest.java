package com.power.fast.modules.sys.service;

import com.power.fast.modules.sys.dao.SysMenuDao;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author fei
 * @title: SysMenuServiceTest
 * @projectName power-fast
 * @description: TODO
 * @date 2020/4/615:20
 */
@SpringBootTest
class SysMenuServiceTest {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SysMenuService sysMenuService;

    @Test
    void contextLoads() {
        logger.info("【service查询所有菜单信息为{}", sysMenuService.list());
    }
}