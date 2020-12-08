package edu.dlut.easyioc.context;

import edu.dlut.easyioc.common.BeanDefinition;
import edu.dlut.easyioc.factory.AbstractBeanFactory;
import edu.dlut.easyioc.factory.AutoWireCapableBeanFactory;
import edu.dlut.easyioc.io.AnnotatedResourceLoader;
import edu.dlut.easyioc.reader.AbstractBeanDefinitionReader;
import edu.dlut.easyioc.reader.AnnotatedBeanDefinitionReader;

import java.util.Map;

import static java.lang.System.exit;
import static java.lang.System.setOut;


/**
 * @author Shuxiang Hu
 * @date 12/07/2020
 */
public class AnnotationConfigApplicationContext extends AbstractApplicationContext {
    private Class<?> confiClazz;

    public AnnotationConfigApplicationContext(Class<?> clazz) throws Exception {
        this(new AutoWireCapableBeanFactory(), clazz);
    }

    private AnnotationConfigApplicationContext(AbstractBeanFactory beanFactory, Class<?> clazz) throws Exception {
        super(beanFactory);
        this.confiClazz = clazz;
        this.refresh();
    }
    @Override
    public void refresh() throws Exception {
        AbstractBeanDefinitionReader abdr = new AnnotatedBeanDefinitionReader(new AnnotatedResourceLoader());
        abdr.loadBeanDefinitions(confiClazz);
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : abdr.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
    }
}