
import java.util.HashMap;
import java.util.Map;

public class Teacher  {

    private final Map diary;

    public Teacher() {
        this.diary = new HashMap<StudentInfo, Diary>();
    }

    public Map getDiary() {
        return diary;
    }
}
