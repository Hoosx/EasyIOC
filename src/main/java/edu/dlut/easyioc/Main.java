package edu.dlut.easyioc;

import edu.dlut.easyioc.context.AbstractApplicationContext;
import edu.dlut.easyioc.context.AnnotationConfigApplicationContext;
import edu.dlut.easyioc.context.ClassPathXmlApplicationContext;
import edu.dlut.easyioc.pojo.Student;

/**
 * @program: EasyIOC
 * @description
 * @author: Leeqh
 * @create: 2020-12-04 16:17
 **/
public class Main {
    public static void main(String[] args) throws Exception {
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext("xml/beans.xml");
//        AbstractApplicationContext aca = new AnnotationConfigApplicationContext(Main.class);
        Student wang = (Student) ac.getBean("wang");
        Student ming = (Student) ac.getBean("ming");

        System.out.println(wang);
        System.out.println(ming);
    }
}
