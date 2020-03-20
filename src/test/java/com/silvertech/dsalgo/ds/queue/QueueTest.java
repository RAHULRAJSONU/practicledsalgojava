package com.silvertech.dsalgo.ds.queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueTest {

  private Queue q;

  @BeforeEach
  void setUp() {
    this.q = new Queue(3);
  }

  @AfterEach
  void tearDown() {
    this.q = null;
    System.gc();
  }

  @Test
  void insert() {
    this.q.insert(10);
    this.q.insert(20);
    this.q.insert(30);
//    assertEquals(10,this.q.remove());
    this.q.insert(40);
    assertEquals(40,this.q.remove());
  }

  @Test
  void remove() {
    this.q.insert(10);
    this.q.insert(20);
    this.q.remove();
    assertEquals(20,this.q.remove());
  }

  @Test
  void isEmpty() {
    this.q.insert(10);
    assertFalse(this.q.isEmpty());
    this.q.remove();
    assertTrue(this.q.isEmpty());
  }

  @Test
  void isFull() {
    this.q.insert(10);
    this.q.insert(10);
    assertFalse(this.q.isFull());
    this.q.insert(10);
    assertTrue(this.q.isFull());
  }
}