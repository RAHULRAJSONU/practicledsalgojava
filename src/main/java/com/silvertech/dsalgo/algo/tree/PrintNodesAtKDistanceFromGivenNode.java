package com.silvertech.dsalgo.algo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * practicledsalgojava
 * MIT License
 *
 * Copyright (c) 2020 Rahul Raj
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
public class PrintNodesAtKDistanceFromGivenNode {

  public static void main(String[] args) {
    TreeNode node = new TreeNode(10);
    node = insert(node,7);
    node = insert(node,6);
    node = insert(node,1);
    node = insert(node,8);
    node = insert(node,9);
    node = insert(node,11);
    node = insert(node,20);
    node = insert(node,14);
    node = insert(node,23);
    System.out.println(levelOrderTraversal(node));
    printAllAtKDistance(node, 2);
  }

  private static void printAllAtKDistance(TreeNode root, int k){
    if(null == root){
      return;
    }
    if(0 == k){
      System.out.println(root.val);
      return;
    }
    printAllAtKDistance(root.left,k-1);
    printAllAtKDistance(root.right,k-1);
  }

  private static TreeNode insert(TreeNode tree, Integer val){
    TreeNode temp = new TreeNode(val);
    if(null==tree)return temp;
    if(val < tree.val)tree.left =  insert(tree.left,val);
    else tree.right = insert(tree.right,val);
    return tree;
  }

  private static List<List<Integer>> levelOrderTraversal(TreeNode node){
    List<List<Integer>> lists = new ArrayList<>();
    if(null == node)return new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(node);
    while (!queue.isEmpty()){
      List<Integer> currentLevel = new ArrayList<>();
      int size = queue.size();
      for (int m = 0; m < size; m++){
        TreeNode current = queue.remove();
        currentLevel.add(current.val);
        if(null != current.left) queue.add(current.left);
        if(null != current.right) queue.add(current.right);
      }
      lists.add(currentLevel);
    }
    return lists;
  }

}
