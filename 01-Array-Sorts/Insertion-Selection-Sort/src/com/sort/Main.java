package com.sort;

import java.util.Arrays;

/**
 * 比较不同排序算法的性能
 */
public class Main {

    public static void main(String[] args) {
        int n =20000;
        Integer[] arr1 = Util.generateRandomArray(n, 0, n);
        Integer[] arr2 = Arrays.copyOf(arr1,arr1.length);
        TestHelper.testSort("com.sort.SelectionSort",arr1,n);
        TestHelper.testSort("com.sort.InsertionSort",arr2,n);
    }
}
