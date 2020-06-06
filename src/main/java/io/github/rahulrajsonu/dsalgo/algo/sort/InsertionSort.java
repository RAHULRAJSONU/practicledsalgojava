package io.github.rahulrajsonu.dsalgo.algo.sort;

public class InsertionSort {

  public static void main(String[] args) {
    for(int a: sort(new int[]{3,2,5,3,7,4,89,34,1})){
      System.out.print(a+" ,");
    }
  }

  public static int[] sort(int[] arr){
    for(int i=1; i<arr.length;i++){
      int element = arr[i];
      int j=i-1;
      while (j >= 0 && arr[j] > element){
        arr[j+1] = arr[j];
        j--;
      }
      arr[j+1] = element;
    }
    return arr;
  }

}
