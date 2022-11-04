package classes;

import annotations.PersonAnnotation;
import annotations.PersonAutoFieldsAnnotation;
import annotations.PersonFieldsAnnotation;

@PersonAutoFieldsAnnotation(value = "John", longValue = 22)
@PersonAnnotation
public class Person {

    @PersonFieldsAnnotation
    String name;

    @PersonFieldsAnnotation
    Long age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
