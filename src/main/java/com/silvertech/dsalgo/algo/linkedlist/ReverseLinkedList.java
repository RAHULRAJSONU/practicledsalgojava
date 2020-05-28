package com.silvertech.dsalgo.algo.linkedlist;

public class ReverseLinkedList {
  public static Node reverseIteratively(Node head){
    Node prev = null;
    Node curr = head;
    Node next = null;
    while(null != curr){
      next = curr.next; // save the next
      curr.next = prev; //reverse
      prev = curr; //advance prev
      curr = next; //advance prev
    }
    return prev; // new head at end
  }

  public static Node reverseRecursively(Node head){
    if(null==head || null==head.next){
      return head;
    }
    Node reversedHead = reverseRecursively(head.next);
    head.next.next = head;
    head.next = null;
    return reversedHead;
  }
}
