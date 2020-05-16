package com.silvertech.dsalgo.algo.thirtydaysleetcodechallange;

import java.util.Arrays;

public class MoveZeroToTheEnd {
    public static void main(String[] args) {
        int[] arr = new int[]{1,0,1,0,3,13,23};
        moveZeroToEnd(arr);
        for (int el : arr) {
            System.out.print(el+", ");
        }
    }

    /**
     * API to shift zero to the end without reordering the other element
     * given array of int: {1,0,1,0,3,13,23}
     * Output should {1,1,3,13,23,0,0}
     * */
    private static void moveZeroToEnd(int[] arr) {
        int zeroIdx=0;
        for (int m = 1; m < arr.length; m++) {
            if(arr[zeroIdx]==0 && arr[m] !=0){
                int temp=arr[m];
                arr[m]=arr[zeroIdx];
                arr[zeroIdx]=temp;
                zeroIdx++;
            }else if(arr[zeroIdx] != 0){
                zeroIdx++;
            }
        }
    }
}
