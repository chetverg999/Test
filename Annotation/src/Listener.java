import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Listener {

    private final Map<String, Method> map = new HashMap<>();
    private final Test test = new Test();

    public void show() {
        for (Method method : test.getClass().getDeclaredMethods()) { //Берем список всех методов в классе
            if (method.isAnnotationPresent(MyAnnotation.class)) { //Смотрим, есть ли у метода нужная нам Аннотация
                map.put(method.getAnnotation(MyAnnotation.class).name(), method); //Кладем в качестве ключа нашей карты параметр name()
            }
        }
        System.out.println(map);
    }
}
