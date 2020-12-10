package edu.dlut.easyioc.pojo;

import edu.dlut.easyioc.annotation.Component;
import edu.dlut.easyioc.annotation.Configuration;
import edu.dlut.easyioc.annotation.Value;
import edu.dlut.easyioc.context.AbstractApplicationContext;
import edu.dlut.easyioc.context.AnnotationConfigApplicationContext;

/**
 * @author Shuxiang Hu
 * @date 12/9/2020
 */
@Component
public class Pencil{
    @Value("CHENG GUANG")
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}