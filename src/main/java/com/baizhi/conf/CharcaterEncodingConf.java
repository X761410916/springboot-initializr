package com.baizhi.conf;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author 徐三
 * @company com.1999
 * @create 2019-12-03 14:15
 */

/*配置注释
@Configuration
当没有自定义Bean的时候会执行该类
@ConditionalOnMissingBean
*/

public class CharcaterEncodingConf  {

    @Bean
    public CharacterEncodingFilter getCharacterEncodingFilter(){
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        /*设置SpringBoot编码过滤器*/
        characterEncodingFilter.setEncoding("UTF-8");
        /*强制执行编码*/
        characterEncodingFilter.setForceEncoding(true);
        /*请求执行强制编码*/
        characterEncodingFilter.setForceRequestEncoding(true);
        /*响应执行强制编码*/
        characterEncodingFilter.setForceResponseEncoding(true);
        return characterEncodingFilter;
    }
}
