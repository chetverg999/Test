package classes;

import annotations.FieldAnnotation;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

public class TestFieldAnnotationInitializator
{
    private final Map<String, Object> map = new TreeMap<>();

    public void initialization(Object object) throws IllegalAccessException {

            FileInputStream fis;
            Properties property = new Properties();

            try {
                fis = new FileInputStream("src/resources/prop.properties");
                property.load(fis);

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            for (Field field : object.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(FieldAnnotation.class)) {
                    field.setAccessible(true);
                    String string = property.getProperty(field.getName());
                    Type type = field.getType();

                    if(type.getTypeName().equals("java.lang.Integer")) {
                        int value = Integer.parseInt(string);
                        field.set(object, value);
                    }
                    if(type.getTypeName().equals("java.lang.Long")) {
                        long value = Long.parseLong(string);
                        field.set(object, value);
                    }
                    if(type.getTypeName().equals("java.lang.Boolean")) {
                        boolean value = Boolean.parseBoolean(string);
                        field.set(object, value);
                    }
                    if(type.getTypeName().equals("java.lang.String")) {
                        field.set(object, string);
                    }
                }
            }
        }
    }
