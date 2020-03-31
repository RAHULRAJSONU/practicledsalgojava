package com.silvertech.dsalgo.algo.tree;

import java.util.Stack;

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
public class TreeTraversalMechanism {

  public static void main(String[] args) {
    TreeTraversalMechanism tree = new TreeTraversalMechanism();
    TreeNode node = new TreeNode(10);
    node = tree.insert(node,7);
    node = tree.insert(node,6);
    node = tree.insert(node,1);
    node = tree.insert(node,8);
    node = tree.insert(node,9);
    node = tree.insert(node,11);
    node = tree.insert(node,20);
    node = tree.insert(node,14);
    node = tree.insert(node,23);
//    System.out.println(tree.preOrderSerialize(node));
    System.out.println(tree.preOrderSerialize(node));
  }
  public TreeNode insert(TreeNode root, int val){
    TreeNode temp = new TreeNode(val);
    if(null==root)return temp;
    if(val < root.val)
      root.left = insert(root.left, val);
    else
      root.right = insert(root.right, val);
    return root;
  }

  public boolean isSymatric(){

    return true;
  }

  public String preOrderSerialize(TreeNode root){
    if(null==root)return "X,";
    String left = preOrderSerialize(root.left);
    String right = preOrderSerialize(root.right);
    String leftDel = null!=left?left:"";
    String rightDel = null!=right?right:"";
    return root.val+","+left+right;
  }

  public String preOrderSerializeIterative(TreeNode root){
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    String result = "";
    while (!stack.isEmpty()){
     TreeNode temp = stack.pop();
     result = result.concat(String.valueOf(temp.val)+",");
     if(null!=temp.right)stack.push(temp.right);
     if(null!=temp.left)stack.push(temp.left);
    }
    return result;
  }

  public String inOrderSerialization(TreeNode root){
    if(null == root)return null;
    String left = inOrderSerialization(root.left);
    String right = inOrderSerialization(root.right);
    String leftDel = null!=left?left:"";
    String rightDel = null!=right?right:"";
    return leftDel+root.val+","+rightDel;
  }

  public String inOrderSerializationIterative(TreeNode root){
    String result = "";
    if(null != root) {
      Stack<TreeNode> stack = new Stack<>();
      stack.push(root);
      while (!stack.isEmpty()) {
        if (null != root.left){
          root = root.left;
          stack.push(root);
        }else{
          TreeNode node = stack.pop();
          result = result.concat(String.valueOf(node.val)+",");
          if(null != node.right) {
            root = node.right;
            stack.push(root);
          }
        }
      }
    }
    return result;
  }

  public String postOrderSerialization(TreeNode root){
    if(null==root)return null;
    String left = postOrderSerialization(root.left);
    String right = postOrderSerialization(root.right);
    String leftDel = null!=left?left:"";
    String rightDel = null!=right?right:"";
    return leftDel+rightDel+root.val+",";
  }

  public String postOrderSerializationIterative(TreeNode root){
    Stack<TreeNode> stack = new Stack<>();
    TreeNode current = root;
    String result = "";
    while (null != current || (!stack.isEmpty())){
      if(null != current){
        stack.push(current);
        current = current.left;
      }else {
        TreeNode temp = stack.peek().right;
        if(null == temp){
          temp = stack.pop();
          result = result.concat(String.valueOf(temp.val).concat(","));
          while (!stack.isEmpty() && temp == stack.peek().right){
            temp = stack.pop();
            result = result.concat(String.valueOf(temp.val).concat(","));
          }
        }else {
          current = temp;
        }
      }
    }
    return result;
  }
}

class TreeNode{
  int val;
  TreeNode left;
  TreeNode right;
  public TreeNode(int val){
    this.val = val;
  }
}
