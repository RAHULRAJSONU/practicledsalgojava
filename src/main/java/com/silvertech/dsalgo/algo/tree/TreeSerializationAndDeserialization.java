package com.silvertech.dsalgo.algo.tree;

import java.util.Arrays;
import java.util.LinkedList;
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
public class TreeSerializationAndDeserialization {

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
    String ser = serialize(node);
    System.out.println(ser);
    TreeNode tr = deSerialize(ser);
    String ser2 = serialize(tr);
    System.out.println(ser2);
  }

  public static String serialize(TreeNode tree){
    if(null == tree)return "X,";
    String left = serialize(tree.left);
    String right = serialize(tree.right);
    return String.valueOf(tree.val).concat(",").concat(left).concat(right);
  }

  public static TreeNode deSerialize(String str){
    Queue<String> queue = new LinkedList<>(Arrays.asList(str.split(",")));
    return deSerializeHelper(queue);
  }

  private static TreeNode deSerializeHelper(Queue<String> queue){
    String val = queue.poll();
    if("X".equals(val))return null;
    TreeNode node = new TreeNode(Integer.parseInt(val));
    node.left = deSerializeHelper(queue);
    node.right = deSerializeHelper(queue);
    return node;
  }

  public static TreeNode insert(TreeNode root, int val){
    TreeNode temp = new TreeNode(val);
    if(null==root)return temp;
    if(val < root.val)
      root.left = insert(root.left, val);
    else
      root.right = insert(root.right, val);
    return root;
  }

}
