package edu.dlut.easyioc.reader;

import edu.dlut.easyioc.annotation.*;
import edu.dlut.easyioc.common.BeanDefinition;
import edu.dlut.easyioc.common.BeanReference;
import edu.dlut.easyioc.io.ResourceLoader;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author Shuxiang Hu
 * @date 12/07/2020
 */
public class AnnotatedBeanDefinitionReader extends AbstractBeanDefinitionReader {
    public AnnotatedBeanDefinitionReader(ResourceLoader resourceLoader){
        super(resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Class<?> clazz) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // Resource for annotation type is not handled yet.
        Set<Class<?>> components = getResourceLoader().getResource(clazz);
        for (Class<?> component:components){
            registerBeanDefinition(component);
            if (component.getDeclaredAnnotation(Configuration.class) != null) {
                registerConfiguration(component);
            }
        }
    }

    private void registerConfiguration(Class<?> component) throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Method[] methods = component.getDeclaredMethods();
        for (Method method : methods) {
            Bean beanAnnotation = method.getDeclaredAnnotation(Bean.class);
            if (beanAnnotation != null) {
                Object obj = component.getDeclaredConstructor().newInstance();
                method.setAccessible(true);
                Object bean = method.invoke(obj);
                BeanDefinition beanDefinition = new BeanDefinition();
                beanDefinition.setBeanClassName(bean.getClass().getName());
                beanDefinition.setBean(bean);
                if (beanAnnotation.value().equals("")) {
                    getRegistry().put(getDefaultName(bean.getClass()), beanDefinition);
                } else {
                    getRegistry().put(((Bean) bean).value(), beanDefinition);
                }
            }
        }
    }

    private void registerBeanDefinition(Class<?> componentClazz){
        BeanDefinition beanDefinition = new BeanDefinition();
        beanDefinition.setBeanClassName(componentClazz.getName());
        Field[] fields = componentClazz.getDeclaredFields();
        for (Field field: fields){
            field.setAccessible(true);
            Annotation[] annotations = field.getDeclaredAnnotations();
            for(Annotation annotation: annotations){
                if(annotation instanceof AutoWired){
                    BeanReference beanReference = new BeanReference(field.getName());
                    beanDefinition.setPropAndValue(field.getName(), beanReference);
                } else if(annotation instanceof Value){
                    beanDefinition.setPropAndValue(field.getName(), ((Value) annotation).value());
                }
            }
        }
        getRegistry().put(getDefaultName(componentClazz), beanDefinition);
    }

    private String getDefaultName(Class<?> componentClazz) {
        String beanName = componentClazz.getSimpleName();
        Character firstLetter = beanName.charAt(0);
        return beanName.replaceFirst(firstLetter.toString(), firstLetter.toString().toLowerCase());
    }
}
