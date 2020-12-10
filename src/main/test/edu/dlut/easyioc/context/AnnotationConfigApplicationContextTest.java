package edu.dlut.easyioc.context;

import edu.dlut.easyioc.pojo.AnnotationBeanScan;
import edu.dlut.easyioc.pojo.Hello;
import edu.dlut.easyioc.pojo.Pencil;
import edu.dlut.easyioc.pojo.Student;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnnotationConfigApplicationContextTest {
    static AbstractApplicationContext aca = null;

    @BeforeClass
    public static void loadRes() throws Exception {
        aca = new AnnotationConfigApplicationContext(AnnotationBeanScan.class);
    }

    @Test
    public void getComponentAnnotatedBeans() throws Exception {
        Student student = (Student) aca.getBean("student");
        Pencil pencil = (Pencil) aca.getBean("pencil");
        assertEquals(student.getName(), "hu");
        assertEquals(pencil.getName(), "CHENG GUANG");
    }

    @Test
    public void getBeanAnnotatedBeans() throws Exception {
        Hello hello = (Hello) aca.getBean("hello");
        assertEquals(hello.getName(), "hello");
    }
}
