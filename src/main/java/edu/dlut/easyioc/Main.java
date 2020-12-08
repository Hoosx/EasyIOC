package edu.dlut.easyioc;

import edu.dlut.easyioc.context.AbstractApplicationContext;
import edu.dlut.easyioc.context.AnnotationConfigApplicationContext;
import edu.dlut.easyioc.pojo.AnnotationBeanConfig;
import edu.dlut.easyioc.pojo.Student;

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
        Student wang = (Student) aca.getBean("student");
//        Student ming = (Student) ac.getBean("ming");
//
        System.out.println(wang);
//        System.out.println(ming);
    }
}
