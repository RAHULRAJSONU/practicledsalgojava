package com.silvertech.dsalgo.ds.stack;

import java.util.List;

public class GenericStack {
  private Object[] stackArray;
  private int maxSize;
  private int top;

  public GenericStack(int maxSize) {
    this.maxSize = maxSize;
    this.stackArray=new Object[this.maxSize];
    this.top=-1;
  }

  public void push(Object val){
    if(!this.isFull()){
      this.top++;
      this.stackArray[top] = val;
    }
  }

  public Object pop(){
    if(!isEmpty()){
      int top_old = this.top;
      this.top--;
      return this.stackArray[top_old];
    }else{
      throw new RuntimeException("Nothing left here, Stack is empty!");
    }
  }

  public Object peak(){
    if(!isEmpty()){
      return this.stackArray[this.top];
    }else{
      throw new RuntimeException("Nothing left here, Stack is empty!");
    }
  }

  public boolean isFull(){
    return this.maxSize-1==this.top;
  }

  public boolean isEmpty(){
    return this.top == -1;
  }
}
