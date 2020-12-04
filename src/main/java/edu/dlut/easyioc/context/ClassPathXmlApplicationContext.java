package edu.dlut.easyioc.context;

import edu.dlut.easyioc.common.BeanDefinition;
import edu.dlut.easyioc.factory.AbstractBeanFactory;
import edu.dlut.easyioc.factory.AutoWireCapableBeanFactory;
import edu.dlut.easyioc.io.URLResourceLoader;
import edu.dlut.easyioc.reader.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @program: EasyIOC
 * @description
 * @author: Leeqh
 * @create: 2020-12-04 19:56
 **/
public class ClassPathXmlApplicationContext extends AbstractApplicationContext{

    private String configLocation;

    public ClassPathXmlApplicationContext(AbstractBeanFactory beanFactory, String configLocation) throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        this.refresh();
    }

    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        this(new AutoWireCapableBeanFactory(), configLocation);
    }

    @Override
    public void refresh() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new URLResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
//        beanFactory.preInstantiateSingletons();
    }
}
