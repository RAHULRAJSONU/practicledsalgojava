package com.silvertech.dsalgo.ds.linkedlist.circularLinkedList;

import com.silvertech.dsalgo.ds.linkedlist.singlylinkedList.Node;

public class CircularLinkedList {
  private Node first;
  private Node last;

  public CircularLinkedList(){
    this.first=null;
    this.last=null;
  }

  private boolean isEmpty() {
    return null==first;
  }

  public void insertFirst(int val){
    Node node = new Node();
    node.val = val;
    if(isEmpty()){
      this.last=node;
    }
    node.nextNode = this.first;
    this.first = node;
  }

  public void insertLast(int val){
    Node node = new Node();
    node.val=val;
    if(isEmpty()){
      this.first=node;
    }else{
      this.last.nextNode = node;
      this.last = node;
    }
  }

  public int deleteFirst(){
    int temp = this.first.val;
    if(null==this.first.nextNode){
      this.last = null;
    }
    this.first = this.first.nextNode;
    return temp;
  }

  public void display(){
    Node currentNode=first;
    System.out.print("[");
    while (null != currentNode){
      currentNode.displayNode();
      if(currentNode.nextNode !=null)System.out.print(",");
      currentNode = currentNode.nextNode;
    }
    System.out.print("]");
    this.first.displayNode();
    this.last.displayNode();
  }

}
