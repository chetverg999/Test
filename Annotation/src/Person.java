

@PersonAnnotation
public class Person {

    @PersonFieldsAnnotation
    String name;

    @PersonFieldsAnnotation
    Integer age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
