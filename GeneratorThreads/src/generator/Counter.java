package generator;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class Counter {

    private final Map<Long, Parameters> count;

    public Counter() {
        this.count = new LinkedHashMap<>();
    }

    public Map<Long, Parameters> getCount() {
        return count;
    }

    public void printValues() {  // вывод всех сгенерированных, на данный момент, значений
        for (Map.Entry<Long, Parameters> pair : count.entrySet()) {
            String key = String.valueOf(pair.getKey());
            Parameters parameters = pair.getValue();
            System.out.println("Id: " + key + " " + parameters);
        }
    }

    public void printValues5() {  // вывод всех значений с нормером, большим 5
        for (Map.Entry<Long, Parameters> pair : count.entrySet()) {
            String key = String.valueOf(pair.getKey());
            Parameters parameters = pair.getValue();
            if (parameters.getNumber() > 5) {
                System.out.println("Id: " + key + " " + parameters);
            }
        }
    }

    public void printValuesPer10sec() {  // вывод всех значений, сгенерированных за последние 10 секунд
        Date now = new Date();
        for (Map.Entry<Long, Parameters> pair : count.entrySet()) {
            String key = String.valueOf(pair.getKey());
            Parameters parametrs = pair.getValue();
            if (parametrs.getDateNow().getTime() > (now.getTime() - 10000)) {
                System.out.println("Id: " + key + " " + parametrs);
            }
        }
    }

}