package model;

import lombok.Data;

@Data
public class TestObjectClass {
    private String name;
    private int age;

    public TestObjectClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public TestObjectClass() {
    }
}
