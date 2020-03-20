package com.silvertech.dsalgo.algo.sort;

public class MergeSort {

  public static void main(String[] args) {
    int[] inputAr = new int[]{2,4,1,7,5,3};
    sort(inputAr,0,5);
    for(int a: inputAr){
      System.out.println(a);
    }
  }

  public static void sort(int[] arr, int start, int end){
    if(start >= end){
      return;
    }
    int mid = (end+start)/2;
    sort(arr,start,mid);
    sort(arr,mid+1,end);
    merge(arr, start, mid, end);
  }

  private static void merge(int[] arr, int start, int mid, int end){
    int[] tempArray = new int[end-start+1];
    int leftSlot = start;
    int rightSlot = mid+1;
    int counter = 0;
    while(leftSlot <= mid && rightSlot <= end){
      if(arr[leftSlot] < arr[rightSlot]){
        tempArray[counter] = arr[leftSlot];
        leftSlot++;
      }else {
        tempArray[counter] = arr[rightSlot];
        rightSlot++;
      }
      counter++;
    }

    if(leftSlot <= mid){
      while (leftSlot <= mid){
        tempArray[counter] = arr[leftSlot];
        leftSlot++;
        counter++;
      }
    }else if(rightSlot <= end){
      while (rightSlot <= end){
        tempArray[counter] = arr[rightSlot];
        rightSlot++;
        counter++;
      }
    }

    for(int i = 0; i< tempArray.length; i++){
      arr[start+i] = tempArray[i];
    }
  }

}
