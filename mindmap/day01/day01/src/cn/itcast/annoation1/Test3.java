package cn.itcast.annoation1;

import java.lang.reflect.Method;

public class Test3 {

    public static void main(String[] args) throws Exception {

        //1.获取TestCaculator的字节码
        Class testCaculatorClass = TestCaculator.class;
        //拿到所有的方法
        Method[] methods = testCaculatorClass.getMethods();

        for (Method method : methods) {
            //判断每一个method上面有没有注解
            if(method.isAnnotationPresent(MyAnnoCalculator.class)){
                method.invoke(testCaculatorClass.newInstance());
            }
        }
    }
}
