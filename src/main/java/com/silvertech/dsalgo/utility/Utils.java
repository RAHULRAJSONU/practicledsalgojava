package com.silvertech.dsalgo.utility;

import com.silvertech.dsalgo.algo.thirtydaysleetcodechallange.Tree;

public class Utils {
  public static boolean isSorted(int[] arr){
    for (int el=1; el < arr.length; el++) {
      if(arr[el] < arr[el-1])return false;
    }
    return true;
  }

  public static void swap(int[] arr, int src, int dst) {
    arr[src] = arr[src]+arr[dst];
    arr[dst] = arr[src]-arr[dst];
    arr[src] = arr[src]-arr[dst];
  }

  public static boolean arrayDeepEqual(int[] arr, int[] expected) {
    if(arr.length != expected.length)return false;
    for (int m = 0; m < arr.length; m++) {
      if(arr[m]!=expected[m])return false;
    }
    return true;
  }

  public static Tree insertIntoBinaryTree(Tree root, int val){
    Tree newTree = new Tree(val);
    if(null==root)return newTree;
    if(val < root.val)root.left = insertIntoBinaryTree(root.left,val);
    else root.right = insertIntoBinaryTree(root.right,val);
    return root;
  }
}
