package model;

import lombok.Data;

@Data
public class DependentObjectClass {
    private String name;
    private TestObjectClass testObjectClass;

}
