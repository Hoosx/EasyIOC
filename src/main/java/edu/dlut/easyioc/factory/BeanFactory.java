package edu.dlut.easyioc.factory;

/**
 * @program: EasyIOC
 * @description
 * @author: Leeqh
 * @create: 2020-12-04 19:09
 **/
public interface BeanFactory {
    Object getBean(String name) throws Exception;
}
