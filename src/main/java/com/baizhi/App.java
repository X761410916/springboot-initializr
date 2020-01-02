package com.baizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/*
* 声明为springboot应用
* 该类为Spring Boot主配置类
* SpringBoot就该运行该类的main方法来启动SpirngBoot应用
* */
/*@ImportResource("classpath:")*/
@SpringBootApplication
/*
* 扫描dao
* */
@MapperScan("com.baizhi.dao")
/*主入口类*/
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
