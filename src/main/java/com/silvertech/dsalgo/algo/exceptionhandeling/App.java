package com.silvertech.dsalgo.algo.exceptionhandeling;

public class App {

  public static void main(String[] args) {
    System.out.println(getNumber());
  }

  public static double getNumber(){
    try {
      System.out.println("executing try block!");
      return Math.random();
    }catch (Exception e){
      System.out.println(e);
    }finally {
      System.out.println("executing finally!");
    }
    return 0.0;
  }
}
