package com.silvertech.dsalgo.algo.binarysearch;

public class BinarySearch {

  public static void main(String[] args) {
    int[] a = {2,4,6,8,10,45,55,59};
    System.out.println(search(a,55));
  }

  public static int search(int[] arr, int val) {
    int p = 0;
    int r = arr.length-1;
    while (p<=r){
      int q = (p+r)/2;
      if(val<arr[q]) r = q-1;
      else if(val>arr[q]) p = q+1;
      else return q;
    }
    return -1;
  }
}
