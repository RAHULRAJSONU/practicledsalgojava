package io.github.rahulrajsonu.dsalgo.algo.tree;

import static java.lang.Integer.max;

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
public class BalancedTreeTest {

  public static void main(String[] args) {
    TreeNode node = new TreeNode(10);
    node = insert(node,7);
    node = insert(node,6);
    node = insert(node,11);
    node = insert(node,20);
    System.out.println(checkIfTreeIsBalanced(node));
  }

  private static boolean checkIfTreeIsBalanced(TreeNode root) {
    if(null==root)return true;
    int leftHeight = getTreeHeight(root.left);
    int rightHeight = getTreeHeight(root.right);
    int absoluteVal = Math.abs(leftHeight-rightHeight);
    if(absoluteVal <= 1 &&
        checkIfTreeIsBalanced(root.left ) &&
        checkIfTreeIsBalanced(root.right)){
      return true;
    }
    else{
      return false;
    }
  }

  private static int getTreeHeight(TreeNode root) {
    if(null==root)return 0;
    int leftHeight = getTreeHeight(root.left);
    int rightHeight = getTreeHeight(root.right);
    return max(leftHeight,rightHeight)+1;
  }

  private static TreeNode insert(TreeNode root, int val) {
    TreeNode temp = new TreeNode(val);
    if(null==root)return temp;
    if(val < root.val)root.left=insert(root.left,val);
    else root.right = insert(root.right,val);
    return root;
  }

}
