package cn.itcast.annotation;

public @interface MyAnno {
    String name() default "梅军建";
    int value();
    int[] arr();

}
