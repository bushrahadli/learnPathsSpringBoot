package com.springBoot.learn.learnPathSpring.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Student {
    Integer id;
    String name;
    String address;
    Department dept;
    Double percentile;
    List<Subject> subject;
}
