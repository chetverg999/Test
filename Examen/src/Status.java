public class Status {
    public void status() { // вывод информации о заполненности аудиторий

        System.out.println("-----------------------" + "\n" +
                "Класс математики " + Main.consumer.classes.getMath().size() + "\n" +
                "Класс физики " + Main.consumer.classes.getPhysics().size() + "\n" +
                "Класс информатики " + Main.consumer.classes.getProgramming().size() + "\n" +
                "Класс физры " + Main.consumer.classes.getPhysicalEducation().size() + "\n" +
                "Класс литературы " + Main.consumer.classes.getLiterature().size() + "\n" +
                "-----------------------");
    }
}
