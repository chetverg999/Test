public class StudentInfo {
    int id;
    int group;

    public StudentInfo(int id, int group) { // у студента есть фио - id, и группа
        this.id = id;
        this.group = group;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", group=" + group;
    }
}


