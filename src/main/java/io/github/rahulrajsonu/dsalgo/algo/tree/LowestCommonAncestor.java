package io.github.rahulrajsonu.dsalgo.algo.tree;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

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
public class LowestCommonAncestor {

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
    System.out.println(findLCA(node, new TreeNode(9), new TreeNode(8)).val);
  }

  public static TreeNode findLCA(TreeNode root, TreeNode x, TreeNode y){
    if(null == root)return null;
    if(root.val > max(x.val,y.val))return findLCA(root.left,x,y);
    else if(root.val < min(x.val,y.val)) return findLCA(root.right,x,y);
    return root;
  }

  public static TreeNode insert(TreeNode root, int val){
    TreeNode node = new TreeNode(val);
    if(null == root)return node;
    if(val < root.val)root.left= insert(root.left,val);
    else root.right = insert(root.right,val);
    return root;
  }

  public static List<List<Integer>> levelOrderTraversal(TreeNode root){
    List<List<Integer>> res = new ArrayList<>();
    if(null == root)return res;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()){
      int size = queue.size();
      List<Integer> currentLevel = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode current = queue.poll();
        currentLevel.add(current.val);
        if(null != current.left)queue.add(current.left);
        if(null != current.right)queue.add(current.right);
      }
      res.add(currentLevel);
    }
    return res;
  }
}
