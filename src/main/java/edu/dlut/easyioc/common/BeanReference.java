package edu.dlut.easyioc.common;

/**
 * @program: EasyIOC
 * @description
 * @author: Leeqh
 * @create: 2020-12-04 19:06
 **/
public class BeanReference {

    private String name;

    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
