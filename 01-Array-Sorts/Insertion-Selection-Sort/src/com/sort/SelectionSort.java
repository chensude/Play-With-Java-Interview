package com.sort;

/**
 * 选择排序算法
 */
public class SelectionSort<T> {


    public static <T extends Comparable<T>> void sort(T[] arr,int n) {


        //对[i,n)区间的元素最小值索引
        for (int i=0;i<n;i++) {
            int minIndex = i;
            for(int j=i+1;j<n;j++) {
                if(arr[minIndex].compareTo(arr[j])>0) {
                    minIndex = j;
                }

                Util.swap(arr,i,minIndex);
            }
        }
    }

    public static void main(String[] args) {
        int n =10000;
        Integer[] arr = Util.generateRandomArray(n, 0, n);
        TestHelper.testSort("com.sort.SelectionSort",arr,n);
    }
}
