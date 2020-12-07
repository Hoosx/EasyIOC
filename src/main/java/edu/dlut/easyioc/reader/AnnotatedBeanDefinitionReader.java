package edu.dlut.easyioc.reader;

import edu.dlut.easyioc.io.ResourceLoader;

import java.io.IOException;

/**
 * @author Shuxiang Hu
 * @date 12/07/2020
 */
public class AnnotatedBeanDefinitionReader extends AbstractBeanDefinitionReader {
    private String CLASSPATH_ALL_URL_PREFIX;
    public AnnotatedBeanDefinitionReader(ResourceLoader resourceLoader){
        super(resourceLoader);
    }

    public void loadBeanDefinitions(Class<?> clazz) throws IOException {
        // Resource for annotation type is not handled yet.
        Class[] classes = getResourceLoader().getResource(clazz);
    }
}
