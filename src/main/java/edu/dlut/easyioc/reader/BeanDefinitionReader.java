package edu.dlut.easyioc.reader;

/**
 * @program: EasyIOC
 * @description
 * @author: Leeqh
 * @create: 2020-12-04 16:19
 **/
public interface BeanDefinitionReader {
    default void loadBeanDefinitions(String location) throws Exception {
//        throw new NotImplementedException();
    };

    default void loadBeanDefinitions(Class<?> clazz) throws Exception{
//        throw new NotImplementedException();
    }
}
