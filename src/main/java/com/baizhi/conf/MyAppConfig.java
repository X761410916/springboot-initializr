package com.baizhi.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 * @author 徐三
 * @company com.1999
 * @create 2019-12-04 20:31
 */
/*
* @Configuration 指明当前类是一个配置类 用于代替Spring.xml配置文件
* 在配置文件中使用 Bean添加组件
* */
@Configuration
public class MyAppConfig {

    //该方法的返回值添加到容器中 容器中的组件id为方法名
    @Bean
    public String test(){

        return "";
    }
}
