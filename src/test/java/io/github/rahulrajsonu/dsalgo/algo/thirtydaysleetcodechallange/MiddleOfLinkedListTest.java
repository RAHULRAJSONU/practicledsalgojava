package io.github.rahulrajsonu.dsalgo.algo.thirtydaysleetcodechallange;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MiddleOfLinkedListTest {

  @Test
  void getMiddleNode() {
    ListNode head = new ListNode(10);
    head.next = new ListNode(15);
    head.next.next = new ListNode(20);
    head.next.next.next = new ListNode(25);
    head.next.next.next.next = new ListNode(30);
    assertEquals(20, MiddleOfLinkedList.getMiddleNode(head).val);
  }
}