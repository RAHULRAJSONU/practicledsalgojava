package io.github.rahulrajsonu.dsalgo.algo.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

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
public class PrintAllNodesAtKDistanceFromRoot {
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
    printAllAtKDistance(node, getNode(node,8),3).forEach(System.out::println);
  }

  private static TreeNode getNode(TreeNode root, int val) {
    if(val == root.val) return root;
    if(val < root.val) return getNode(root.left,val);
    else return getNode(root.right,val);
  }

  private static List<Integer> printAllAtKDistance(TreeNode node,TreeNode target, int k) {
    List<Integer> list = new LinkedList<>();
    List<TreeNode> visited = new LinkedList<>();
    Map<TreeNode, TreeNode> parentChildMap = new TreeMap<>();
    parentChildMap = buildParentChildMap(node);
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(target);
    while (!queue.isEmpty() && 0 < k){
      int size = queue.size();
      for (int m =0; m<size; m++) {
        TreeNode current = queue.poll();
        if (!visited.contains(current)) {
          visited.add(current);
        }
        if (null != parentChildMap.get(current) && !visited
            .contains(parentChildMap.get(current))) {
          queue.add(parentChildMap.get(current));
        }
        if (null != current.left && !visited.contains(current.left))
          queue.add(current.left);
        if (null != current.right && !visited.contains(current.right))
          queue.add(current.right);
      }
      k--;
    }
    queue.forEach(el->list.add(el.val));
    return list;
  }

  private static Map<TreeNode, TreeNode> buildParentChildMap(TreeNode root) {
    Map<TreeNode, TreeNode> parentChildMap = new TreeMap<>();
    if(null == root)return parentChildMap;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()){
      int size = queue.size();
      for (int m = 0; m < size; m++){
        TreeNode current = queue.remove();
        parentChildMap.putIfAbsent(current,current);
        if(null != current.left){
          parentChildMap.putIfAbsent(current.left, current);
          queue.add(current.left);
        }
        if(null != current.right){
          parentChildMap.putIfAbsent(current.right, current);
          queue.add(current.right);
        }
      }
    }
    return parentChildMap;
  }

  private static TreeNode insert(TreeNode root, int val) {
    TreeNode temp = new TreeNode(val);
    if(null == root) return temp;
    if(val < root.val)root.left = insert(root.left,val);
    else root.right = insert(root.right,val);
    return root;
  }

  private static List<List<Integer>> levelOrderTraversal(TreeNode node) {
    List<List<Integer>> lists = new ArrayList<>();
    if(null == node)return lists;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(node);
    while (!queue.isEmpty()){
      List<Integer> currentLevel = new ArrayList<>();
      int size = queue.size();
      for(int m = 0; m < size; m++){
        TreeNode current = queue.remove();
        currentLevel.add(current.val);
        if(null != current.left)queue.add(current.left);
        if(null != current.right)queue.add(current.right);
      }
      lists.add(currentLevel);
    }
    return lists;
  }
}
