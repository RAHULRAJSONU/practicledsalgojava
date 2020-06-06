package io.github.rahulrajsonu.dsalgo.ds.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GenericStackTest {

  private GenericStack gs;

  @BeforeEach
  void setUp() {
    this.gs = new GenericStack(3);
  }

  @AfterEach
  void tearDown() {
    this.gs = null;
    System.gc();
  }

  @Test
  void push() {
    this.gs.push("I");
    this.gs.push("am");
    this.gs.push("Raj");
    assertEquals("Raj",this.gs.pop());
    assertEquals("am",this.gs.pop());
    assertEquals("I",this.gs.pop());
  }

  @Test
  void pop() {
    this.gs.push("I");
    this.gs.push("am");
    this.gs.push("Raj");
    assertEquals("Raj",this.gs.pop());
    assertEquals("am",this.gs.pop());
    assertEquals("I",this.gs.pop());
  }

  @Test
  void peak() {
    this.gs.push("I");
    this.gs.push("am");
    this.gs.push("Raj");
    assertEquals("Raj",this.gs.peak());
  }

  @Test
  void isFull() {
    this.gs.push("I");
    this.gs.push("am");
    this.gs.push("Raj");
    assertTrue(this.gs.isFull());
    this.gs.pop();
    assertFalse(this.gs.isFull());
  }

  @Test
  void isEmpty() {
    assertTrue(this.gs.isEmpty());
    this.gs.push("I");
    assertFalse(this.gs.isEmpty());
  }
}