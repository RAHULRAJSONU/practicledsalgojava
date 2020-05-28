package com.silvertech.dsalgo.concurrency.exchanger;

import java.util.concurrent.Exchanger;

public class UseString implements Runnable{

  Exchanger<String> ex;
  String str;

  public UseString(Exchanger<String> exchanger) {
    this.ex = exchanger;
    new Thread(this).start();
  }

  @Override
  public void run() {
    try{
      for(int i = 0; i < 3; i++){
        if(i==2){
          Thread.sleep(500);
          continue;
        }
        str = ex.exchange(new String());
        System.out.println("Got: "+str);
      }
    }catch (InterruptedException e){
      System.out.println(e);
    }
  }
}
