package com.power.fast.modules.sys.dao;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author fei
 * @title: SysMenuDaoTest
 * @projectName power-fast
 * @description: TODO
 * @date 2020/4/615:12
 */
@SpringBootTest
class SysMenuDaoTest {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SysMenuDao sysMenuDao;

    @Test
    void contextLoads() {
        logger.info("【dao查询所有菜单信息为{}",sysMenuDao.selectList(null));
    }
}