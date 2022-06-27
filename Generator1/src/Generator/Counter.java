package Generator;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Counter {

    static Map<Long, List<Object>> count = new LinkedHashMap<>();


    public static  void printValues() {
        for (Map.Entry<Long, List<Object>> pair : count.entrySet()) {
            String value = String.valueOf(pair.getValue());
            String key = String.valueOf(pair.getKey());
            System.out.println(key + " " + value);
        }
    }

}