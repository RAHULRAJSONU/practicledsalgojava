package com.silvertech.dsalgo.ds.linkedlist.doublyLinkedList;

public class App {

  public static void main(String[] args) {
    DoublyLinkedList dll = new DoublyLinkedList();
    dll.insertFirst(20);
    dll.insertFirst(30);
    dll.insertFirst(40);
    dll.insertFirst(50);
    dll.insertLast(10);
    dll.insertLast(60);
    dll.display();
    System.out.println("");
    dll.deleteLast();
    dll.deleteFirst();
    dll.display();
    System.out.println("");
    dll.insertAfter(20, 100);
    dll.display();
    System.out.println("");
    dll.deleteKey(10);
    dll.display();
  }
}
