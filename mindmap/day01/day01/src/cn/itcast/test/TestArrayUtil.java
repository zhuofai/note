package cn.itcast.test;

import cn.itcast.test1.ArrayUtil;
import org.junit.Test;

public class TestArrayUtil {

    @Test
    public void testGetMax(){
        int[] arr = {1,2,3,4};
        int max = ArrayUtil.getMax(arr);
        // System.out.println(max);
        //Assert.assertEquals(1, max);
    }
    @Test
    public void testGetSum(){
        int[] arr = {1,2,3,4};
        int sum = ArrayUtil.getSum(arr);
        //  System.out.println(sum);
        // Assert.assertEquals(1, sum);
    }
    @Test
    public void testGetMin(){
        int[] arr = {1,2,3,4};
        int min = ArrayUtil.getMin(arr);
        //  System.out.println(sum);
        // Assert.assertEquals(1, min);
    }
}
