package com.baizhi;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 徐三
 * @company com.1999
 * @create 2019-12-02 16:16
 */
/*
* 指定测试入口类
* */
@SpringBootTest(classes = App.class)
/*
* 启动容器
* */
@RunWith(SpringRunner.class)
/*
* Logger注解
* */
@Slf4j
public class testUser {
    Logger log = LoggerFactory.getLogger(testUser.class);

}
