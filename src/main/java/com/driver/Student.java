package com.driver;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Student {

    private String name;
    private int age;
    private double averageScore;

    public Student(String name, int age, double averageScore) {
        //this.id=id;
        this.name = name;
        this.age = age;
        this.averageScore = averageScore;
    }

    public Student(){

    }
}
