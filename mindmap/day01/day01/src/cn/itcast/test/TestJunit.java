package cn.itcast.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestJunit {
    @Before
    public void method(){
        System.out.println("Before执行了");
    }
    @Test
    public void method1(){
        System.out.println("method1执行了");
    }
    @Test
    public void method2(){
        System.out.println("method2执行了");
    }
    @After
    public void method4(){
        System.out.println("After执行了");
    }
}
