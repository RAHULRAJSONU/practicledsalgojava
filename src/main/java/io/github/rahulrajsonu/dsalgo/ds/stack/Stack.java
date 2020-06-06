package io.github.rahulrajsonu.dsalgo.ds.stack;

public class Stack {
  private int maxSize;
  private int[] stackArray;
  private int top;

  public Stack(int maxSize) {
    this.maxSize = maxSize;
    this.stackArray = new int[maxSize];
    this.top = -1;
  }

  public void push(int val){
    if(!this.isFull()){
      this.top++;
      this.stackArray[this.top] = val;
    }
  }

  public int pop() throws Exception {
    if(!this.isEmpty()){
      int top_temp = this.top;
      this.top--;
      return this.stackArray[top_temp];
    }else{
     throw new Exception("Nothing left here, Stack is empty!");
    }
  }

  public int peak(){
    return this.stackArray[this.top];
  }

  public boolean isEmpty(){
    return this.top==-1;
  }

  public boolean isFull(){
    return this.maxSize-1==this.top;
  }
}
