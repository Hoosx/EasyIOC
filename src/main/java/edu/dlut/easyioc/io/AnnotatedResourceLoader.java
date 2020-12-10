package edu.dlut.easyioc.io;


import edu.dlut.easyioc.annotation.Component;
import edu.dlut.easyioc.annotation.ComponentScan;
import edu.dlut.easyioc.annotation.Configuration;
import org.reflections.Reflections;

import java.io.IOException;
import java.util.Set;

/**
 * @author Shuxiang Hu
 * @date 12/07/2020
 */
public class AnnotatedResourceLoader implements ResourceLoader {
//    public static void main(String[] args) throws IOException {
//        AnnotatedResourceLoader arl = new AnnotatedResourceLoader();
//        arl.getResource(BeanConfig.class);
//    }

    @Override
    public Set<Class<?>> getResource(Class<?> clazz) throws IOException {
        assert clazz.isAnnotationPresent(ComponentScan.class);
        Reflections annotationScanned = new Reflections(clazz.getPackageName());
        Set<Class<?>> componentClazzSet = annotationScanned.getTypesAnnotatedWith(Component.class);
        return componentClazzSet;
    }
}
