package edu.dlut.easyioc.reader;

import edu.dlut.easyioc.annotation.AutoWired;
import edu.dlut.easyioc.annotation.Component;
import edu.dlut.easyioc.annotation.Value;
import edu.dlut.easyioc.common.BeanDefinition;
import edu.dlut.easyioc.common.BeanReference;
import edu.dlut.easyioc.io.ResourceLoader;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
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
    public void loadBeanDefinitions(Class<?> clazz) throws IOException {
        // Resource for annotation type is not handled yet.
        Set<Class<?>> components = getResourceLoader().getResource(clazz);
        for (Class<?> component:components){
            registerBeanDefinition(component);
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
        // TODO: add support for more annotations
        String beanName = componentClazz.getSimpleName();
        Character firstLetter = beanName.charAt(0);
        getRegistry().put(beanName.replaceFirst(firstLetter.toString(), firstLetter.toString().toLowerCase()), beanDefinition);
    }
}
