package com.silvertech.dsalgo.algo.sort;

public class QuickSort {

  public static void main(String[] args) {
    int[] inputArray = new int[]{5,2,7,1,0,1,9,45};
    sort(inputArray,0,7);
    for(int a: inputArray){
      System.out.println(a);
    }
  }

  public static void sort(int[] arr, int start, int end){
    if(start >= end)return;
    int partitionKey = partition(arr,start,end);
    sort(arr,start,partitionKey-1);
    sort(arr,partitionKey+1,end);
  }

  private static int partition(int[] inputArr, int start, int end){
    int pivot = inputArr[end];
    int i = start-1;
    int j = start;
    while (j<=end){
      if(inputArr[j] <= pivot){
        i++;
        int temp = inputArr[i];
        inputArr[i] = inputArr[j];
        inputArr[j] = temp;
      }
      j++;
    }
    if(i<end){
      int t = inputArr[i+1];
      inputArr[i+1] = inputArr[end];
      inputArr[end] = t;
    }
    return i;
  }

}
