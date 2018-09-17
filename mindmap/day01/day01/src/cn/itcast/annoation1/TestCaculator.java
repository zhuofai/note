package cn.itcast.annoation1;


import org.junit.Test;

public class TestCaculator {
    @MyAnnoCalculator
    public void testAdd(){
        Caculator caculator = new Caculator();
        int add = caculator.add(1, 1);
        System.out.println(1);
    }

    public void testMuni(){
        Caculator caculator = new Caculator();
        caculator.minu(1, 1);
        System.out.println(2);
    }

    public void testMulty(){
        Caculator caculator = new Caculator();
        caculator.multy(1, 1);
        System.out.println(3);
    }
    @MyAnnoCalculator
    public void testBy(){
        Caculator caculator = new Caculator();
        caculator.by(1, 1);
        System.out.println(4);
    }
}
