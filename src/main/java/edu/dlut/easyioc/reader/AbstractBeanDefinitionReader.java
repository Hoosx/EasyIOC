package edu.dlut.easyioc.reader;


import edu.dlut.easyioc.common.BeanDefinition;
import edu.dlut.easyioc.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: EasyIOC
 * @description
 * @author: Leeqh
 * @create: 2020-12-04 16:20
 **/
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    private Map<String, BeanDefinition> registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.registry = new HashMap<>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
