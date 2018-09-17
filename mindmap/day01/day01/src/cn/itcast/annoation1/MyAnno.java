package cn.itcast.annoation1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {

    //定义属性
    String name();
    int age();


}
