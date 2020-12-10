package edu.dlut.easyioc.pojo;

/**
 * @program: EasyIOC
 * @description
 * @author: Leeqh
 * @create: 2020-12-09 23:55
 **/
public class Hello {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hello(String name) {
        this.name = name;
    }
}
