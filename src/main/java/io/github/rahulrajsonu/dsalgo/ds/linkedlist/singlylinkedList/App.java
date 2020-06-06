package io.github.rahulrajsonu.dsalgo.ds.linkedlist.singlylinkedList;

public class App {

  public static void main(String[] args) {
    SinglyLinkedList sll = new SinglyLinkedList();
    sll.insertFirst(20);
    sll.insertFirst(40);
    sll.insertFirst(80);
    sll.insertFirst(100);
    sll.insertLast(234);
    sll.deleteFirst();
    sll.display();
  }

}
