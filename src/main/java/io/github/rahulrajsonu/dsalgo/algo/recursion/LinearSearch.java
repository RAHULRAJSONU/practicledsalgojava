package io.github.rahulrajsonu.dsalgo.algo.recursion;

public class LinearSearch {

  public static void main(String[] args) {
    System.out.println(search(new int[]{2,4,6,8,9,10}, 6, 0));
  }

  public static int search(int[] arr, int val, int index){
    if(val == arr[index]){
      return index;
    }else if(index<arr.length){
      return search(arr,val,index+1);
    }else{
      return -1;
    }
  }

}
