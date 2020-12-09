package edu.dlut.easyioc.factory;

import edu.dlut.easyioc.common.BeanDefinition;
import edu.dlut.easyioc.common.BeanReference;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
            Class<?> fieldType = declaredField.getType();
            declaredField.setAccessible(true);
            Object value = property.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            } else {
                if (fieldType != String.class){
                    Method method = getUseClass(fieldType).getDeclaredMethod("valueOf", String.class);
                    value = method.invoke(null, value);
                }
            }
            declaredField.set(bean, value);
        }
    }

    private Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().getDeclaredConstructor().newInstance();
    }

    public static Class<?> getUseClass(Class<?> fieldType){
        switch (fieldType.toString()) {
            case "int": return Integer.class;
            case "double": return Double.class;
            case "boolean": return Boolean.class;
            case "char": return Character.class;
            case "float": return Float.class;
            case "short": return Short.class;
            case "long": return Long.class;
            case "byte": return Byte.class;
        }
        return fieldType;
    }
}
