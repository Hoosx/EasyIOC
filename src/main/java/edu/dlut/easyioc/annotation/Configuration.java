package edu.dlut.easyioc.annotation;

import java.lang.annotation.*;

/**
 * @program: EasyIOC
 * @description
 * @author: Leeqh
 * @create: 2020-12-09 23:15
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Configuration {
    String value() default "";
}
