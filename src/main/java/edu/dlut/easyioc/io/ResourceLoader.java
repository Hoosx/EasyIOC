package edu.dlut.easyioc.io;

import java.io.IOException;
import java.util.Set;

/**
 * @program: EasyIOC
 * @description
 * @author: Leeqh
 * @create: 2020-12-04 16:11
 **/
public interface ResourceLoader {
    default Resource getResource(String location){
        return null;
    };

    default Set<Class<?>> getResource(Class<?> clazz) throws IOException {
        return null;
    }
}
