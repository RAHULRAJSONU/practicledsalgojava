package com.silvertech.dsalgo.ds.queue;

public class Queue {

  private int maxSize;
  private long[] store;
  private int front;
  private int rear;
  private int size;

  public Queue(int maxSize) {
    this.maxSize = maxSize;
    this.store = new long[maxSize];
    this.front = 0;
    this.rear = -1;
  }

  public void insert(long val) {
    if (this.rear == this.maxSize - 1) {
      this.rear = -1;
    }
    this.rear++;
    this.store[this.rear] = val;
    this.size++;
  }

  public long remove() {
    if (!this.isEmpty()) {
      long temp = this.store[this.front];
      this.front++;
      if (this.front == this.maxSize - 1) {
        this.front = 0;
      }
      this.size--;
      return temp;
    } else {
      throw new RuntimeException("Nothing left, I am empty!");
    }
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public boolean isFull() {
    return this.maxSize == this.size;
  }
}
