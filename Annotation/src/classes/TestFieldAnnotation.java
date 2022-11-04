package classes;

import annotations.FieldAnnotation;

public class TestFieldAnnotation {

    @FieldAnnotation
    String name;
    @FieldAnnotation
    Long age;

    @Override
    public String toString() {
        return "TestFieldAnnotation{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
