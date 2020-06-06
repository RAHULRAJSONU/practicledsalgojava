package io.github.rahulrajsonu.dsalgo.ds.linkedlist.doublyLinkedList;

public class DoublyLinkedList {

  private Node first;
  private Node last;

  public DoublyLinkedList() {
    this.first = null;
    this.last = null;
  }

  public boolean isEmpty() {
    return null == this.first;
  }

  public void insertFirst(int val) {
    Node node = new Node();
    node.val = val;
    if (this.isEmpty()) {
      this.last = node;
    } else {
      this.first.previous = node;
    }
    node.next = this.first;
    this.first = node;
  }

  public void insertLast(int val) {
    Node node = new Node();
    node.val = val;
    if (isEmpty()) {
      this.first = node;
    } else {
      this.last.next = node;
      node.previous = this.last;
    }
    this.last = node;
  }

  public int deleteFirst() {
    int temp = this.first.val;
    if (this.first == null) {
      this.last = null;
    } else {
      this.first.next.previous = null;
    }
    this.first = this.first.next;
    return temp;
  }

  public int deleteLast() {
    int temp = this.last.val;
    if (this.last == null) {
      this.first = null;
    } else {
      this.last.previous.next = null;
    }
    this.last = this.last.previous;
    return temp;
  }

  public boolean insertAfter(int key, int val) {
    Node newNode = new Node();
    newNode.val = val;
    Node current = this.first;
//    iterate the list till we found the supplied key
    while (key != current.val) {
      current = current.next;
      if (null == current) {
        return false;
      }
    }
    if (null == current.next) {
      newNode.next = null;
      this.last = newNode;
    } else {
      newNode.next = current.next;
      current.next.previous = newNode;
    }
    newNode.previous = current;
    current.next = newNode;
    return true;
  }

  public boolean deleteKey(int key){
    Node current = this.first;
    while(key != current.val){
      current = current.next;
      if(null == current){
        return false;
      }
    }
    if(this.last == current){
      current.previous.next = null;
      this.last = current.previous;
    }else if(this.first == current){
      current.next.previous = null;
      this.first = current.next;
    }else{
      current.previous.next = current.next;
      current.next.previous = current.previous;
    }
    return true;
  }

  public void display() {
    Node cn = this.first;
    System.out.print("[");
    while (null != cn) {
      cn.display();
      cn = cn.next;
      if (null != cn) {
        System.out.print(",");
      }
    }
    System.out.print("]");
    System.out.print(this.first.val + "<->");
    System.out.print(this.last.val);
  }
}
