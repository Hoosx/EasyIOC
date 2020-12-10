package edu.dlut.easyioc.pojo;

import edu.dlut.easyioc.annotation.AutoWired;
import edu.dlut.easyioc.annotation.Component;
import edu.dlut.easyioc.annotation.Value;

/**
 * @author Shuxiang Hu
 * @date 11/19/2020
 */
@Component
public class Student {
    @Value(value = "hu")
    private String name;
    private int age;
    private String gender;

    @AutoWired
    public Pencil pencil;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}

