package com.silvertech.dsalgo.algo.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReverseLinkedListTest {

  @Test
  void reverseIteratively() {
    Node head = new Node(1);
    head.next = new Node(5);
    head.next.next = new Node(10);
    head.next.next.next = new Node(15);
    head.next.next.next.next = new Node(20);
    Node reversed = ReverseLinkedList.reverseIteratively(head);
    assertEquals(20,reversed.data);
    assertEquals(15,reversed.next.data);
    assertEquals(10,reversed.next.next.data);
    assertEquals(5,reversed.next.next.next.data);
    assertEquals(1,reversed.next.next.next.next.data);
  }

  @Test
  void reverseRecursively() {
    Node head = new Node(1);
    head.next = new Node(5);
    head.next.next = new Node(10);
    head.next.next.next = new Node(15);
    head.next.next.next.next = new Node(20);
    Node reversed = ReverseLinkedList.reverseRecursively(head);
    assertEquals(20,reversed.data);
    assertEquals(15,reversed.next.data);
    assertEquals(10,reversed.next.next.data);
    assertEquals(5,reversed.next.next.next.data);
    assertEquals(1,reversed.next.next.next.next.data);
  }
}