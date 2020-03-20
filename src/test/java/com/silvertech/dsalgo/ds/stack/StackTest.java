package com.silvertech.dsalgo.ds.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {

  private Stack st;

  @BeforeEach
  void createInstance(){
    this.st = new Stack(4);
  }

  @AfterEach
  void destroyInstance(){
    this.st = null;
    System.gc();
  }

  @Test
  void push() {
    this.st.push(10);
    this.st.push(20);
    this.st.push(30);
    try {
      Assertions.assertEquals(30, this.st.pop());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  void pop() {
    this.st.push(10);
    this.st.push(20);
    try {
      Assertions.assertEquals(20, this.st.pop());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  void peak() {
    this.st.push(10);
    this.st.push(20);
    Assertions.assertEquals(20, this.st.peak());
  }

  @Test
  void isEmpty() {
    this.st.push(10);
    this.st.push(20);
    assertFalse(this.st.isEmpty());
    try {
      this.st.pop();
      this.st.pop();
    } catch (Exception e) {
      e.printStackTrace();
    }
    assertTrue(this.st.isEmpty());
  }

  @Test
  void isFull() {
    this.st.push(10);
    this.st.push(20);
    this.st.push(30);
    this.st.push(40);
    assertTrue(this.st.isFull());
  }
}