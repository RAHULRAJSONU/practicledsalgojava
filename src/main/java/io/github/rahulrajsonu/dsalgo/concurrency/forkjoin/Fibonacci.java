package io.github.rahulrajsonu.dsalgo.concurrency.forkjoin;

import java.util.concurrent.RecursiveTask;

public class Fibonacci extends RecursiveTask<Integer> {

  private final Integer number;

  public Fibonacci(Integer number) {
    this.number = number;
  }

  @Override
  protected Integer compute() {
    if(1 >= number)return number;
    Fibonacci f1 = new Fibonacci(number-1);
    f1.fork();
    Fibonacci f2 = new Fibonacci(number-2);
    f2.fork();
    return f1.join()+f2.join();
  }
}
