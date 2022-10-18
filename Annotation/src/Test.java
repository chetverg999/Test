public class Test { // класс с тестовыми методами

    @MyAnnotation(name = "hello", number = 1, showSomewhere = true)
    public void hello() {
        System.out.println("hello");
    }

    @MyAnnotation(name = "bye", number = 2, showSomewhere = false)
    public void bye() {
        System.out.println("bye");
    }


    public void noHello() {
        System.out.println("noHello");
    }


    public void noBye() {
        System.out.println("noBye");
    }
}
