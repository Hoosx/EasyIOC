package edu.dlut.easyioc.annotation;

import java.lang.annotation.*;

/**
 * @author Shuxiang Hu
 * @date 12/7/2020
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {
    String value();
}