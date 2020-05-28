package com.silvertech.dsalgo.concurrency.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MakeString implements Runnable{

  Exchanger<String> ex;
  String str;

  public MakeString(Exchanger<String> exchanger) {
    this.ex = exchanger;
    str = new String();

    new Thread(this).start();
  }

  @Override
  public void run() {
    char ch = 'A';
    try {
      for(int i = 0; i < 3; i++){
        for(int j = 0; j < 5; j++) {
          str += ch++;
        }

        if(i==2){
          str = ex.exchange(str, 250, TimeUnit.MICROSECONDS);
          continue;
        }
        
        str = ex.exchange(str);
      }
    }catch (InterruptedException e){
      System.out.println(e);
    } catch (TimeoutException e) {
      System.out.println("Timeout Occurred!");
    }
  }
}
