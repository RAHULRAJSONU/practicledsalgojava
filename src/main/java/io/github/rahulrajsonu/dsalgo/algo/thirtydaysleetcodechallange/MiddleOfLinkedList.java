package io.github.rahulrajsonu.dsalgo.algo.thirtydaysleetcodechallange;

public class MiddleOfLinkedList {
  public static ListNode getMiddleNode(ListNode head){
    ListNode hare, tortoise;
    hare = tortoise = head;
    while (null != hare && null != hare.next){
      hare = hare.next.next;
      tortoise = tortoise.next;
    }
    return tortoise;
  }
}
