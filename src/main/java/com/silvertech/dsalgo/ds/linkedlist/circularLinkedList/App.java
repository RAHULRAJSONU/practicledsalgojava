package com.silvertech.dsalgo.ds.linkedlist.circularLinkedList;

public class App {
  public static void main(String[] args) {
    CircularLinkedList sll = new CircularLinkedList();
    sll.insertFirst(20);
    sll.insertFirst(40);
    sll.insertFirst(80);
    sll.insertFirst(100);
    sll.insertLast(234);
    sll.deleteFirst();
    sll.display();
  }
}
