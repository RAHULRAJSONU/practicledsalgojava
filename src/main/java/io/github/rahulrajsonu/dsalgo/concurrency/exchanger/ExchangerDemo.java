package io.github.rahulrajsonu.dsalgo.concurrency.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerDemo {

  public static void main(String[] args) {
    Exchanger<String> exchanger = new Exchanger<>();
    new UseString(exchanger);
    new MakeString(exchanger);
  }
}
