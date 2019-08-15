package com.sort;

public class Util {
    private Util(){}

    public static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {

        assert n > 0 && rangeL <= rangeR;

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++)
            arr[i] = (int)(Math.random() * (rangeR - rangeL + 1)) + rangeL;
        return arr;
    }

    public static Integer[] generateOrderedArray(int n) {

        assert n > 0;

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++)
            arr[i] = i;
        return arr;
    }

    public static  <T extends Comparable<T>> void swap(T[] arr, int i, int j) {

        T temp = arr[i];
        arr[i] =arr[j];
        arr[j]=temp;
    }
}