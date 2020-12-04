package edu.dlut.easyioc.context;

import edu.dlut.easyioc.factory.AbstractBeanFactory;

/**
 * @program: EasyIOC
 * @description
 * @author: Leeqh
 * @create: 2020-12-04 19:52
 **/
public abstract class AbstractApplicationContext implements ApplicationContext{

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void refresh() throws Exception{

    }

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }
}
