package edu.dlut.easyioc.factory;

import edu.dlut.easyioc.common.BeanDefinition;
import edu.dlut.easyioc.common.BeanReference;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @program: EasyIOC
 * @description
 * @author: Leeqh
 * @create: 2020-12-04 19:23
 **/
public class AutoWireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        beanDefinition.setBean(bean);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    private void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception {
        for (Map.Entry<String, Object> property : beanDefinition.getProperties().entrySet()) {
            Field declaredField = bean.getClass().getDeclaredField(property.getKey());
            declaredField.setAccessible(true);
            Object value = property.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }
            declaredField.set(bean, value);
        }
    }

    private Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().getDeclaredConstructor().newInstance();
    }
}
