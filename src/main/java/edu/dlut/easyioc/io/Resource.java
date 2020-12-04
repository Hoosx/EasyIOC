package edu.dlut.easyioc.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: EasyIOC
 * @description
 * @author: Leeqh
 * @create: 2020-12-04 16:08
 **/
public interface Resource {
    InputStream getInputStream() throws IOException;
}
