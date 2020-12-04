package edu.dlut.easyioc.factory;

import edu.dlut.easyioc.common.BeanDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: EasyIOC
 * @description
 * @author: Leeqh
 * @create: 2020-12-04 19:11
 **/
public abstract class AbstractBeanFactory implements BeanFactory{

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    //添加这个名字列表的意义是什么呢?
    private List<String> beanDefinitionNames = new ArrayList<>();

    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }
        Object bean = beanDefinition.getBean();
        if (bean == null) {
            bean = doCreateBean(beanDefinition);
        }
        return bean;
    }

    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition){
        beanDefinitionMap.put(name, beanDefinition);
        beanDefinitionNames.add(name);
    }

    public void preInstantiateSingletons() throws Exception {
        for (String name: beanDefinitionNames) {
            getBean(name);
        }
    }
}
