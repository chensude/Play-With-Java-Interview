package com.sort;

import java.lang.reflect.Method;

public class TestHelper<T> {

    /**
     * 判断数组是否有序，从小到大排序
     * @param arr
     * @param <T>
     * @return
     */
    public static  <T extends Comparable<T>> Boolean isSorted(T[] arr) {

        for(int i=0;i<arr.length;i++) {
            if(arr[i].compareTo(arr[i+1])>0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印数组所有内容
      */

    public static  <T extends Comparable<T>> void printArray(T[] arr) {

        for (int i = 0; i < arr.length; i++){
            System.out.print( arr[i] );
            System.out.print( ' ' );
        }
        System.out.println();

        return;
    }

    /**
     * 测试排序后的数组是否正确及运行时间
     */
    public static  <T extends Comparable<T>> void testSort(String sortClassName,T[] arr,int n) {

        try{
            Class sortClass = Class.forName(sortClassName);
            Method method = sortClass.getMethod("sort",Comparable[].class,int.class);

            Object[] param =  new Object[] {arr,n};

            long startTime = System.currentTimeMillis();
            // 调用排序函数
            method.invoke(null,param);

            long endTime = System.currentTimeMillis();

          //  printArray(arr);
            assert isSorted( arr );

            System.out.println( sortClass.getSimpleName()+ " : " + (endTime-startTime) + "ms" );
        }catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

}
