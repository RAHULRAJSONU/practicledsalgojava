package io.github.rahulrajsonu.dsalgo.ds.heap.maxheap;

/*
 * practicledsalgojava
 * MIT License
 *
 * Copyright (c) 2020 Rahul Raj
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
public class Heap {
  private Node[] heapArray;
  private int maxSize; // max size of the array
  private int currentSize; // Numbers of node in the array

  public Heap(final int size){
    this.maxSize = size;
    this.currentSize = 0;
    this.heapArray = new Node[size];
  }

  public static void main(String[] args) {
    Heap heap = new Heap(8);
    heap.insert(17);
    heap.insert(15);
    heap.insert(9);
    heap.insert(1);
    heap.insert(12);
    heap.insert(3);
    heap.insert(8);
    heap.insert(20);
    System.out.println(heap);
    heap.delete();
    System.out.println(heap);
    heap.insert(20);
    System.out.println(heap);
  }

  public int getSize(){
    return currentSize;
  }

  public boolean isEmpty(){
    return (currentSize == 0);
  }

  public boolean insert(int key){
    if(currentSize == maxSize)return false;
    Node newNode = new Node(key);
    heapArray[currentSize] = newNode;
    tricleUp(currentSize);
    currentSize++;
    return true;
  }

  public Node delete(){
    Node toDelete = heapArray[--currentSize];
    heapArray[0] = heapArray[currentSize];
    heapArray[currentSize] = null;
    int topIndex = 0;
    while (topIndex < currentSize/2){
      int maxId;
      int leftChildId = (2*topIndex)+1;
      int rightChildId = (2*topIndex)+2;
      if(leftChildId < currentSize-1 && rightChildId < currentSize-1) {
        maxId = heapArray[leftChildId].getKey() > heapArray[rightChildId].getKey() ? leftChildId
            : rightChildId;
      }else {
        break;
      }
      Node temp = heapArray[maxId];
      heapArray[maxId] = heapArray[topIndex];
      heapArray[topIndex] = temp;
      topIndex = maxId;
    }
    return toDelete;
  }

  private void tricleUp(int id) {
    int parentId = (id-1)/2;
    Node nodeToInsert = heapArray[id];
    while(id > 0 && heapArray[parentId].getKey() < nodeToInsert.getKey()){
      heapArray[id] = heapArray[parentId];
      id = parentId;
      parentId = (id-1)/2;
    }
    heapArray[id] = nodeToInsert;
  }

  public void displayHeap() {
    System.out.println("Heap Array: ");
    for(int m = 0; m < currentSize; m++) {
      if(heapArray[m] != null) {
        System.out.print( heapArray[m].getKey() + " ");
      }
      System.out.println();

      int nBlanks = 32;
      int itemsPerRow = 1;
      int column = 0;
      int j = 0; // current item

      String dots = "...............................";
      System.out.println(dots+dots);
      while(currentSize > 0) {
        if(column == 0) {
          for(int k = 0; k < nBlanks; k++) {
            System.out.print(" ");
          }
        }
        System.out.print(heapArray[j].getKey());
        j++;
        if(j == currentSize) {
          break;
        }

        column++;
        // end of row
        if(column == itemsPerRow) {
          nBlanks = nBlanks/2; // half the blanks
          itemsPerRow = itemsPerRow * 2;     // twice the items
          column = 0;
          System.out.println();
        } else {
          for(int k=0; k<nBlanks*2; k++) {
            System.out.print(" ");
          }
        }

      }
      System.out.println("\n"+dots+dots);
    }
  }

  public String toString()
  {
    int idx = 0;
    String returnVal = "";
    int indot = (int)Math.floor(Math.sqrt(currentSize));
    returnVal += "--------------------------------------------------------------------------------------------------------\n\n";

    for(int i = 0; i < currentSize; i++)
    {
      for(int j =  (indot+1)*2; j > 0; j--)
      {
        returnVal += "\t";
      }

      returnVal += heapArray[i].getKey()+"\t";

      if(i == idx){
        returnVal += "\n";
        idx = (idx+1)*2;
        indot--;
      }

    }
    returnVal += "\n--------------------------------------------------------------------------------------------------------\n";
    return returnVal;
  }
}
