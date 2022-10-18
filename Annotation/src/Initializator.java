import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.*;

public class Initializator {

    private final Map<String, Object> map = new TreeMap<>();

    public void initialization(Object object, Class<?> clas) throws IllegalAccessException {
        if (clas.isAnnotationPresent(PersonAnnotation.class)) {

            FileInputStream fis;
            Properties property = new Properties();

            try {
                fis = new FileInputStream("src/prop.properties");
                property.load(fis);

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            for (Field field : clas.getDeclaredFields()) {
                if (field.isAnnotationPresent(PersonFieldsAnnotation.class)) {
                    field.setAccessible(true);
                    String string = property.getProperty(field.getName());
                    Type type = field.getType();
                    System.out.println(type.getTypeName());
                    if(type.getTypeName().equals("java.lang.Integer")) {
                        int value = Integer.parseInt(string);
                        //field.set(экземпляр объекта, значение поля этого объекта);
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
}
