package edu.dlut.easyioc.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shuxiang Hu
 * @date 11/19/2020
 */
public class BeanDefinition {
    private String beanClassName;
    private Map<String, String> propertyValues = new HashMap<String, String>();

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
    }

    public Map<String, String> getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(Map<String, String> propertyValues) {
        this.propertyValues = propertyValues;
    }

    public BeanDefinition(String beanClassName) {
        this.beanClassName = beanClassName;
    }
}
