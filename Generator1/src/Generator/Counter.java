package generator;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class Counter {

    Map<Long, Generator.Parametrs> count = new LinkedHashMap<>();

    public void printValues() {
        for (Map.Entry<Long, Generator.Parametrs> pair : count.entrySet()) {
            String key = String.valueOf(pair.getKey());
            Generator.Parametrs parametrs = pair.getValue();
            System.out.println("Id: " + key + " " + parametrs);
        }
    }

    public void printValues5() {
        for (Map.Entry<Long, Generator.Parametrs> pair : count.entrySet()) {
            String key = String.valueOf(pair.getKey());
            Generator.Parametrs parametrs = pair.getValue();
            if (parametrs.number > 5) {
                System.out.println("Id: " + key + " " + parametrs);
            }
        }
    }

    public void printValuesPer10sec() {
        Date now = new Date();
        for (Map.Entry<Long, Generator.Parametrs> pair : count.entrySet()) {
            String key = String.valueOf(pair.getKey());
            Generator.Parametrs parametrs = pair.getValue();
            if (parametrs.dateNow.getTime() > (now.getTime() - 10000)) {
                System.out.println("Id: " + key + " " + parametrs);
                System.out.println(now.getTime());
                System.out.println(parametrs.dateNow.getTime());
            }
        }
    }

}