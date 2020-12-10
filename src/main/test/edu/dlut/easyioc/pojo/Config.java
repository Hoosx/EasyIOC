package edu.dlut.easyioc.pojo;

import edu.dlut.easyioc.annotation.Bean;
import edu.dlut.easyioc.annotation.Configuration;

/**
 * @program: EasyIOC
 * @description
 * @author: Leeqh
 * @create: 2020-12-09 23:56
 **/
@Configuration
public class Config {

    @Bean
    Hello createHello() {
        return new Hello("hello");
    }
}
