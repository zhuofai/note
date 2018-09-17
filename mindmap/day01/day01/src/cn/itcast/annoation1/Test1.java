package cn.itcast.annoation1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@MyAnno(name ="豆腐妹",age=18)
public class Test1 {
    public static void main(String[] args) throws Exception {
       /* //获取name和age的值
        //1.获取字节码对象
        Class cls = Test1.class;
        //2.获取类上的注解对象
        MyAnno annotation = (MyAnno) cls.getAnnotation(MyAnno.class);
        //3.获取注解上的属性值
        int age = annotation.age();
        String name = annotation.name();

        System.out.println(name+","+ age);*/

       Test1 test1 = new Test1();
        test1.method();
    }
    @MyAnno(name="梅军建",age=16)
    public void method() throws Exception {
        //打印梅军建和16
        //1.获取字节码
        Class aClass = this.getClass();
        Method method = aClass.getMethod("method");
        //获取method上的注解
        MyAnno myAnno = method.getAnnotation(MyAnno.class);

        String name = myAnno.name();
        int age = myAnno.age();
        System.out.println(name+","+age);


    }
}
