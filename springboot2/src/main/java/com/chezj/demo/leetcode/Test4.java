package com.chezj.demo.leetcode;

/**
 * 冒泡排序
 */
public class Test4 {
    public static void bubbleSort1(int [] a,int n){
        int i,j;
        for (i=0;i<n;i++){
            for (j=1;j<n-i;j++){
                if (a[j-1]>a[j]){
                    int temp;
                    temp=a[j-1];
                    a[j-1]=a[j];
                    a[j]=temp;
                }
            }
        }
    }

    public static void bubbleSort(int [] a){
        int i,j;
        for (i=a.length-1;i>0;i--){
            for (j=0;j<i;j++){
                if (a[j-1]>a[j]){
                    int temp;
                    temp=a[j-1];
                    a[j-1]=a[j];
                    a[j]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int [] a = {9,8,7,6,5,4,3,1,2,22,33,45,66,99};
        bubbleSort1(a,a.length);
        for (int k =0;k<a.length;k++){
            System.out.print(a[k]+" ");
        }
    }
}
