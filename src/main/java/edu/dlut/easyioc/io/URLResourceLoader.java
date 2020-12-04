package edu.dlut.easyioc.io;

import java.net.URL;

/**
 * @program: EasyIOC
 * @description
 * @author: Leeqh
 * @create: 2020-12-04 16:14
 **/
public class URLResourceLoader implements ResourceLoader{
    @Override
    public Resource getResource(String location) {
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new URLRsource(resource);
    }
}
