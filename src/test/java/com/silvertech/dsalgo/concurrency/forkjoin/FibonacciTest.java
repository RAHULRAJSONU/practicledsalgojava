package com.silvertech.dsalgo.concurrency.forkjoin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FibonacciTest {

  @Test
  void compute() {
    assertEquals(34,new Fibonacci(9).compute());
  }
}