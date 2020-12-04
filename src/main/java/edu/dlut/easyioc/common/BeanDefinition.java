package edu.dlut.easyioc.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shuxiang Hu
 * @date 11/19/2020
 */
public class BeanDefinition {
    private Object bean;
    private Class<?> beanClass;
    private String beanClassName;
    private Map<String, Object> properties;

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    public void setPropAndValue(String property, Object value){
        properties.put(property, value);
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public BeanDefinition() {
        properties = new HashMap<>();
    }
}
