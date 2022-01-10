package com.atguigu.java1;
import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;
/**
 * @author KeyboardHero
 * @create 2022-01-10 19:42
 */
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    String value()default "hello";
}
