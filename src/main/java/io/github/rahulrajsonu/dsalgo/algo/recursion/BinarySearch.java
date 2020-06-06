package io.github.rahulrajsonu.dsalgo.algo.recursion;

public class BinarySearch {

  public static void main(String[] args) {
    System.out.println(search(new int[]{2,4,6,8,9,10},0,5,10));
  }

  public static int search(int[] arr, int start, int end, int keyword){
    int mid = (start+end)/2;
    if(keyword == arr[mid]) {return mid;}
    else if(keyword < mid) {end = mid-1; return search(arr,start,end,keyword);}
    else if(keyword > mid) {start = mid+1; return search(arr,start,end,keyword);}
    else {return -1;}
  }
}
