package com.sort;

/**
 * @author chensude
 * 插入排序算法
 */
public class InsertionSort<T> {


    //第一个元素已经排好序了
    public static <T extends Comparable<T>>  void sort(T[] arr,int n) {
        //对[i+1,n)区间的元素进行插入排序
        for(int i=1;i<n;i++) {
            //当前元素和之前元素比较，找到适合的位置，j索引
            for(int j=i;j>0&&arr[j].compareTo(arr[j-1])<0;j--) {
                    Util.swap(arr,j,j-1);
            }
        }

    }



    public static void main(String[] args) {
 //测试一下算法结果是否正确
//        Integer[] arr = {9,8,7,6,5,4,3,2,1};
//        com.sort.InsertionSort.insertionSort(arr,9);
        int n =10000;
        Integer[] data = Util.generateRandomArray(n, 0, n);
        long startTime = System.currentTimeMillis();
        InsertionSort.sort(data,n);
        long endTime = System.currentTimeMillis();

        System.out.println("com.sort.InsertionSort test complete");
        System.out.println("Time cost:" + (endTime - startTime + " ms"));

    }


}


