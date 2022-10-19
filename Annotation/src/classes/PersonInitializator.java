package classes;

import annotations.PersonAutoFieldsAnnotation;
import java.lang.reflect.Field;

public class PersonInitializator { // класс для записи полей напрямую из аргументов аннотации

    public void initializator(Object object) throws IllegalAccessException {
       if (object.getClass().isAnnotationPresent(PersonAutoFieldsAnnotation.class)) {
            for (Field field : object.getClass().getDeclaredFields()) {
                if (object.getClass().isAnnotationPresent(PersonAutoFieldsAnnotation.class)) {
                    if (field.getName().equals("name")) {
                        field.set(object, object.getClass().getAnnotation(PersonAutoFieldsAnnotation.class).value());
                    }
                    if (field.getName().equals("age")) {
                        field.set(object, object.getClass().getAnnotation(PersonAutoFieldsAnnotation.class).longValue());
                    }
                }
            }
        }
    }
}
