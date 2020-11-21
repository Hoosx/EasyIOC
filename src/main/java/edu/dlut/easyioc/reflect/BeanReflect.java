package edu.dlut.easyioc.reflect;

import edu.dlut.easyioc.common.BeanDefinition;
import edu.dlut.easyioc.pojo.Student;
import edu.dlut.easyioc.util.XMLParser;
import edu.dlut.easyioc.util.XMLParserImpl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @program: EasyIOC
 * @description
 * @author: Leeqh
 * @create: 2020-11-21 10:07
 **/
public class BeanReflect {
    public static Object getInstance(BeanDefinition beanDefinition){
        Object ins = null;
        try {
            Class<?> clazz = Class.forName(beanDefinition.getBeanClassName());
            ins = clazz.getDeclaredConstructor().newInstance();
            Map<String, String> prop = beanDefinition.getProperties();
            Set<String> keys = prop.keySet();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
//                System.out.println(field.getType());
                field.setAccessible(true);
                if (keys.contains(field.getName())) {
                    if (field.getType().equals(String.class)){
                        field.set(ins, prop.get(field.getName()));
                    } else {

                        Method method = getUseClass(field.getType()).getMethod("valueOf", String.class);
                        field.set(ins, method.invoke(null, prop.get(field.getName())));
                    }
                }
            }

        } catch (ClassNotFoundException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return ins;
    }

    public static Class<?> getUseClass(Class<?> fieldType){
        switch (fieldType.toString()) {
            case "int": return Integer.class;
            case "double": return Double.class;
            case "boolean": return Boolean.class;
            case "char": return Character.class;
            case "float": return Float.class;
            case "short": return Short.class;
            case "long": return Long.class;
            case "byte": return Byte.class;
        }
        return fieldType;
    }

    public static void main(String[] args) {
        XMLParser xmlParser = new XMLParserImpl("src/main/resources/beans.xml");
        Map<String, BeanDefinition> map = xmlParser.getBeanDefinitions();
        map.values().stream().map(BeanReflect::getInstance).map(obj -> (Student)obj).forEach(System.out::println);
    }
}
