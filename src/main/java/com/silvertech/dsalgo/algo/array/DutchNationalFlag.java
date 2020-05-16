package com.silvertech.dsalgo.algo.array;

import com.silvertech.dsalgo.utility.Utils;

/**
 * API to solve dutch national flag problem
 * Given an array of zeros, ones and twos eg; {0,1,0,1,2,1,2,0,1}
 * Sort the array in-place with time complexity of O(n)
 * output should {0,0,0,1,1,1,1,2,2}
 * */
public class DutchNationalFlag {

  public void solve(int[] arr){
    int low = 0;
    int mid = 0;
    int high = arr.length-1;
    while (mid <= high){
      if(arr[mid]==0){
        Utils.swap(arr,low,mid);
        low++;
        mid++;
      }else if(arr[mid]==1){
        mid++;
      }else if(arr[mid]==2){
        Utils.swap(arr,mid,high);
        high--;
      }
    }
  }
}
