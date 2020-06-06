package io.github.rahulrajsonu.dsalgo.ds.binarysearchtree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
public class BST {
  private Node root;

  public static void main(String[] args) {
    BST tree = new BST();
    tree.insert(35,"Allen");
    tree.insert(25,"john");
    tree.insert(29,"smith");
    tree.insert(40,"doe");
    tree.insert(36,"Allen");
    tree.insert(38,"Sam");
    tree.insert(48,"Shaun");
    tree.insert(44,"Clark");
    tree.insert(46,"Berry");
    tree.displayTree();
    tree.delete(40);
    tree.displayTree();
  }

  // Logic for inserting into the tree
  public void insert(int key, String val){
    Node newNode = new Node(key,val);
    if(null==root){
      root = newNode;
    }else {
      Node current = root;
      Node parent = null;
      while (true){
        parent = current;
        if(key < current.key){
          current = current.left;
          if(null == current){
            parent.left = newNode;
            break;
          }
        }else {
          current = current.right;
          if (null == current){
            parent.right = newNode;
            break;
          }
        }
      }
    }
  }

  public String minimum(){
    if(null == root){
      return null;
    }else{
      Node current = root;
      Node parent = null;
      while (true){
        parent = current;
        current = current.left;
        if(null == current){
          return parent.value;
        }
      }
    }
  }

  public String maximum(){
    if(null==root){
      return null;
    }else{
      Node current = root;
      Node parent = null;
      while (true){
        parent = current;
        current = current.right;
        if(null == current){
          return parent.value;
        }
      }
    }
  }

  public boolean delete(int key){
    if(null != root){
      Node current = root;
      Node parent = null;
      boolean isLeft = false;
      while (key != current.key){
        parent = current;
        if(key < current.key){
          current = current.left;
          isLeft = true;
        }else{
          current = current.right;
          isLeft = false;
        }
        if(null == current){
          return false;
        }
      }
      // check and delete if target is leaf node
      if(current.left == null && current.right==null){
        if(isLeft){
          parent.left = null;
          return true;
        }else if(parent != null) {
          parent.right = null;
          return true;
        }
      }
      // check and delete if target has only one child
      if(current.right == null){
        if(current == root){
          root = current.left;
        }else if(isLeft){
          parent.left = current.left;
        }else {
          parent.right = current.left;
        }
      }else if(current.left == null){
        if(current == root){
          root = current.right;
        }else if(isLeft){
          parent.left = current.right;
        }else {
          parent.right = current.right;
        }
      }
      else {
        // check and delete if target has two child
        Node successor = findMin(current);
        if(current == root){
          root = successor;
        }
        else if(isLeft){
          parent.left = successor;
        }else {
          parent.right = successor;
        }
        successor.left = current.left;
      }
    }
    return true;
  }

  private Node findMin(Node node){
    Node successorParent = node;
    Node successor = node;
    Node current = node.right;
    while (current != null){
      successorParent = successor;
      successor = current;
      current = current.left;
    }
    if(successor != node.right){
      successorParent.left = successor.right;
      successor.right = node.right;
    }
    return successor;
  }

  public List<List<Integer>> traverseByLevelOrder(){
    List<List<Integer>> result = new ArrayList<>();
    if(root == null){
      return result;
    }
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()){
      int size = queue.size();
      List<Integer> currentLevel = new ArrayList<>();
      for (int m =0; m<size; m++) {
        Node current = queue.remove();
        currentLevel.add(current.key);
        if (null != current.left) {
          queue.add(current.left);
        }
        if (null != current.right) {
          queue.add(current.right);
        }
      }
      result.add(currentLevel);
    }
    return result;
  }

  public void displayTree() {
    Stack globalStack = new Stack();
    globalStack.push(root);
    int nBlanks = 32;
    boolean isRowEmpty = false;
    System.out.println("......................................................");

    while(isRowEmpty==false) {
      Stack localStack = new Stack();
      isRowEmpty = true;
      for(int j=0; j<nBlanks; j++) {
        System.out.print(" ");
      }

      while(globalStack.isEmpty()==false) {
        Node temp = (Node)globalStack.pop();
        if(temp != null) {
          System.out.print(temp.key);
          localStack.push(temp.left);
          localStack.push(temp.right);
          if(temp.left != null || temp.right != null) {
            isRowEmpty = false;
          }
        } else {
          System.out.print("--");
          localStack.push(null);
          localStack.push(null);
        }

        for(int j=0; j<nBlanks*2-2; j++) {
          System.out.print(" ");
        }
      }

      System.out.println();
      nBlanks = nBlanks/2;

      while(localStack.isEmpty()==false)
        globalStack.push( localStack.pop() );
    }
    System.out.println( "......................................................");

  }

  @Override
  public String toString() {
    return "BST{" +
        "root=" + root +
        '}';
  }
}
