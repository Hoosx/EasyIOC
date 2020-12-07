package edu.dlut.easyioc.io;


import edu.dlut.easyioc.Main;
import edu.dlut.easyioc.annotation.Configuration;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @author Shuxiang Hu
 * @date 12/07/2020
 */
public class AnnotatedResourceLoader implements ResourceLoader {
    public static void main(String[] args) throws IOException {
        AnnotatedResourceLoader arl = new AnnotatedResourceLoader();
        arl.getResource(Main.class);
    }

    @Override
    public Class[] getResource(Class<?> clazz) throws IOException {
        assert clazz.isAnnotationPresent(Configuration.class);
        String pth = clazz.getResource("").getPath();
        System.out.println(pth);
        Enumeration<URL> clazzs = clazz.getClassLoader().getResources(pth);
        while (clazzs.hasMoreElements()){
            URL url = clazzs.nextElement();
            System.out.println(url.getPath());
        }
        return null;
    }
}
