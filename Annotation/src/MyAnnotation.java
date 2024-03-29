import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)

public @interface MyAnnotation {
    String name() default "Bob";
    long number() default 0;
    boolean showSomewhere() default false;

}
