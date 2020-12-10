package edu.dlut.easyioc.context;
import edu.dlut.easyioc.pojo.Student;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClassPathXmlApplicationContextTest {

    @Test
    public void testGetBeans() throws Exception {
        AbstractApplicationContext ac = new ClassPathXmlApplicationContext("xml/beans.xml");
        Student wang = (Student) ac.getBean("wang");
        Student ming = (Student) ac.getBean("ming");
        assertEquals(wang.getName(), "Xiao Wang");
        assertEquals(ming.getName(), "Wen Ming");
        assertEquals(wang.getAge(), 20);
        assertEquals(ming.getAge(), 19);
        assertEquals(wang.getGender(), "male");
        assertEquals(ming.getGender(), "female");
        assertEquals(ming.getPencil().getName(), "Chen Guang");
    }
}
