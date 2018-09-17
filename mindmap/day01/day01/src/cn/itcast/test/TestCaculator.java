package cn.itcast.test;

import cn.itcast.annoation1.Caculator;
import org.junit.Test;

public class TestCaculator  {

    public void testAdd(){
        Caculator caculator = new Caculator();
        caculator.add(1, 1);
    }

    public void testMuni(){
        Caculator caculator = new Caculator();
        caculator.minu(1, 1);
    }
    @Test
    public void testMulty(){
        Caculator caculator = new Caculator();
        caculator.multy(1, 1);
    }
    @Test
    public void testBy(){
        Caculator caculator = new Caculator();
        caculator.by(1, 1);
    }
}
