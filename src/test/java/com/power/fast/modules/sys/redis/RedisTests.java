package com.power.fast.modules.sys.redis;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author fei
 * @title: RedisTests
 * @projectName power-fast
 * @description: redis 测试
 * @date 2020/4/7 16:53
 */
@SpringBootTest
public class RedisTests {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RedisTemplate redisTemplate;//key - value 都是对象
    @Autowired
    private StringRedisTemplate stringRedisTemplate;//key - value 都是字符串

    @Test
    public void redisTests() {
        //http://www.redis.cn/commands.html#list 详细操作请参考该网站
        //stringRedisTemplate.opsForValue().append("hello","hello");
        logger.info("redis存储的数据为："+stringRedisTemplate.opsForValue().get("hello"));
        //stringRedisTemplate.opsForList().leftPush("List","1");
    }
}
