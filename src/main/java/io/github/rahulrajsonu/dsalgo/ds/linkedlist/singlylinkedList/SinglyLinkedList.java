package io.github.rahulrajsonu.dsalgo.ds.linkedlist.singlylinkedList;

public class SinglyLinkedList {
  private Node first;

  public SinglyLinkedList() {
  }

  public boolean isEmpty(){
    return first==null;
  }

  public void insertFirst(int val){
    Node node = new Node();
    node.val=val;
    node.nextNode = this.first;
    this.first = node;
  }

  public int deleteFirst(){
    Node temp = this.first.nextNode;
    this.first = temp;
    return temp.val;
  }

  public void insertLast(int val){
    Node currentNode = this.first;
    while (null != currentNode.nextNode){
      currentNode = currentNode.nextNode;
    }
    Node node = new Node();
    node.val=val;
    currentNode.nextNode = node;
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
  }
}
