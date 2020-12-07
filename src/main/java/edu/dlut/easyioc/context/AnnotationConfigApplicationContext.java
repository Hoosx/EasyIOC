package edu.dlut.easyioc.context;

import edu.dlut.easyioc.common.BeanDefinition;
import edu.dlut.easyioc.factory.AbstractBeanFactory;
import edu.dlut.easyioc.factory.AutoWireCapableBeanFactory;
import edu.dlut.easyioc.io.AnnotatedResourceLoader;
import edu.dlut.easyioc.reader.AbstractBeanDefinitionReader;
import edu.dlut.easyioc.reader.AnnotatedBeanDefinitionReader;

import java.util.Map;


/**
 * @author Shuxiang Hu
 * @date 12/07/2020
 */
public class AnnotationConfigApplicationContext extends AbstractApplicationContext {

    public AnnotationConfigApplicationContext(Class<?> clazz) throws Exception {
        this(new AutoWireCapableBeanFactory(), clazz);
    }

    private AnnotationConfigApplicationContext(AbstractBeanFactory beanFactory, Class<?> clazz) throws Exception {
        super(beanFactory);
        this.refresh(clazz);
    }

    void refresh(Class<?> clazz) throws Exception {
        AbstractBeanDefinitionReader abdr = new AnnotatedBeanDefinitionReader(new AnnotatedResourceLoader());
        abdr.loadBeanDefinitions(clazz);
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : abdr.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
    }
}