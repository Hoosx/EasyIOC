package edu.dlut.easyioc;

import edu.dlut.easyioc.context.AbstractApplicationContext;
import edu.dlut.easyioc.context.AnnotationConfigApplicationContext;
import edu.dlut.easyioc.pojo.Hello;
import edu.dlut.easyioc.pojo.Pencil;

/**
 * @program: EasyIOC
 * @description
 * @author: Leeqh
 * @create: 2020-12-04 16:17
 **/
public class Main {
    public static void main(String[] args) throws Exception {
//        AbstractApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        AbstractApplicationContext aca = new AnnotationConfigApplicationContext(AnnotationBeanConfig.class);
        Pencil pencil = (Pencil) aca.getBean("pencil");
        System.out.println(pencil.getName());
        Hello hello = (Hello) aca.getBean("hello");
        System.out.println(hello.getName());
    }
}
