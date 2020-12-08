package edu.dlut.easyioc.annotation;

import java.lang.annotation.*;

/**
 * @author Shuxiang Hu
 * @date 12/7/2020
 */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AutoWired {
    boolean required() default true;
}