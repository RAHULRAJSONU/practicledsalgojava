package com.silvertech.dsalgo.ds.binarysearchtree;

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

import java.util.List;

/*
* Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [9,3,20,null,null,15,27],
    9
   / \
  3  20
    /  \
   15   27
return its level order traversal as:
[
  [9],
  [3,20],
  [15,17]
]
* */
public class BinaryTreeLevelOrderTraversal {

  public static void main(String[] args) {
    BST tree = new BST();
    tree.insert(9,"NINE");
    tree.insert(3,"THREE");
    tree.insert(20,"TWENTY");
    tree.insert(15,"FIFTEEN");
    tree.insert(17,"SEVENTEEN");
    tree.insert(37,"THIRTY SEVEN");
    tree.insert(47,"FOURTY SEVEN");
    tree.insert(25,"TWENTY FIVE");
    List<List<Integer>> res = tree.traverseByLevelOrder();
    System.out.println(res);
  }
}
