package com.silvertech.dsalgo.algo.sort;

public class SelectionSort {

  public static void main(String[] args) {
    for(int a : sort(new int[]{3,2,6,7,1,4,9,5})){
      System.out.print(a+",");
    }
  }

  public static int[] sort(int[] arr){
    for(int i=0;i<arr.length;i++){
      for(int j=i+1;j<arr.length;j++){
        if(arr[i]>arr[j]){
          int temp= arr[j];
          arr[j]=arr[i];
          arr[i]=temp;
        }
      }
    }
    return arr;
  }

}
