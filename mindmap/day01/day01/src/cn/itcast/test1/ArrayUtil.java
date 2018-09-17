package cn.itcast.test1;

import org.junit.Assert;
import org.junit.Test;

public class ArrayUtil {

    public static int getSum(int[] arr){

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        int i=10/0;
        return sum;
    }

    public static int getMax(int[] arr){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
           if(arr[i] > max){
               max = arr[i];

           }
        }
        return max;
    }
    public static int getMin(int[] arr){

        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min){
                min = arr[i];

            }
        }
        int i=10/0;
        return min;
    }

}
