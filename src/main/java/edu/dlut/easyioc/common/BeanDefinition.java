package edu.dlut.easyioc.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shuxiang Hu
 * @date 11/19/2020
 */
public class BeanDefinition {
    private String beanClassName;
    private Map<String, String> properties = new HashMap<String, String>();

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public void setPropAndValue(String property, String value){
        properties.put(property, value);
    }

    public BeanDefinition(String beanClassName) {
        this.beanClassName = beanClassName;
    }
}
