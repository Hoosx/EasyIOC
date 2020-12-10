package edu.dlut.easyioc.annotation;

import java.lang.annotation.*;

/**
 * @program: EasyIOC
 * @description
 * @author: Leeqh
 * @create: 2020-12-09 23:28
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Bean {
    String value() default "";
}
