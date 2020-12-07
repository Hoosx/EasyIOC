package edu.dlut.easyioc.io;

import java.io.IOException;

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

    default Class[] getResource(Class<?> clazz) throws IOException {
        return null;
    }
}
